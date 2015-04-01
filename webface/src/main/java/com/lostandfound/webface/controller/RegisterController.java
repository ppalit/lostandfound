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
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
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
	
	private List<SelectItem> categories;
	
	private List<SelectItem> subCategories;
	
	@ManagedProperty("#{searchSessionBean}")
	private SearchSessionBean searchSessionBean;
	
	
	@PostConstruct
	public void init(){
		regItemBean = new RegisterItemBean();
		if(StringUtils.isBlank(sectionName)){
			sectionName="section1";
		}
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


	
	/**
	 * @return the categories
	 */
	public List<SelectItem> getCategories() {
		if(categories==null || categories.size()==0){
			categories= new ArrayList<SelectItem>();
			categories.add(new SelectItem("Animals & Pet Supplies"));
			categories.add(new SelectItem("Apparel & Accessories"));
			categories.add(new SelectItem("Arts & Entertainment"));
			categories.add(new SelectItem("Business & Industrial"));
			categories.add(new SelectItem("Cameras & Optics"));
			categories.add(new SelectItem("Electronics"));
		}
		
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<SelectItem> categories) {
		this.categories = categories;
	}

	/**
	 * @return the subCategories
	 */
	public List<SelectItem> getSubCategories() {
		
		if(subCategories==null || subCategories.size()==0){
			subCategories= new ArrayList<SelectItem>();
			subCategories.add(new SelectItem("Animals & Pet Supplies Sub"));
			subCategories.add(new SelectItem("Apparel & Accessories  Sub"));
			subCategories.add(new SelectItem("Arts & Entertainment Sub"));
			subCategories.add(new SelectItem("Business & Industrial Sub"));
			subCategories.add(new SelectItem("Cameras & Optics Sub"));
			subCategories.add(new SelectItem("Electronics Sub"));
		}
		
		return subCategories;
	}

	/**
	 * @param subCategories the subCategories to set
	 */
	public void setSubCategories(List<SelectItem> subCategories) {
		this.subCategories = subCategories;
	}
}
