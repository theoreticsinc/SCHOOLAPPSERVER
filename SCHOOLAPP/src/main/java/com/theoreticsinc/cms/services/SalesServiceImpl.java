package com.theoreticsinc.cms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.theoreticsinc.cms.dao.SalesDao;
import com.theoreticsinc.cms.vo.SalesOrderVO;

public class SalesServiceImpl implements SalesService{
	@Autowired
	SalesDao salesDao;
	
	@Override
	public List<SalesOrderVO> searchSalesOrder(String salesordercode, String custumercode, String dateordered)
			throws Exception {
		return salesDao.searchSalesOrder(salesordercode, custumercode, dateordered);
	}

}
