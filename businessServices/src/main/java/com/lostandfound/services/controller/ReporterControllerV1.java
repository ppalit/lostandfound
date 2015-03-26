package com.lostandfound.services.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lostandfound.common.bean.ReporterBean;
import com.lostandfound.services.exception.CustomGenericException;
import com.lostandfound.services.processor.ReporterProcessor;

@Controller
public class ReporterControllerV1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	@Qualifier("reporterProcessorImpl")
	ReporterProcessor reporterProcessor;

	@RequestMapping(value = "/V1/reporters", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ReporterBean> getAllReporters(
		   @RequestParam(value = "target", required = false, defaultValue = "DB") String target) throws CustomGenericException{
		List<ReporterBean> reporterList = new ArrayList<ReporterBean>();
		try{
			reporterList = reporterProcessor.fetchAllReporters();
		}catch (Exception exp) {
			if (exp.getCause() instanceof CustomGenericException){
				System.out.println("Exception  = " + exp);
				throw (CustomGenericException)exp.getCause();
			}
			System.out.println("Exception  = " + exp);
			throw new CustomGenericException("BUSINESS-SERVICES-ERR3", "Error in Controller interaction.. check logs for more details");
		}
		return reporterList;
	}

	@RequestMapping(value = "/V1/reporter/{reporterId}/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ReporterBean getReporter(
			@RequestParam(value = "target", required = false, defaultValue = "DB") String target,
			@PathVariable String reporterId)throws CustomGenericException{
		ReporterBean reporter = null;
		try {
			reporter = reporterProcessor.fetchReporter(reporterId);
		}catch (Exception exp) {
			if (exp.getCause() instanceof CustomGenericException){
				System.out.println("Exception  = " + exp);
				throw (CustomGenericException)exp.getCause();
			}
			System.out.println("Exception  = " + exp);
			throw new CustomGenericException("BUSINESS-SERVICES-ERR3", "Error in Controller interaction.. check logs for more details");
		}
		return reporter;
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
