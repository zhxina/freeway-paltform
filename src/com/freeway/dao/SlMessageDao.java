package com.freeway.dao;

import org.springframework.stereotype.Repository;

import com.bstek.dorado.hibernate.HibernateDao;
import com.freeway.entity.SlMessage;
@Repository
public class SlMessageDao extends HibernateDao<SlMessage, Integer> {

}
