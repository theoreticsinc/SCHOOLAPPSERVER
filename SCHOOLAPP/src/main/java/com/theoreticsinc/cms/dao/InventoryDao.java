package com.theoreticsinc.cms.dao;

import java.util.List;

import com.theoreticsinc.cms.model.Inventory;
import com.theoreticsinc.cms.vo.InventorySummaryVO;

public interface InventoryDao {
	public List<InventorySummaryVO> searchProductCode(String productcode, String brand, String categorycode) throws Exception;
	
}
