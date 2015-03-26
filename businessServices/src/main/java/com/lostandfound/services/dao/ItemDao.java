package com.lostandfound.services.dao;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

import com.lostandfound.common.bean.RegisterItemBean;

public interface ItemDao {
	
	 public int countRecords(String reporterId);
	 
	 public int insertFoundItem(RegisterItemBean registerItemBean); 
	 
	 public List<RegisterItemBean> getItems();
	 
	 public RegisterItemBean getItem(int itemId);
	 
	 public int saveToSolr(RegisterItemBean registerItemBean) throws SolrServerException, IOException;
	 
}
