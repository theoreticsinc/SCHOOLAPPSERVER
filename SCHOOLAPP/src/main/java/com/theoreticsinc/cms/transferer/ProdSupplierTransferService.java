package com.theoreticsinc.cms.transferer;

import java.util.List;

import org.hibernate.Session;

import com.theoreticsinc.cms.model.Product;
import com.theoreticsinc.cms.model.Supplier;
import com.theoreticsinc.cms.vo.ProductSupplierVO;
import com.theoreticsinc.cms.vo.SupplierVO;

public interface ProdSupplierTransferService {
	public List<ProductSupplierVO> generatePSTransfer(List<Product> productlist, Session session ) throws Exception;
	public List<SupplierVO> generateSuppTransfer(List<Supplier> supplierlist, Session session ) throws Exception;
}
