package com.lostandfound.services.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.lostandfound.common.bean.ConfigBean;
import com.lostandfound.common.bean.ReporterBean;

@Repository(value = "configDaoImpl")
public class ConfigDaoImpl implements ConfigDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	Logger logger = LoggerFactory.getLogger(ItemDaoImpl.class);
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}

	public String getConfigValue(int id) {
		String sql = "SELECT config_value FROM APP_CONFIG WHERE config_id=:id";
		SqlParameterSource namedParameters = new MapSqlParameterSource(
				"id", id);
		String value= this.namedParameterJdbcTemplate.queryForObject(sql,
				namedParameters, String.class);
		logger.info("XXX  value "+value);
		return value;
	}

	public List<ConfigBean> getConfigs(String configType, String parent,
			String order) {
		String sql = "SELECT config_id,config_type,config_parent,config_key,config_value,order_num FROM APP_CONFIG where config_type=:configType";
		SqlParameterSource namedParameters = new MapSqlParameterSource(
				"configType", configType);
		List<ConfigBean> configs  = new ArrayList<ConfigBean>();
		configs = (List<ConfigBean>) namedParameterJdbcTemplate
				.query(sql,namedParameters,new ConfigMapper());
		return configs;
	}

	
}
