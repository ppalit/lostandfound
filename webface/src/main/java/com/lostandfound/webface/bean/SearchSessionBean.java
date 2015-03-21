package com.lostandfound.webface.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class SearchSessionBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String searchQuery;
	
	private String emailId;
	
	/**
	 * @return the searchQuery
	 */
	public String getSearchQuery() {
		return searchQuery;
	}

	/**
	 * @param searchQuery the searchQuery to set
	 */
	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}
	
	public String navigate(){
		return "searchResult";
	}
	
	
	public String registerItem(){
		if(emailId!=null){
		return	"registerLandingPage";
		}else{
		return	"loginLandingPage";
		}
	}
	

	public String getRegisterItem(){
		return registerItem();
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
