package com.lostandfound.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lostandfound.common.bean.ConfigBean;

public class ConfigMapper implements RowMapper<ConfigBean> {

	//config_id,config_type,config_parent,config_key,config_value,order_num
	public ConfigBean mapRow(ResultSet rs, int arg1) throws SQLException {
		ConfigBean configBean = new ConfigBean();
		configBean.setConfig_id(rs.getInt("config_id"));
		configBean.setConfig_key(rs.getString("config_key"));
		configBean.setConfig_parent(rs.getInt("config_parent"));
		configBean.setConfig_type(rs.getString("config_type"));
		configBean.setConfig_value(rs.getString("config_value"));
			
		return configBean;
	}

}
