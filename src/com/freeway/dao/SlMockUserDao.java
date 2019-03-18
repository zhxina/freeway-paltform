package com.freeway.dao;

import org.springframework.stereotype.Repository;

import com.bstek.dorado.hibernate.HibernateDao;
import com.freeway.entity.SlMockUser;


@Repository
public class SlMockUserDao  extends HibernateDao<SlMockUser, Long>  {

}
