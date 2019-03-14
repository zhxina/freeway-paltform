package com.freeway.dao;

import org.springframework.stereotype.Repository;

import com.bstek.dorado.hibernate.HibernateDao;
import com.freeway.entity.SlCompany;
import com.freeway.entity.SlDept;
import com.freeway.entity.SlLastOrder;
import com.freeway.entity.SlMessage;
@Repository
public class SlLastOrderDao extends HibernateDao<SlLastOrder, Integer> {

}
