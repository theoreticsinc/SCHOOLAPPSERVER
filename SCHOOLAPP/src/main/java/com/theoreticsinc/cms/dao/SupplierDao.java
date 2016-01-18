package com.theoreticsinc.cms.dao;

import java.util.List;

import com.theoreticsinc.cms.model.Supplier;
import com.theoreticsinc.cms.vo.SupplierVO;

public interface SupplierDao {
	public List<SupplierVO> getSupplierList() throws Exception;
	public List<Supplier> submitNewSupplier(String suppliername, String address, 
			String phone, String fax, String website, String email, 
			String contactperson, String gstid, String contactpersonphone) throws Exception;
}
