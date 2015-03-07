package dev.lof.controller.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class SearchSessionBean {
	
	private String searchQuery;

	/**
	 * @return the searchQuery
	 */
	public String getSearchQuery() {
		return searchQuery;
	}

	/**
	 * @param searchQuery the searchQuery to set
	 */
	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}
	
	public String navigate(){
		return "searchResult";
	}

}
