package com.lostandfound.services.utils;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "solrUtils")
public class SolrUtils {
	
	@Value("${search_url}")
	private String url;
	
	private SolrClient server;
	
	public SolrClient getServer() {
		if (server== null){
			if( url == null){
				System.out.println("env is null");
			}
			else{
			
			this.server = new HttpSolrClient(url);;
			}	
		}
		return server;
	}

}
