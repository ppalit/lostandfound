package com.lostandfound.services.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.lostandfound.common.bean.ReporterBean;

@Repository(value = "reporterDaoImpl")
public class ReporterDaoImpl implements ReporterDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}

	public int countRecords(String reporterId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ReporterBean getReporter(String emailId) {
		String sql = "SELECT first_name,last_name,phone_no,login_channel,email_id FROM reporter WHERE email_id in (:emailId) ";
		SqlParameterSource namedParameters = new MapSqlParameterSource(
				"emailId", emailId);
		List<ReporterBean> reporters = (List<ReporterBean>)namedParameterJdbcTemplate
				.query(sql, namedParameters, new ReporterMapper());
		if(reporters.size() == 0){
			return null;
		}
		return reporters.get(0);
		
	}

	public List<ReporterBean> getAllReporters() {
		String sql = "SELECT first_name,last_name,phone_no,login_channel ,email_id FROM reporter";
		List<ReporterBean> reporters  = new ArrayList<ReporterBean>();
		reporters = (List<ReporterBean>) namedParameterJdbcTemplate
				.query(sql,new ReporterMapper());
		return reporters;
	}

	public boolean insertReporter(ReporterBean reporterBean) {
		String query = "INSERT INTO reporter (first_name, last_name, email_id,phone_no,login_channel) VALUES (:firstName,:lastName,:emailId,:phoneNo,:loginChannel)";
		Map<String, String> namedParameters = new HashMap<String, String>();
		namedParameters.put("firstName", reporterBean.getFirstName());
		namedParameters.put("lastName", reporterBean.getLastName());
		namedParameters.put("emailId", reporterBean.getEmailId());
		namedParameters.put("phoneNo", reporterBean.getPhoneNo());
		namedParameters.put("loginChannel", reporterBean.getLoginChanel());
		namedParameterJdbcTemplate.update(query, namedParameters);
		return true;

	}
	
	public boolean updateReporter(ReporterBean reporterBean) {
		String query = "UPDATE reporter set first_name=:firstName, last_name=:lastName,phone_no=:phoneNo,login_channel=:loginChannel WHERE email_id=:emailId";
		Map<String, String> namedParameters = new HashMap<String, String>();
		namedParameters.put("firstName", reporterBean.getFirstName());
		namedParameters.put("lastName", reporterBean.getLastName());
		namedParameters.put("emailId", reporterBean.getEmailId());
		namedParameters.put("phoneNo", reporterBean.getPhoneNo());
		namedParameters.put("loginChannel", reporterBean.getLoginChanel());
		namedParameterJdbcTemplate.update(query, namedParameters);
		return true;

	}
		
}
