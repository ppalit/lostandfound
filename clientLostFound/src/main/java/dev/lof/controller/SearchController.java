package dev.lof.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import dev.lof.controller.bean.SearchRelsultBean;

@ManagedBean
@RequestScoped
public class SearchController extends BaseController {
	
	
	@ManagedProperty(value="#{param.search}")
	private String search;
	private List<SearchRelsultBean> searchResultBean;
	
	public String callSearchService(){
		if(search==null){
			search="default_string";
		}
		searchResultBean = new ArrayList<SearchRelsultBean>();
		for(int i=0; i<5 ;i++){
			SearchRelsultBean srb = new SearchRelsultBean();
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
	public List<SearchRelsultBean> getSearchResultBean() {
		return searchResultBean;
	}


	/**
	 * @param searchResultBean the searchResultBean to set
	 */
	public void setSearchResultBean(List<SearchRelsultBean> searchResultBean) {
		this.searchResultBean = searchResultBean;
	}

}
