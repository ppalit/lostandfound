package dev.lof.controller.bean;

import java.util.Date;

public class SearchRelsultBean {

	private Long id;
	private String type;
	private String description;
	private Date lostorFoundDate;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the lostorFoundDate
	 */
	public Date getLostorFoundDate() {
		return lostorFoundDate;
	}
	/**
	 * @param lostorFoundDate the lostorFoundDate to set
	 */
	public void setLostorFoundDate(Date lostorFoundDate) {
		this.lostorFoundDate = lostorFoundDate;
	}
	
}