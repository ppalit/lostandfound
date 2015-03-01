package dev.lostandfound.webfront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		String message = "<br><div align='center'>"
				+ "<h3>********** Sampele for Lost and found home page **********<br><br>";
		return new ModelAndView("welcome", "message", message);
	}

}
