package com.freeway.service;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.DataProvider;
import com.freeway.dao.SlMockUserDao;
import com.freeway.entity.SlMockUser;
@Component
public class MockUserService{
    @Resource
	private SlMockUserDao slMockUserDao;
     
    @DataProvider
	public Collection<SlMockUser> getAll() {

		return slMockUserDao.getAll();
    }
}

