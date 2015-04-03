package com.lostandfound.common.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 163350592495047077L;
	private int config_id;
	private String config_type;
	private int config_parent;
	private String config_key;
	private String config_value;
	private List<ConfigBean> subConfig;
	
	
	public int getConfig_id() {
		return config_id;
	}
	public void setConfig_id(int config_id) {
		this.config_id = config_id;
	}
	public String getConfig_type() {
		return config_type;
	}
	public void setConfig_type(String config_type) {
		this.config_type = config_type;
	}
	public int getConfig_parent() {
		return config_parent;
	}
	public void setConfig_parent(int config_parent) {
		this.config_parent = config_parent;
	}
	public String getConfig_key() {
		return config_key;
	}
	public void setConfig_key(String config_key) {
		this.config_key = config_key;
	}
	public String getConfig_value() {
		return config_value;
	}
	public void setConfig_value(String config_value) {
		this.config_value = config_value;
	}
	public List<ConfigBean> getSubConfig() {
		return subConfig;
	}
	public void setSubConfig(List<ConfigBean> subConfig) {
		this.subConfig = subConfig;
	}
	
	
	
	

}
