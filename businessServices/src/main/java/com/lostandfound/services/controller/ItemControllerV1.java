package com.lostandfound.services.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.javafaker.Address;
import com.lostandfound.common.bean.RegisterItemBean;
import com.lostandfound.common.bean.SearchResultsBean;
import com.lostandfound.services.processor.ItemProcessor;

@Controller
public class ItemControllerV1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("itemProcessorImpl")
	ItemProcessor itemProcessor;
	
	@RequestMapping(value="/V1/items/",method = RequestMethod.GET,produces = "application/json")
	public  @ResponseBody List<SearchResultsBean> getItems(
			@RequestParam(value = "system", required = false, defaultValue = "DB") String name
			) {
		//model.addAttribute("name", name);
		System.out.println("in method");
		SearchResultsBean srb = new SearchResultsBean();
		List resultList = new ArrayList<SearchResultsBean>();
		resultList.add(srb);
		return resultList;
	}
	
	@RequestMapping(value="/V1/item/",method = RequestMethod.GET,produces = "application/json")
	public  @ResponseBody SearchResultsBean getItem(
			@RequestParam(value = "system", required = false, defaultValue = "DB") String name
			) {
		//model.addAttribute("name", name);
		System.out.println("in method returns"+itemProcessor.getCount("priyabrata.palit@gmail.com"));
		SearchResultsBean srb = new SearchResultsBean();
		return srb;
	}
	
	@RequestMapping(value="/V1/item",method = RequestMethod.PUT,produces = "application/json")
	public  @ResponseBody String insertItem(
			@RequestParam(value = "system", required = false, defaultValue = "DB") String name,
			@RequestBody RegisterItemBean names) {
		System.out.println("in POST method"+names);
		return "returned from POST";
	}	
	
}
