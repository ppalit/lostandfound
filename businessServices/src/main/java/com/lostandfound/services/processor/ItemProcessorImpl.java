package com.lostandfound.services.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.lostandfound.services.dao.ItemDao;

@Component(value = "itemProcessorImpl")
public class ItemProcessorImpl implements ItemProcessor{
	
	@Autowired
	@Qualifier("itemDaoImpl")
	ItemDao itemDao;
	
	public int getCount(String reporterId){
		return itemDao.countRecords(reporterId);
	}

}
