package com.lostandfound.webface.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lostandfound.common.bean.SearchResultsBean;
import com.lostandfound.webface.bean.SearchSessionBean;

@ManagedBean
@ViewScoped
public class SearchController extends BaseController {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -4729233144605977151L;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SearchController.class);
	private String search;
	private List<SearchResultsBean> searchResultBean;
	
	@ManagedProperty("#{searchSessionBean}")
	private SearchSessionBean searchSessionBean;
	
	@PostConstruct
	public void onload(){
		LOGGER.info("Called Post Construct of SearchController");
		search=searchSessionBean.getSearchQuery();
		callSearchService();
	}
	
	public String callSearchService(){
		if(search!=null){
			searchSessionBean.setSearchQuery(null);
		}
		searchResultBean = new ArrayList<SearchResultsBean>();
		for(int i=0; i<5 ;i++){
			SearchResultsBean srb = new SearchResultsBean();
			srb.setId(Long.valueOf(""+i));
			srb.setType(search+"Type "+i);
			srb.setLostorFoundDate(new Date());
			srb.setDescription("You will understand the concepts of dependency injection, understand how the core Spring framework works"+i);
			searchResultBean.add(srb);
			System.out.println("value="+ srb.getType());
		}
		return "searchResult";
		
	}


	/**
	 * @return the search
	 */
	public String getSearch() {
		return search;
	}


	/**
	 * @param search the search to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}


	/**
	 * @return the searchResultBean
	 */
	public List<SearchResultsBean> getSearchResultBean() {
		return searchResultBean;
	}


	/**
	 * @param searchResultBean the searchResultBean to set
	 */
	public void setSearchResultBean(List<SearchResultsBean> searchResultBean) {
		this.searchResultBean = searchResultBean;
	}



	/**
	 * @return the searchSessionBean
	 */
	public SearchSessionBean getSearchSessionBean() {
		return searchSessionBean;
	}

	/**
	 * @param searchSessionBean the searchSessionBean to set
	 */
	public void setSearchSessionBean(SearchSessionBean searchSessionBean) {
		this.searchSessionBean = searchSessionBean;
	}

}
