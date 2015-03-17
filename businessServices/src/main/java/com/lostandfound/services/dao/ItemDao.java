package com.lostandfound.services.dao;

import com.lostandfound.common.bean.RegisterItemBean;
import com.lostandfound.common.bean.ReporterBean;

public interface ItemDao {
	
	 public int countRecords(String reporterId);
	 
	 public int insertFoundItem(RegisterItemBean registerItemBean);
	 
	 public boolean insertReporter(ReporterBean reporterBean);
	 
	 public ReporterBean getReporter(String emailId);
	 
}
