package com.lostandfound.services.dao;

import java.util.List;

import com.lostandfound.common.bean.ReporterBean;

public interface ReporterDao {
	
	 public int countRecords(String reporterId);
	 
	 public ReporterBean getReporter(String reporterId);
	 
	 public List<ReporterBean> getAllReporters();
	 
	 public boolean insertReporter(ReporterBean reporterBean);
	 
	 public boolean updateReporter(ReporterBean reporterBean);
	 
}
