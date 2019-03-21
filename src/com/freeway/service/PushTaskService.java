package com.freeway.service;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.Expose;
import com.freeway.dao.SlLastOrderDao;
import com.freeway.dao.SlProjectDao;
import com.freeway.dao.SlPushRecordDao;
import com.freeway.dto.CreditUserOrder;
import com.freeway.entity.SlLastOrder;
import com.freeway.entity.SlMockUser;
import com.freeway.entity.SlProject;
import com.freeway.entity.SlPushRecord;
import com.freeway.utils.HttpClientUtils;

@Component
public class PushTaskService {

	@Resource
	private SlLastOrderDao slLastOrderDao;

	@Resource
	private SlPushRecordDao slPushRecordDao;

	@Resource
	private SlProjectDao slProjectDao;

	@DataProvider
	public Collection<SlPushRecord> getPushRecord() {

		//
		// DetachedCriteria criteria =
		// DetachedCriteria.forClass(SlPushRecord.class);
		// criteria.addOrder(org.hibernate.criterion.Order.desc("id"));

		org.hibernate.Query query = slPushRecordDao
				.createQuery("from SlPushRecord order by id desc");
		query.setMaxResults(25);
		return query.list();
	}

	@Expose
	@Transactional
	public Map pushOrder(Map param) {

		Map result = new HashMap();

		SlMockUser slMockUser = (SlMockUser) param.get("realname");
		String phase = (String) param.get("phase");

		CreditUserOrder creditUserOrder = new CreditUserOrder();
		creditUserOrder.setUserId(slMockUser.getUserId());
		creditUserOrder.setBankCard(slMockUser.getBankcard());
		creditUserOrder.setIdCard(slMockUser.getIdcard());
		creditUserOrder.setPhoneNumber(slMockUser.getPhone());
		creditUserOrder.setRealName(slMockUser.getRealname());

		if (phase.equals("LOAN")) {
			SlLastOrder slLastOrder = slLastOrderDao.get(62);
			slLastOrder.setOrderId(slLastOrder.getOrderId() + 1);
			creditUserOrder.setOrderId(slLastOrder.getOrderId());
		}

		DetachedCriteria dc = DetachedCriteria.forClass(SlProject.class);
		String projectName = (String) param.get("project");
		String environment = (String) param.get("environment");
		String productName = (String) param.get("product");
		dc.add(Restrictions.eq("projectName", projectName));
		dc.add(Restrictions.eq("environment", environment));
		dc.add(Restrictions.eq("productName", productName));
		List<SlProject> slProjects = slProjectDao.find(dc);

		if (slProjects.size() == 1) {
			SlProject slProject = slProjects.get(0);
			StringBuffer urlBuffer = new StringBuffer();
			urlBuffer.append(slProject.getUrl());
			urlBuffer.append("/frontend/v2/engine/task");
			urlBuffer.append("?");
			urlBuffer.append(String.format("%s=%s&", "projectCode",
					slProject.getProjectCode()));
			urlBuffer.append(String.format("%s=%s&", "productCode",
					slProject.getProductCode()));
			urlBuffer.append(String.format("%s=%s", "phaseCode", phase));
			JSONObject jsonObject = (JSONObject) JSON.toJSON(creditUserOrder);
			if (phase.equals("PRELOAN")) {
				jsonObject.remove("orderId");
			}

			String response = HttpClientUtils.sendPost(urlBuffer.toString(),
					jsonObject);

			if (response.equals("OK")) {
				result.put("result", true);
				result.put("msg", String.format("推单成功。"));
			} else {
				result.put("result", false);
				result.put("msg", String.format("推单失败。\n%s", response));
			}

			SlPushRecord slPushRecord = new SlPushRecord();
			slPushRecord.setOrderId(creditUserOrder.getOrderId());
			slPushRecord.setUserId(creditUserOrder.getUserId());
			slPushRecord.setContent(jsonObject.toJSONString());
			slPushRecord.setCreatedAt(new Date());
			slPushRecord.setEnvironment(slProject.getEnvironment());
			slPushRecord.setProject(slProject.getProjectName());
			slPushRecord.setProductName(slProject.getProductName());
			slPushRecord.setResult(response);
			slPushRecordDao.save(slPushRecord);
		} else {
			result.put("result", false);
			result.put("msg", "你选择的项目，环境可能不存在，无法推单，请检查！");
		}
		return result;
	}
}
