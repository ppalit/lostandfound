package dev.lof.controller.bean;

import java.io.Serializable;
import java.util.Arrays;

public class RegisterItemBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 163350592495047077L;
	
	private String userName;
	private String itemType;
	private String itemColor;
	private String Desciption;
	private String FoundDate;
	private byte[] image;
	private String Location;
	private String emailID;
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
	 * @return the itemType
	 */
	public String getItemType() {
		return itemType;
	}
	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	/**
	 * @return the itemColor
	 */
	public String getItemColor() {
		return itemColor;
	}
	/**
	 * @param itemColor the itemColor to set
	 */
	public void setItemColor(String itemColor) {
		this.itemColor = itemColor;
	}
	/**
	 * @return the desciption
	 */
	public String getDesciption() {
		return Desciption;
	}
	/**
	 * @param desciption the desciption to set
	 */
	public void setDesciption(String desciption) {
		Desciption = desciption;
	}
	/**
	 * @return the foundDate
	 */
	public String getFoundDate() {
		return FoundDate;
	}
	/**
	 * @param foundDate the foundDate to set
	 */
	public void setFoundDate(String foundDate) {
		FoundDate = foundDate;
	}
	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return Location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		Location = location;
	}
	/**
	 * @return the emailID
	 */
	public String getEmailID() {
		return emailID;
	}
	/**
	 * @param emailID the emailID to set
	 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RegisterItemBean [userName=" + userName + ", itemType="
				+ itemType + ", itemColor=" + itemColor + ", Desciption="
				+ Desciption + ", FoundDate=" + FoundDate + ", image="
				+ Arrays.toString(image) + ", Location=" + Location
				+ ", emailID=" + emailID + "]";
	}
	
	
	public String getBeanString(){
		return this.toString();
	}
	

}
