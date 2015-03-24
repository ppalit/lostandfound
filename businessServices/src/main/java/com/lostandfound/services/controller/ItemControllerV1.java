package com.lostandfound.services.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.ast.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lostandfound.common.bean.RegisterItemBean;
import com.lostandfound.services.exception.CustomGenericException;
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

	@RequestMapping(value = "/V1/items", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<RegisterItemBean> getItems(
			@RequestParam(value = "target", required = false, defaultValue = "DB") String target) throws CustomGenericException{
		List<RegisterItemBean> resultList = new ArrayList<RegisterItemBean>();
		try{
			resultList = itemProcessor.fetchItems("blue");
		}catch (Exception exp) {
			if (exp.getCause() instanceof CustomGenericException){
				System.out.println("Exception  = " + exp);
				throw (CustomGenericException)exp.getCause();
			}
			System.out.println("Exception  = " + exp);
			throw new CustomGenericException("BUSINESS-SERVICES-ERR3", "Error in Controller interaction.. check logs for more details");
		}
		return resultList;
	}

	@RequestMapping(value = "/V1/item/{itemId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody RegisterItemBean getItem(
			@RequestParam(value = "target", required = false, defaultValue = "DB") String target,
			@PathVariable String itemId)throws CustomGenericException{
		RegisterItemBean item = null;
		try {
			item = itemProcessor.fetchItem(Integer.parseInt(itemId));
		}catch (Exception exp) {
			if (exp.getCause() instanceof CustomGenericException){
				System.out.println("Exception  = " + exp);
				throw (CustomGenericException)exp.getCause();
			}
			System.out.println("Exception  = " + exp);
			throw new CustomGenericException("BUSINESS-SERVICES-ERR3", "Error in Controller interaction.. check logs for more details");
		}
		return item;
	}

	@RequestMapping(value = "/V1/item", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String insertItem(
			@RequestParam(value = "target", required = false, defaultValue = "DB") String target,
			@RequestBody RegisterItemBean registerItemBean,
			HttpServletResponse response) throws CustomGenericException {
		System.out.println("in POST method" + registerItemBean);
		String itemId = "";
		try {
			if (target.equalsIgnoreCase("DB")) {
				itemId = "Item Saved with Item Id = "
						+ itemProcessor.saveItem(registerItemBean);
				System.out.println(itemId);
			}
		}
		catch (Exception exp) {
			if (exp.getCause() instanceof CustomGenericException){
				System.out.println("Exception  = " + exp);
				throw (CustomGenericException)exp.getCause();
			}
			System.out.println("Exception  = " + exp);
			throw new CustomGenericException("BUSINESS-SERVICES-ERR3", "Error in Controller interaction.. check logs for more details");
		}
		return itemId;
	}

	@ExceptionHandler(CustomGenericException.class)
	public Map<String, String> handleCustomException(CustomGenericException ex,
			HttpServletResponse response) {
		System.out.println("In exception Handler!!");
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("errCode", ex.getErrCode());
		errorMap.put("errMsg", ex.getErrMsg());
		response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
		return errorMap;

	}

}
