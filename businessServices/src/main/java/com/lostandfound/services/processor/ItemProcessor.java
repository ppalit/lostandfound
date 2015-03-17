package com.lostandfound.services.processor;

import java.util.List;

import com.lostandfound.common.bean.RegisterItemBean;
import com.lostandfound.common.bean.ReporterBean;

public interface ItemProcessor {
	public int getCount(String reporterId);
	
	public int saveItem(RegisterItemBean registerItemBean);
	
	public boolean saveReporter(ReporterBean reporterBean);
	
	public ReporterBean fetchReporter(String emailId);
	
	public RegisterItemBean fetchItem(int itemId);
	
	public List<RegisterItemBean> fetchItems(String searchString);

}
