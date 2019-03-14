package com.freeway.service;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import antlr.collections.List;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.freeway.dao.SlCompanyDao;
import com.freeway.entity.SlCompany;
@Component
public class CompanyService{
    @Resource
    private SlCompanyDao slcompanyDao;
     
    @DataProvider
    public Collection<SlCompany> getCompany(){
//        return slcompanyDao.getAll();
     return slcompanyDao.getAll();
    }
    
    @DataResolver
    @Transactional
    public void saveCompany(Collection<SlCompany> slcompanys){
    	slcompanyDao.persistEntities(slcompanys);
    }
}

