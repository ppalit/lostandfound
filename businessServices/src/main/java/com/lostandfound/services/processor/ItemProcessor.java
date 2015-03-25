package com.lostandfound.services.processor;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

import com.lostandfound.common.bean.RegisterItemBean;
import com.lostandfound.common.bean.ReporterBean;

public interface ItemProcessor {
	public int getCount(String reporterId);
	
	public long saveItem(RegisterItemBean registerItemBean) throws SolrServerException, IOException;
	
	public ReporterBean fetchReporter(String emailId);
	
	public RegisterItemBean fetchItem(int itemId);
	
	public List<RegisterItemBean> fetchItems();

}
