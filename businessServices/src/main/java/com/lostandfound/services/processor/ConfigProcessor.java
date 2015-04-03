package com.lostandfound.services.processor;

import java.util.List;

import com.lostandfound.common.bean.ConfigBean;

public interface ConfigProcessor {
	
	public List<ConfigBean> getConfigs(String configType, String parent, String order,boolean includeSub);
	
	public String getConfigValue(int configId);
	

}
