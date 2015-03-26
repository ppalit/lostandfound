package com.lostandfound.webface.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

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
	
	private String sectionName;
	
	private String uiLocation;
	
	private List<String> categories;
	
	@ManagedProperty("#{searchSessionBean}")
	private SearchSessionBean searchSessionBean;
	
	
	@PostConstruct
	public void init(){
		regItemBean = new RegisterItemBean();
		sectionName="section1";
		if(searchSessionBean!=null && searchSessionBean.getEmailId()!=null){
			regItemBean.getReporter().setEmailId(searchSessionBean.getEmailId());
		}
		LOGGER.info("Called Post Construct of RegisterController");
	}
	
	public String register(){
		
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.postForObject("http://webfront-373876434.us-east-1.elb.amazonaws.com/business-services/V1/item", regItemBean, String.class);
		System.out.println(response.toString());
		
	return null;
	}
	
	public String updateSection(){
		FacesContext fc = FacesContext.getCurrentInstance();
	      Map<String,String> params = 
	      fc.getExternalContext().getRequestParameterMap();
	      this.sectionName= params.get("section") ; 
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

	/**
	 * @return the categories
	 */
	public List<String> getCategories() {
		if(categories==null || categories.size()==0){
			categories= new ArrayList<String>();
			categories.add("Animals & Pet Supplies");categories.add("Apparel & Accessories");
			categories.add("Arts & Entertainment");categories.add("Business & Industrial");
			categories.add("Cameras & Optics");categories.add("Electronics");
			categories.add("");categories.add("");
			categories.add("");categories.add("");
			categories.add("");categories.add("");
			categories.add("");categories.add("");
			categories.add("");categories.add("");
			categories.add("");categories.add("");
			categories.add("");categories.add("");
			
		}
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	/**
	 * @return the sectionName
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * @param sectionName the sectionName to set
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
}
