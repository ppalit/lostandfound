package com.lostandfound.services.processor;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(rollbackFor = Exception.class)
	public long saveItem(RegisterItemBean registerItemBean) throws SolrServerException, IOException {
		long itemId= 0;
		if (registerItemBean != null && registerItemBean.getLocation() != null)
			itemId = itemDao.insertFoundItem(registerItemBean);
		registerItemBean.setId(itemId);
		itemDao.saveToSolr(registerItemBean);
		return registerItemBean.getId();
	}

	public ReporterBean fetchReporter(String emailId) {
		return itemDao.getReporter(emailId);
	}

	public RegisterItemBean fetchItem(int itemId) {
		// TODO Auto-generated method stub
		return itemDao.getItem(itemId);
	}

	public List<RegisterItemBean> fetchItems() {
		return itemDao.getItems();
	}
	

	
}
