package dev.lof.controller.bean;

import java.io.Serializable;

public class ReporterBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String fullName;
	private String emailId;
	private String phoneNo;
	private String userId;
	
	
	/**
	 * @return the userName
	 */
	private String getFullName() {
		return fullName;
	}
	/**
	 * @param userName the userName to set
	 */
	private void setUserName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the emailId
	 */
	private String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	private void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the phoneNo
	 */
	private String getPhoneNo() {
		return phoneNo;
	}
	/**
	 * @param phoneNo the phoneNo to set
	 */
	private void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	
	
	
	

}
