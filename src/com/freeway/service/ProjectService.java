package com.freeway.service;

import java.util.Collection;
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
import com.freeway.dao.SlProjectDao;
import com.freeway.entity.SlProject;
@Component
public class ProjectService {
    @Resource
    private SlProjectDao slProjectDao;
     
    @DataProvider
    public Collection<SlProject> getAll(){
        return slProjectDao.getAll();
    }
     
    @DataProvider
    public void getAllForPage(Page<SlProject> page){
    	slProjectDao.getAll(page);
    }
     
    @DataProvider
    public void getAllForFilter(Page<SlProject> page, Criteria criteria) throws Exception{
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SlProject.class);
        if (criteria != null){
        	slProjectDao.find(page, HibernateUtils.createFilter(detachedCriteria, criteria));
        }else{
        	slProjectDao.getAll(page);
        }
    }
     
    @DataProvider
    public void queryForCondition(Page<SlProject> page, Map<String, Object> params) {
        if (null != params) {
//            String project_id = (String)params.get("project_id");
            String projectName = (String) params.get("projectName");
            String projectCode = (String)params.get("projectCode");
            String productName = (String)params.get("productName");
            String productCode = (String)params.get("productCode");
            String environment = (String)params.get("environment");
//            String status = (String)params.get("status");
//            String url = (String)params.get("url");
             
            String whereCase = "";
//            if (StringHelper.isNotEmpty(project_id)) {
//                whereCase += " AND project_id like '%" + project_id + "%' ";
//            }
             
            if (StringHelper.isNotEmpty(projectName)) {
                whereCase += " AND projectName like '%" + projectName + "%' ";
            }
             
            if (StringHelper.isNotEmpty(projectCode)) {
                whereCase += " AND projectCode like '%" + projectCode + "%' ";
            }
             
            if (StringHelper.isNotEmpty(productName)) {
                whereCase += " AND productName like '%" + productName + "%' ";
            }
            
            if (StringHelper.isNotEmpty(productCode)) {
                whereCase += " AND productCode like '%" + productCode + "%' ";
            }
             
            if (StringHelper.isNotEmpty(environment)) {
                whereCase += " AND environment like '%" + environment + "%' ";
            }
            
//            if (StringHelper.isNotEmpty(status)) {
//                whereCase += " AND status like '%" + status + "%' ";
//            }
//             
//            if (StringHelper.isNotEmpty(url)) {
//                whereCase += " AND url like '%" + url + "%' ";
//            }
            slProjectDao.find(page, " from SlProject where 1=1 " + whereCase);
        } else
        	slProjectDao.getAll(page);
    }
    @DataResolver
    @Transactional
    public void saveAll(Collection<SlProject> slProject){
    	slProjectDao.persistEntities(slProject);
    }
}
