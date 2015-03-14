package com.lostandfound.services.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


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

}
