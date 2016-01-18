package com.theoreticsinc.cms.factory;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.theoreticsinc.cms.constant.MainEnum;

@SuppressWarnings("unchecked")
public class FactoryEntityServiceImpl<H> implements FactoryEntityService<H>{
	

	@Override
	public H getEntity(MainEnum mainenum, String param, Session session) throws Exception{
		
		H resultentity = null;
		if(MainEnum.LOGIN.equals(mainenum)){
			Class<?> cls = Class.forName("com.theoreticsinc.cms.model.LoginUser");
			resultentity = (H) session.createCriteria(cls)
					.add(Restrictions.eq("userCode", new String(param))).uniqueResult();
		
		}else if(MainEnum.PRODUCT.equals(mainenum)){
			Class<?> cls = Class.forName("com.theoreticsinc.cms.model.Product");
			resultentity = (H) session.createCriteria(cls)
					.add(Restrictions.eq("productCode", new String(param))).uniqueResult();
		}
		
		return resultentity;
	}
	

	@Override
	public List<H> getEntityProductList(MainEnum mainenum, String productcode, String brand, String categorycode, Session session) throws Exception{
		Criteria criteria = null;
		List<H> resultentitylist = null;
		if(MainEnum.PRODUCT.equals(mainenum)){
			
			Class<?> cls = Class.forName("com.theoreticsinc.cms.model.Product");
			criteria = session.createCriteria(cls);
			
			if(!productcode.equalsIgnoreCase("-")) { criteria.add(Restrictions.eq("productCode", new String(productcode))); }
			if(!brand.equalsIgnoreCase("-")) { criteria.add(Restrictions.eq("brand", new String(brand))); }
			if(!categorycode.equalsIgnoreCase("-")) { criteria.add(Restrictions.eq("categoryCode", new String(categorycode))); }
			
			resultentitylist = criteria.list();
		
		} else if(MainEnum.EDITPRODUCT.equals(mainenum)){
			Class<?> cls = Class.forName("com.theoreticsinc.cms.model.Product");
			resultentitylist = (List<H>) session.createCriteria(cls)
					.add(Restrictions.eq("productCode", new String(productcode))).list();
		
		}
		
		return resultentitylist;
	}
	

	@Override
	public List<H> getEntityProductSupplier(String productcode, Session session) throws Exception{
		List<H> resultentitylist = null;
		
		Class<?> cls = Class.forName("com.theoreticsinc.cms.model.ProductSupplier");
		resultentitylist = (List<H>) session.createCriteria(cls)
				.add(Restrictions.eq("productCode", productcode))
				.list();
		
		return resultentitylist;
	}
	

	@Override
	public List<H> getCategoryEntityList(Session session) throws Exception{
		List<H> resultentitylist = null;
		
		Class<?> cls = Class.forName("com.theoreticsinc.cms.model.Category");
		resultentitylist = (List<H>) session.createCriteria(cls)
				.list();
		
		return resultentitylist;
	}
	

	@Override
	public H getEntitySupplier(String suppliercode, Session session) throws Exception{
		H resultentitylist = null;
		
		Class<?> cls = Class.forName("com.theoreticsinc.cms.model.Supplier");
		resultentitylist = (H) session.createCriteria(cls)
				.add(Restrictions.eq("supplierCode", suppliercode))
				.uniqueResult();
		
		return resultentitylist;
	}

	@Override
	public List<H> getEntityInventory(String productcode, Session session) throws Exception {
		List<H> resultentitylist = null;
		
		Class<?> cls = Class.forName("com.theoreticsinc.cms.model.Inventory");
		resultentitylist = (List<H>) session.createCriteria(cls)
				.add(Restrictions.eq("productCode", productcode))
				.list();
		
		return resultentitylist;
	}
	
	
	
}