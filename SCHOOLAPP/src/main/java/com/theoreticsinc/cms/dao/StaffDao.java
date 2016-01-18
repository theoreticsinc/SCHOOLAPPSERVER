package com.theoreticsinc.cms.dao;

public interface StaffDao {
	public String submitNewPassword(String userid, String password) throws Exception;
	public String submitLogin(String userid, String password) throws Exception ;
}
