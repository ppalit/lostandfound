package dev.lof.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.lof.controller.bean.RegisterItemBean;


@ManagedBean(name="registerController")
@SessionScoped
public class RegisterController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7253438094710062403L;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RegisterController.class);
	private RegisterItemBean regItemBean;
	
	private String userName;
	
	
	@PostConstruct
	public void init(){
		regItemBean = new RegisterItemBean();
		LOGGER.info("Called Post Construct of RegisterController");
	}
	
	public String register(){
		System.out.println(regItemBean.toString());
		
	return null;
	}


	/**
	 * @return the regItemBean
	 */
	public RegisterItemBean getRegItemBean() {
		return regItemBean;
	}


	/**
	 * @param regItemBean the regItemBean to set
	 */
	public void setRegItemBean(RegisterItemBean regItemBean) {
		this.regItemBean = regItemBean;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
