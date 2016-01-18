package com.theoreticsinc.cms.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.theoreticsinc.cms.dao.InventoryDao;
import com.theoreticsinc.cms.vo.InventorySummaryVO;


public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryDao inventoryDao;
	
	static final Logger logger = Logger.getLogger(InventoryServiceImpl.class);

	
	public List<InventorySummaryVO> searchProductCode(String productcode, String brand, String categorycode) throws Exception{
		return inventoryDao.searchProductCode(productcode, brand, categorycode);
		
	}
}
