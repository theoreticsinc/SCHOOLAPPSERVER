package com.theoreticsinc.cms.services;

import java.util.List;

import com.theoreticsinc.cms.model.Inventory;
import com.theoreticsinc.cms.vo.InventorySummaryVO;


public interface InventoryService {
	public List<InventorySummaryVO> searchProductCode(String productcode, String brand, String categorycode) throws Exception;
	
}
