package com.lostandfound.common.bean;

import java.io.Serializable;

public class ReporterBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String fullName;
	private String emailId;
	private String phoneNo;
	private String userId;
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReporterBean ["
				+ (fullName != null ? "fullName=" + fullName + ", " : "")
				+ (emailId != null ? "emailId=" + emailId + ", " : "")
				+ (phoneNo != null ? "phoneNo=" + phoneNo + ", " : "")
				+ (userId != null ? "userId=" + userId : "") + "]";
	}


	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}


	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
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


	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	
	

}
