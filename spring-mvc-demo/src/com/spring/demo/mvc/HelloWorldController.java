package com.spring.demo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// en basina bunu tanimladigimiz icin bu parent mapping oldu
// showform ve processform da sub mapping
// bunu yapmanin sebebi baska controller ile cakismasin diye
@RequestMapping("hello")
public class HelloWorldController {
	
	// need a controller method to show the initial HTML form
	
	@RequestMapping("showForm")
	public String showForm()
	{
		return "helloworld-form";
		
	}
	
	// need a controller method to process the HTML form
	
	@RequestMapping("processForm")
	public String processForm()
	{
		return "helloworld";
		
	}
	
	// new a controller method to read form data and
	// add data to the model
	
	@RequestMapping("processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model)
	{
		// request data yi tutan parametre, model ise conteiner misali
		// içine data atip kullanabilecegaimiz parametre
		
		// read the request parameter from the HTML form
		
		String name= request.getParameter("studentName");
		// convert the data to all caps
		name=name.toUpperCase();
		// create the message
		String result= "Hey!"+ name;
		// add message to the model
		model.addAttribute("message",result);
		// message modelin ismi oldu
		return "helloworld";
	}
	@RequestMapping("processFormVersionThree")
	public String letsShoutPal(
			@RequestParam("studentName") String name, Model model)
	{
		// request data yi tutan parametre, model ise conteiner misali
		// içine data atip kullanabilecegaimiz parametre
		
		// read the request parameter from the HTML form
		

		// convert the data to all caps
		name=name.toUpperCase();
		// create the message
		String result= "La! "+ name;
		// add message to the model
		model.addAttribute("message",result);
		// message modelin ismi oldu
		return "helloworld";
	}
	
	
	
	
}
