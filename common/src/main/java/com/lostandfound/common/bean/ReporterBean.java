package com.lostandfound.common.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReporterBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String emailId;
	private String phoneNo;
	private String firstName;
	private String lastName;
	private String loginChanel;
	
	

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


	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}


	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLoginChanel() {
		return loginChanel;
	}


	public void setLoginChanel(String loginChanel) {
		this.loginChanel = loginChanel;
	}


	@Override
	public String toString() {
		return "ReporterBean ["
				+ (emailId != null ? "emailId=" + emailId + ", " : "")
				+ (phoneNo != null ? "phoneNo=" + phoneNo + ", " : "")
				+ (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName + ", " : "")
				+ (loginChanel != null ? "loginChanel=" + loginChanel : "")
				+ "]";
	}

	

}
