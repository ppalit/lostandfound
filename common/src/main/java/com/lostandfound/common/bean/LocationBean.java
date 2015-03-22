package com.lostandfound.common.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String streetAddress;
	private String lat;
	private String lng;
	private String locType;
	private String city;
	private String country;
	private String state;
	
	public LocationBean() {
		super();
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}
	/**
	 * @return the lng
	 */
	public String getLng() {
		return lng;
	}
	/**
	 * @param lng the lng to set
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}
	/**
	 * @return the locType
	 */
	public String getLocType() {
		return locType;
	}
	/**
	 * @param locType the locType to set
	 */
	public void setLocType(String locType) {
		this.locType = locType;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LocationBean ["
				+ (id != null ? "id=" + id + ", " : "")
				+ (streetAddress != null ? "streetAddress=" + streetAddress
						+ ", " : "") + (lat != null ? "lat=" + lat + ", " : "")
				+ (lng != null ? "lng=" + lng + ", " : "")
				+ (locType != null ? "locType=" + locType + ", " : "")
				+ (city != null ? "city=" + city + ", " : "")
				+ (country != null ? "country=" + country + ", " : "")
				+ (state != null ? "state=" + state : "") + "]";
	}

	
	
	
}
