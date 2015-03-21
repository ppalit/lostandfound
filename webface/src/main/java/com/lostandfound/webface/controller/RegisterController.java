package com.lostandfound.webface.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lostandfound.common.bean.RegisterItemBean;
import com.lostandfound.webface.bean.SearchSessionBean;


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
	
	private String uiLocation;
	
	@ManagedProperty("#{searchSessionBean}")
	private SearchSessionBean searchSessionBean;
	
	
	@PostConstruct
	public void init(){
		regItemBean = new RegisterItemBean();
		if(searchSessionBean!=null && searchSessionBean.getEmailId()!=null){
			regItemBean.getReporter().setEmailId(searchSessionBean.getEmailId());
		}
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

	/**
	 * @return the uiLocation
	 */
	public String getUiLocation() {
		return uiLocation;
	}

	/**
	 * @param uiLocation the uiLocation to set
	 */
	public void setUiLocation(String uiLocation) {
		this.uiLocation = uiLocation;
	}

	/**
	 * @return the searchSessionBean
	 */
	public SearchSessionBean getSearchSessionBean() {
		return searchSessionBean;
	}

	/**
	 * @param searchSessionBean the searchSessionBean to set
	 */
	public void setSearchSessionBean(SearchSessionBean searchSessionBean) {
		this.searchSessionBean = searchSessionBean;
	}
}
