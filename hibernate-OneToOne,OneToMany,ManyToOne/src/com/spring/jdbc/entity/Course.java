package com.spring.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="course")
public class Course {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade = {
						CascadeType.DETACH ,
						CascadeType.MERGE,
						CascadeType.PERSIST,
						CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Reviews> reviews;
	public Course() {
	
	}

	public Course(String title) {
		
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}

	public void addReview(Reviews theReviews)
	{
		if (reviews==null) {
			reviews= new ArrayList<>();
		}
		reviews.add(theReviews);
		
		
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	} 
	
}