package com.lostandfound.common.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String imageId;
	private byte[] imageBytes;
	private String imageUrl;
	
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public byte[] getImageBytes() {
		return imageBytes;
	}
	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@Override
	public String toString() {
		return "ImageBean ["
				+ (imageId != null ? "imageId=" + imageId + ", " : "")
				+ (imageUrl != null ? "imageUrl=" + imageUrl : "") + "]";
	}
	
	
	
	


}
