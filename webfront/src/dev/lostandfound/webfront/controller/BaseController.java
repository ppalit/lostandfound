package dev.lostandfound.webfront.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;



@Controller
@Scope("request")
public class BaseController {

	public String getSuccess(){
	// Set the message here
		System.out.println("Success");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Call success", "success");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        
	     return "success";
	}
}
