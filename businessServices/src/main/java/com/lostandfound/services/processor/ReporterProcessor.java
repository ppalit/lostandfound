package com.lostandfound.services.processor;

import java.util.List;

import com.lostandfound.common.bean.ReporterBean;

public interface ReporterProcessor {
		
	public ReporterBean fetchReporter(String emailId);
	
	public List<ReporterBean> fetchAllReporters();

}
