package com.theoreticsinc.cms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.theoreticsinc.cms.constant.MainEnum;
import com.theoreticsinc.cms.constant.StatusCode;
import com.theoreticsinc.cms.crypt.DecryptionUtil;
import com.theoreticsinc.cms.crypt.EncryptionUtil;
import com.theoreticsinc.cms.factory.FactoryEntityService;
import com.theoreticsinc.cms.factory.FactoryEntityServiceImpl;
import com.theoreticsinc.cms.model.LoginUser;
import com.theoreticsinc.cms.util.HibernateUtil;

public class StaffDaoImpl implements StaffDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	FactoryEntityService<LoginUser> factoryentityService = new FactoryEntityServiceImpl<LoginUser>();
	
	@Override
	public String submitNewPassword(String userid, String password) throws Exception {
		
		Session session = HibernateUtil.callSession(sessionFactory);
		String encryptedpwd = null;
		String results = null;
		try {
			
			LoginUser loginuser = factoryentityService.getEntity(MainEnum.LOGIN, userid, session);
			
			if (loginuser==null){
				results = "No Record Found";
			}else{
				encryptedpwd = EncryptionUtil.encrypt(password);
				loginuser.setPassword(encryptedpwd);
				session.save(loginuser);
				results = "You have successfully change your password";
			}
			HibernateUtil.callCommit(sessionFactory);
		} catch (Exception e) {
			results = e.getMessage();
		}finally{
			HibernateUtil.callClose(sessionFactory);
		}
		return results;
	}
	
	@Override
	public String submitLogin(String userid, String password) throws Exception {
		
		Session session = HibernateUtil.callSession(sessionFactory);
		String results = null;
		try {
			
			LoginUser loginuser = factoryentityService.getEntity(MainEnum.LOGIN, userid, session);
			
			if (loginuser==null){
				results = "No Record Found";
			}else{
				if(DecryptionUtil.decrypt(loginuser.getPassword()).equals(password)){
					results = StatusCode.SUCCESSFUL_CODE;
				}else{
					results = StatusCode.LOGIN_PASSWORD_ERROR_CODE;
				}
			}
			HibernateUtil.callCommit(sessionFactory);
		} catch (Exception e) {
			results = StatusCode.LOGIN_PASSWORD_ERROR_CODE;
		}finally{
			HibernateUtil.callClose(sessionFactory);
		}
		return results;
	}

}
