package com.lostandfound.services.utils;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "solrUtils")
public class SolrUtils {
	
	Logger logger = LoggerFactory.getLogger(SolrUtils.class);
	@Value("${search_url}")
	private String url;
	
	private SolrClient server;
	
	public SolrClient getServer() {
		if (server== null){
			if( url == null){
				logger.error("env is null");
			}
			else{
			
			this.server = new HttpSolrClient(url);;
			}	
		}
		return server;
	}

}
