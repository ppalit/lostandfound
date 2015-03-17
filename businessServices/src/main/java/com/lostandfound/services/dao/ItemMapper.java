package com.lostandfound.services.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lostandfound.common.bean.RegisterItemBean;

public class ItemMapper implements RowMapper<RegisterItemBean> {

	public RegisterItemBean mapRow(ResultSet rs, int arg1)
			throws SQLException {
		RegisterItemBean item = new RegisterItemBean();
		item.setCategory(rs.getString("first_name"));
		item.setItemColor(rs.getString("colour"));
		return item;
	}

}
