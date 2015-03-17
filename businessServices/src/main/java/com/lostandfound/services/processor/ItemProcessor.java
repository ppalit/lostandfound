package com.lostandfound.services.processor;

import com.lostandfound.common.bean.RegisterItemBean;
import com.lostandfound.common.bean.ReporterBean;

public interface ItemProcessor {
	public int getCount(String reporterId);
	
	public int saveItem(RegisterItemBean registerItemBean);
	
	public boolean saveReporter(ReporterBean reporterBean);
	
	public ReporterBean fetchReporter(String emailId);

}
