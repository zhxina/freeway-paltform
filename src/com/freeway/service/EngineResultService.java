package com.freeway.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
import com.freeway.dao.SlEngineResultDao;
import com.freeway.entity.SlEngineResult;
@Component
public class EngineResultService {
	   @Resource
	    private SlEngineResultDao slEngineResultDao;
	     
	    @DataProvider
	    public List<SlEngineResult> getAll(){
	        return slEngineResultDao.getAll();
	    }
	    
	    @DataProvider
	    public void getAllForPage(Page<SlEngineResult> page){
	        slEngineResultDao.getAll(page);
	    }
	    
	    @DataProvider
	    public void getAllForFilter(Page<SlEngineResult> page, Criteria criteria) throws Exception{
	        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SlEngineResult.class);
	        if (criteria != null){
	            slEngineResultDao.find(page, HibernateUtils.createFilter(detachedCriteria, criteria));
	        }else{
	            slEngineResultDao.getAll(page);
	        }
	    }
	    
	    @DataProvider
	    public void queryForCondition(Page<SlEngineResult> page, Map<String, Object> params) {
	        if (null != params) {
	            String projectCode = (String)params.get("projectCode");
	            String productCode = (String) params.get("productCode");
	            String phase = (String)params.get("phase");
	            String traceUid = (String)params.get("traceUid");
	            String userId = (String)params.get("userId");
	            String orderId = (String)params.get("orderId");
	            String result = (String) params.get("result");
	            String headCode = (String)params.get("headCode");
	            String backCode = (String)params.get("backCode");
	            String intervalsInDay = (String)params.get("intervalsInDay");
	            String creditLine = (String)params.get("creditLine");
	             
	            String whereCase = "";
	            if (StringHelper.isNotEmpty(projectCode)) {
	                whereCase += " AND projectCode like '%" + projectCode + "%' ";
	            }
	             
	            if (StringHelper.isNotEmpty(productCode)) {
	                whereCase += " AND productCode like '%" + productCode + "%' ";
	            }
	             
	            if (StringHelper.isNotEmpty(userId)) {
	                whereCase += " AND userId like '%" + userId + "%' ";
	            }
	             
	            if (StringHelper.isNotEmpty(orderId)) {
	                whereCase += " AND orderId like '%" + orderId + "%' ";
	            }
	             
	            if (StringHelper.isNotEmpty(result)) {
	                whereCase += " AND result like '%" + result + "%' ";
	            }
	             
	            if (StringHelper.isNotEmpty(phase)) {
	                whereCase += " AND phase like '%" + phase + "%' ";
	            }
	             
	            if (StringHelper.isNotEmpty(traceUid)) {
	                whereCase += " AND traceUid like '%" + traceUid + "%' ";
	            }
	            slEngineResultDao.find(page, " from SlEngineResult where 1=1 " + whereCase);
	        } else
	            slEngineResultDao.getAll(page);
	    }
	    
	    @DataResolver
	    @Transactional
	    public void saveAll(Collection<SlEngineResult> SlEngineResults){
	        slEngineResultDao.persistEntities(SlEngineResults);
	    }
	    
	    @DataProvider
	    public Collection<SlEngineResult> getEngineResultByOrderId(String userId){
	        Map param = new HashMap();
	        if(StringHelper.isNotEmpty(userId)){
	            param.put("userId", userId);
	            return slEngineResultDao.find("from SlEngineResultDao where userId = :userId",param);
	        }else{
	            return null;
	        }
	    }

}
