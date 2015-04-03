package com.lostandfound.services.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.lostandfound.common.bean.ConfigBean;
import com.lostandfound.services.dao.ConfigDao;

@Component(value = "configProcessorImpl")
public class ConfigProcessorImpl implements ConfigProcessor{
	

	@Autowired
	@Qualifier("configDaoImpl")
	ConfigDao configDao;

	public List<ConfigBean> getConfigs(String configType, String parent,
			String order, boolean includeSub) {
		
		return configDao.getConfigs(configType, parent, "ASC");
	}

	public String getConfigValue(int configId) {
		return configDao.getConfigValue(configId);
	}
	
		
}
