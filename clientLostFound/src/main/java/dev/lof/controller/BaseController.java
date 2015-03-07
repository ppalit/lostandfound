package dev.lof.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;




public class BaseController  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage(){
	     return "success";
	}
}
