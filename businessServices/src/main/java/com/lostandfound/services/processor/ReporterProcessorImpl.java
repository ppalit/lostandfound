package com.lostandfound.services.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.lostandfound.common.bean.ReporterBean;
import com.lostandfound.services.dao.ReporterDao;

@Component(value = "reporterProcessorImpl")
public class ReporterProcessorImpl implements ReporterProcessor{
	
	@Autowired
	@Qualifier("reporterDaoImpl")
	ReporterDao reporterDao;

	public ReporterBean fetchReporter(String emailId) {
		return reporterDao.getReporter(emailId);
	}

	public List<ReporterBean> fetchAllReporters() {
		return reporterDao.getAllReporters();
	}
	
	
	
}
