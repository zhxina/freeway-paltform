package com.freeway.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.annotations.common.util.StringHelper;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Criteria;
import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.hibernate.HibernateUtils;
import com.freeway.dao.SlMockUserDao;
import com.freeway.entity.SlMockUser;


@Component
public class MockUserService {
	 @Resource
	    private SlMockUserDao slmockuserDao;
	     
	    @DataProvider
	    public Collection<SlMockUser> getAll(){
	        return slmockuserDao.getAll();
	    }
	    @DataProvider
	    public void getAllForPage(Page<SlMockUser> page){
	    	slmockuserDao.getAll(page);
	    }
	    @DataProvider
	    public void getAllForFilter(Page<SlMockUser> page, Criteria criteria) throws Exception{
	        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SlMockUser.class);
	        if (criteria != null){
	        	slmockuserDao.find(page, HibernateUtils.createFilter(detachedCriteria, criteria));
	        }else{
	        	slmockuserDao.getAll(page);
	        }
	    }
	    
	    @DataProvider
	    public void queryForCondition(Page<SlMockUser> page, Map<String, Object> params) {
	        if (null != params) {
	        	 String id = (String)params.get("id");
	            String userId = (String)params.get("userId");
	            String realname = (String) params.get("realname");
	            String phone = (String)params.get("phone");
	         
	            String bankcard = (String)params.get("bankcard");
	            String idcard = (String)params.get("idcard");
	            String status = (String) params.get("status");
	            String createdAt= (String) params.get("createdAt");
	            String updatedAt= (String) params.get("updatedAt");
	            String whereCase = "";
	            if (StringHelper.isNotEmpty(id)) {
	                whereCase += " AND id like '%" + id + "%' ";
	            }
	            if (StringHelper.isNotEmpty(userId)) {
	                whereCase += " AND user_id like '%" + userId + "%' ";
	            }
	             
	            if (StringHelper.isNotEmpty(realname)) {
	                whereCase += " AND realname like '%" + realname + "%' ";
	            }
	             
	            if (StringHelper.isNotEmpty(phone)) {
	                whereCase += " AND phone like '%" + phone + "%' ";
	            }
	          
	       
	             
	            if (StringHelper.isNotEmpty(bankcard)) {
	                whereCase += " AND bankCard like '%" + bankcard + "%' ";
	            }
	             
	            if (StringHelper.isNotEmpty(idcard)) {
	                whereCase += " AND idCard like '%" + idcard + "%' ";
	            }
	            if (StringHelper.isNotEmpty(status)) {
	                whereCase += " AND status like '%" + status + "%' ";
	            }
	            if (StringHelper.isNotEmpty(createdAt)) {
	                whereCase += " AND created_at like '%" + createdAt + "%' ";
	            }
	            if (StringHelper.isNotEmpty(updatedAt)) {
	                whereCase += " AND updated_at like '%" + updatedAt + "%' ";
	            }
	            slmockuserDao.find(page, " from SlMockUser where 1=1 " + whereCase);
	        } else
	        	slmockuserDao.getAll(page);
	    }
	    
	    
	    
	  
	    @DataResolver
	    @Transactional
	    public void saveAll(Collection<SlMockUser> slMockUser){
	    	slmockuserDao.persistEntities(slMockUser);
	    }
	    
	    @DataResolver
	    @Transactional
	    public void saveMockUser(Collection<SlMockUser> slMockUser){
//	    	 for(SlMockUser employee:slMockUser){
//	             Collection<SlMockUser> messages = employee.getSlMockUserSet();
//	             for(SlMockUser message:messages){
//	                 //维护关联关系
//	                 message.setMockUser(message);
//	             }
//	             slmockuserDao.persistEntities(messages);
	  //  }
	    	
}
	   
}
