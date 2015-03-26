package com.lostandfound.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lostandfound.common.bean.ReporterBean;

public class ReporterMapper implements RowMapper<ReporterBean> {

	public ReporterBean mapRow(ResultSet rs, int arg1) throws SQLException {
		ReporterBean reporter = new ReporterBean();
		reporter.setFirstName(rs.getString("first_name"));
		reporter.setLastName(rs.getString("last_name"));
		reporter.setPhoneNo(rs.getString("phone_no"));
		reporter.setEmailId(rs.getString("email_id"));
		reporter.setLoginChanel(rs.getString("login_channel"));
		
		return reporter;
	}

}
