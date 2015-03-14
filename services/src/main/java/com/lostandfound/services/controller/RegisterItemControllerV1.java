package dev.priyo.spring.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.priyo.spring.beans.Address;
import dev.priyo.spring.beans.NameBean;

@Controller
public class SampleRestController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@RequestMapping(value="/hello",method = RequestMethod.GET,produces = "application/json")
	public  @ResponseBody NameBean hello(
			@RequestParam(value = "name", required = false, defaultValue = "Priyo") String name
			) {
		//model.addAttribute("name", name);
		System.out.println("in method");
		return getNameBean(name);
	}
	
	@RequestMapping(value="/helloPost",method = RequestMethod.PUT,produces = "application/json")
	public  @ResponseBody String helloPost(
			@RequestParam(value = "name", required = false, defaultValue = "Priyo") String name,
			@RequestBody NameBean names) {
		System.out.println("in POST method"+names);
		return "returned from POST";
	}
	
	
	private NameBean getNameBean(String name){
		NameBean nameBean = new NameBean();
		nameBean.setName(name);
		nameBean.setPhoneNo(427634);
		
		Address add = new Address();
		add.setAddress1("Wayne");
		add.setZipCode(07470);
		
		nameBean.setAdd(add);
		return nameBean;
	}
}
