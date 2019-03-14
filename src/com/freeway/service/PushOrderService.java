package com.freeway.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bstek.dorado.annotation.Expose;
import com.freeway.dao.SlLastOrderDao;
import com.freeway.entity.SlLastOrder;

@Component
public class PushOrderService {

	@Resource
	private SlLastOrderDao slLastOrderDao;

	@Expose
	@Transactional
	public Map postTaskApi(String param) {

		Map result = new HashMap();

		String riskUrl = "http://creditengine.c335e7bd9743f44fa8824b17a03128ba0.cn-shanghai.alicontainer.com";
		String apiUrl = "/frontend/v2/engine/task";
		String response = "";

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("projectCode", "RRKJ"));
		params.add(new BasicNameValuePair("productCode", "DEFQ"));
		params.add(new BasicNameValuePair("phaseCode", "LOAN"));

		SlLastOrder lastOrder = slLastOrderDao.get(62);
		int lastOrderNum = lastOrder.getOrderId() + 1;
		lastOrder.setOrderId(lastOrderNum);

		String json = param.replace("{order_id}", lastOrderNum + "");

		try {
			String parameStr = EntityUtils.toString(new UrlEncodedFormEntity(params));
			// 拼接参数
			StringBuffer urlBuffer = new StringBuffer();
			urlBuffer.append(riskUrl);
			urlBuffer.append(apiUrl);
			urlBuffer.append("?");
			urlBuffer.append(parameStr);

			DefaultHttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(urlBuffer.toString());
			StringEntity stringEntity = new StringEntity(json, "UTF-8");
			stringEntity.setContentType("application/json");

			stringEntity.setContentEncoding("UTF-8");
			post.setEntity(stringEntity);
			HttpResponse res = client.execute(post);
			if (res.getStatusLine().getStatusCode() == 201) {
				result.put("result", true);
				result.put("msg", String.format("订单：%s 推单成功。", lastOrderNum));
			} else {
				HttpEntity entity = res.getEntity();
				response = EntityUtils.toString(res.getEntity());
				result.put("result", false);
				result.put("msg", String.format("订单：%s 推单失败。\n%s", lastOrderNum, response));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}
}
