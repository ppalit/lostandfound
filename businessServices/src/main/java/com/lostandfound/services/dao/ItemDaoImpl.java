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

import com.lostandfound.common.bean.RegisterItemBean;
import com.lostandfound.common.bean.ReporterBean;

@Repository(value = "itemDaoImpl")
public class ItemDaoImpl implements ItemDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
	}

	public int countRecords(String reporterId) {

		String sql = "select count(*) from item_primary where reporter_id = :reporterId";

		SqlParameterSource namedParameters = new MapSqlParameterSource(
				"reporterId", reporterId);

		return this.namedParameterJdbcTemplate.queryForObject(sql,
				namedParameters, Integer.class);
	}

	public int insertFoundItem(RegisterItemBean registerItemBean) {
		String query = "INSERT INTO item_primary(category ,sub_category ,public_description,secret_description , item_found_date ,"
				+ "street_address, lat , lng , loc_type , city , country , state ,reporter_id , colour)"
				+ "VALUES (:category,:sub_category,:public_description,:secret_description,:item_found_date,"
				+ ":street_address, :lat , :lng , :loc_type , :city , :country , :state , :reporter_id , :colour)";
		
		Map<String, String> namedParameters = new HashMap<String, String>();
		namedParameters.put("category", registerItemBean.getCategory());
		namedParameters.put("sub_category", registerItemBean.getSubCategory());
		namedParameters.put("public_description",registerItemBean.getPublicDescription());
		namedParameters.put("secret_description", registerItemBean.getSecretDescription());
		namedParameters.put("item_found_date", registerItemBean.getFoundDate());
		namedParameters.put("colour", registerItemBean.getItemColor());
		
		
		namedParameters.put("lat", registerItemBean.getLocation().getLat());
		namedParameters.put("lng", registerItemBean.getLocation().getLng());
		namedParameters.put("loc_type", registerItemBean.getLocation().getLocType());
		namedParameters.put("street_address", registerItemBean.getLocation().getStreetAddress());
		namedParameters.put("city", registerItemBean.getLocation().getCity());
		namedParameters.put("country", registerItemBean.getLocation().getCountry());
		namedParameters.put("state", registerItemBean.getLocation().getState());
		
		namedParameters.put("reporter_id", registerItemBean.getReporter().getEmailId());
		
		namedParameterJdbcTemplate.update(query, namedParameters);
		
		return getItemId();
	}

	public boolean insertReporter(ReporterBean reporterBean) {
		String query = "INSERT INTO reporter (first_name, last_name, email_id,phone_no) VALUES (:firstName,:lastName,:emailId,:phoneNo)";
		Map<String, String> namedParameters = new HashMap<String, String>();
		namedParameters.put("firstName", reporterBean.getFirstName());
		namedParameters.put("lastName", reporterBean.getLastName());
		namedParameters.put("emailId", reporterBean.getEmailId());
		namedParameters.put("phoneNo", reporterBean.getPhoneNo());
		namedParameterJdbcTemplate.update(query, namedParameters);
		return true;

	}

	private int getItemId() {
		String tableName = "item_primary";
		String sql = "SELECT seq FROM sqlite_sequence WHERE name= :tableName";
		SqlParameterSource namedParameters = new MapSqlParameterSource(
				"tableName", tableName);
		return this.namedParameterJdbcTemplate.queryForObject(sql,
				namedParameters, Integer.class);
	}

	public ReporterBean getReporter(String emailId) {
		String sql = "SELECT first_name,last_name,phone_no FROM reporter WHERE email_id= :emailId";
		SqlParameterSource namedParameters = new MapSqlParameterSource(
				"emailId", emailId);
		ReporterBean reporterBean = (ReporterBean) namedParameterJdbcTemplate
				.query(sql, namedParameters, new ReporterMapper());
		return reporterBean;
	}
	
	
	public List<RegisterItemBean> getItems(String searchString) {
		String sql = "SELECT item_id ,category ,sub_category ,public_description,secret_description , item_found_date ,"
				+ "street_address, lat , lng , loc_type , city , country , state ,reporter_id , colour FROM item_primary";
		//SqlParameterSource namedParameters = new MapSqlParameterSource("colour", searchString);
		List<RegisterItemBean> items  = new ArrayList<RegisterItemBean>();
		items = (List<RegisterItemBean>) namedParameterJdbcTemplate
				.query(sql,new ItemMapper());
		return items;
	}

	public RegisterItemBean getItem(int itemId) {
		String sql = "SELECT item_id, category ,sub_category ,public_description,secret_description , item_found_date ,"
				+ "street_address, lat , lng , loc_type , city , country , state ,reporter_id , colour FROM item_primary WHERE item_id= :itemId";
		SqlParameterSource namedParameters = new MapSqlParameterSource(
				"itemId", itemId);
		List<RegisterItemBean> items = (List<RegisterItemBean>) namedParameterJdbcTemplate
				.query(sql, namedParameters, new ItemMapper());
		return items.get(0);
	}

}
