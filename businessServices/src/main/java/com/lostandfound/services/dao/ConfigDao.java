package com.lostandfound.services.dao;

import java.util.List;

import com.lostandfound.common.bean.ConfigBean;

public interface ConfigDao {
	
	public String getConfigValue(int id);
	
	public List<ConfigBean> getConfigs(String configType, String parent, String order);

}
