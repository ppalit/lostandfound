package com.lostandfound.services.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.lostandfound.common.bean.RegisterItemBean;
import com.lostandfound.common.bean.ReporterBean;


@Repository(value = "itemDaoImpl")
public class ItemDaoImpl implements ItemDao{
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
    
    public int countRecords(String reporterId) {

        String sql = "select count(*) from item_primary where reporter_id = :reporterId";

        SqlParameterSource namedParameters = new MapSqlParameterSource("reporterId", reporterId);

        return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
    }

	public boolean insertFoundItem(RegisterItemBean registerItemBean) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean insertReporter(ReporterBean reporterBean) {
		
			String query = "INSERT INTO reporter (first_name, last_name, email_id,phone_no) VALUES (:firstName,:lastName,:emailId,:phoneNo)";
			Map<String, String>namedParameters = new HashMap();
			namedParameters.put("firstName", reporterBean.getFirstName());
			namedParameters.put("lastName", reporterBean.getLastName());
			namedParameters.put("emailId", reporterBean.getEmailId());
			namedParameters.put("phoneNo", reporterBean.getPhoneNo());
			namedParameterJdbcTemplate.update(query, namedParameters);
			return true;
		
	}

	public int getItemId() {
		 String tableName= "item_primary";
		 String sql = "SELECT seq FROM sqlite_sequence WHERE name= :tableName";
		 SqlParameterSource namedParameters = new MapSqlParameterSource("tableName", tableName); 
		return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
	}

}
