package com.lostandfound.services.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.lostandfound.common.bean.RegisterItemBean;
import com.lostandfound.common.bean.ReporterBean;
import com.lostandfound.services.dao.ItemDao;

@Component(value = "itemProcessorImpl")
public class ItemProcessorImpl implements ItemProcessor{
	
	@Autowired
	@Qualifier("itemDaoImpl")
	ItemDao itemDao;
	
	public int getCount(String reporterId){
		return itemDao.countRecords(reporterId);
	}

	public int saveItem(RegisterItemBean registerItemBean) {
		int itemId= 0;
		if (registerItemBean != null && registerItemBean.getLocation() != null)
			itemId = itemDao.insertFoundItem(registerItemBean);
		return itemId;
	}

	public boolean saveReporter(ReporterBean reporterBean) {
		boolean  status= false;
		if (reporterBean != null)
			status = itemDao.insertReporter(reporterBean);
		return status;
	}

	public ReporterBean fetchReporter(String emailId) {
		return itemDao.getReporter(emailId);
	}

	public RegisterItemBean fetchItem(int itemId) {
		// TODO Auto-generated method stub
		return itemDao.getItem(itemId);
	}

	public List<RegisterItemBean> fetchItems(String searchString) {
		return itemDao.getItems("blue");
	}

	
}
