package com.theoreticsinc.cms.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.theoreticsinc.cms.constant.MainEnum;
import com.theoreticsinc.cms.factory.FactoryEntityService;
import com.theoreticsinc.cms.factory.FactoryEntityServiceImpl;
import com.theoreticsinc.cms.model.Inventory;
import com.theoreticsinc.cms.model.Product;
import com.theoreticsinc.cms.util.HibernateUtil;
import com.theoreticsinc.cms.vo.InventorySummaryVO;
import com.theoreticsinc.cms.vo.POSupplierVO;

public class InventoryDaoImpl implements InventoryDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	Session session = null;
	Transaction tx = null;
	
	static final Logger logger = Logger.getLogger(InventoryDaoImpl.class);
	
	FactoryEntityService<Inventory> factoryInventoryEntityService = new FactoryEntityServiceImpl<Inventory>();
	FactoryEntityService<Product> factoryProductEntityService = new FactoryEntityServiceImpl<Product>();
	
	@Override
	public List<InventorySummaryVO> searchProductCode(String productcode, String brand, String categorycode) throws Exception {
		
		Session session = HibernateUtil.callSession(sessionFactory);
		List<InventorySummaryVO> searchInventoryList = new ArrayList<InventorySummaryVO>();;
		StringBuffer stringcriteria = new StringBuffer();
		Query query = null;
		
		try {
			if (!productcode.equalsIgnoreCase("-")) {stringcriteria.append(" AND A.PRODUCTCODE =:productcode "); }
			if (!brand.equalsIgnoreCase("-")) {stringcriteria.append(" AND B.BRAND like :brand ");}
			if (!categorycode.equalsIgnoreCase("-")) {stringcriteria.append(" AND B.CATEGORYCODE =:categorycode ");}
			
			//searchInventoryList = factoryInventoryEntityService.getEntityInventory(productcode, session);
			if(stringcriteria.length() != 0){
				query = session.createSQLQuery(" SELECT A.ProductCode, B.ProductName, B.Brand, B.CATEGORYCODE FROM tblinventory A INNER JOIN tblproduct B ON A.ProductCode = B.ProductCode "
						+ " WHERE 1 "
						+ stringcriteria.toString() + " ORDER BY B.ProductName ");
			}else{
				//criteria = session.createSQLQuery(" SELECT A.PURCHASEORDERCODE, A.SUPPLIERCODE, B.SUPPLIERNAME, "
				//		+ " A.ISSUEDATE, A.DATERECEIVED FROM tblpurchaseorder A "
				//		+ " INNER JOIN tblsupplier B ON A.SUPPLIERCODE = B.supplierCode WHERE STATUS = 'Emailed' ORDER BY A.PURCHASEORDERCODE");
				query = session.createSQLQuery(" SELECT A.ProductCode, B.ProductName, B.Brand, B.CATEGORYCODE FROM tblinventory A INNER JOIN tblproduct B ON A.ProductCode = B.ProductCode ");
			}
			
			if (!productcode.equalsIgnoreCase("-")) {	query.setString("productcode", productcode); }
			if (!brand.equalsIgnoreCase("-")) {	query.setString("brand", "%" + brand + "%" ); }
			if (!categorycode.equalsIgnoreCase("-")) {	query.setString("categorycode", categorycode); }
			
			searchInventoryList = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.callClose(sessionFactory);
		}
		return searchInventoryList;

	}

}
