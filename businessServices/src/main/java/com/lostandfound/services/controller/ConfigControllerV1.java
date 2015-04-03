package com.lostandfound.services.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.lostandfound.common.bean.ConfigBean;
import com.lostandfound.services.exception.CustomGenericException;
import com.lostandfound.services.processor.ConfigProcessor;

@Controller
public class ConfigControllerV1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(ConfigControllerV1.class);

	@Autowired
	@Qualifier("configProcessorImpl")
	ConfigProcessor configProcessor;

	@RequestMapping(value = "/V1/configs/{configType}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ConfigBean> getConfig(
			@RequestParam(value = "target", required = false, defaultValue = "DB") String target,
			@RequestParam(value = "parent", required = false, defaultValue = "0") String parent,
			@RequestParam(value = "order", required = false, defaultValue = "ASC") String order,
			@RequestParam(value = "includeSub", required = false, defaultValue = "true") String includeSub,
			@PathVariable String configType)throws CustomGenericException{
		 List<ConfigBean> configs = null;
		try {
			configs = configProcessor.getConfigs(configType, parent, order, Boolean.getBoolean(includeSub));
		}catch (Exception exp) {
			if (exp.getCause() instanceof CustomGenericException){
				logger.error("Exception  = " + exp);
				throw (CustomGenericException)exp.getCause();
			}
			logger.error("Exception  = " + exp);
			throw new CustomGenericException("BUSINESS-SERVICES-ERR3", "Error in Controller interaction.. check logs for more details");
		}
		return configs;
	}
	
	@RequestMapping(value = "/V1/config/{config_id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getConfigValue(
			@RequestParam(value = "target", required = false, defaultValue = "DB") String target,
			@PathVariable String config_id)throws CustomGenericException{
		String value = null;
		try {
			value = configProcessor.getConfigValue(Integer.parseInt(config_id));
		}catch (Exception exp) {
			if (exp.getCause() instanceof CustomGenericException){
				logger.error("Exception  = " + exp);
				throw (CustomGenericException)exp.getCause();
			}
			logger.error("Exception  = " + exp);
			throw new CustomGenericException("BUSINESS-SERVICES-ERR3", "Error in Controller interaction.. check logs for more details");
		}
		return value;
	}


	

	@ExceptionHandler(CustomGenericException.class)
	public Map<String, String> handleCustomException(CustomGenericException ex,
			HttpServletResponse response) {
		logger.error("In exception Handler!!");
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("errCode", ex.getErrCode());
		errorMap.put("errMsg", ex.getErrMsg());
		response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
		return errorMap;

	}

}
