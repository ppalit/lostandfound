package dev.lof.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import dev.lof.controller.bean.SearchRelsultBean;

@Controller
@Scope("request")
public class SearchController extends BaseController {
	
	private String search;
	private List<SearchRelsultBean> searchResultBean;
	
	
	public String searchService(){
		
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
