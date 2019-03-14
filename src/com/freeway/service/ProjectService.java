package com.freeway.service;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.DataProvider;
import com.freeway.dao.SlProjectDao;
import com.freeway.entity.SlProject;
@Component
public class ProjectService{
    @Resource
	private SlProjectDao slProjectDao;
     
    @DataProvider
	public Collection<SlProject> getAll() {

		return slProjectDao.getAll();
    }
}

