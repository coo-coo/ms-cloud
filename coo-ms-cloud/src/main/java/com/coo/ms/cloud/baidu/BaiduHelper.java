package com.coo.ms.cloud.baidu;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.baidu.frontia.FrontiaData;
import com.baidu.frontia.FrontiaQuery;
import com.baidu.frontia.api.FrontiaPushUtil;

public final class BaiduHelper {

	/**
	 * 参见:Baidu-Frontia-Android-2.0.7/docs/index.html
	 */
	public static FrontiaPushUtil.MessageContent buildMsg(String text) {
		// FrontiaPushUtil.MessageContent msg = new
		// FrontiaPushUtil.MessageContent(
		// "mMessageId",
		// FrontiaPushUtil.DeployStatus.PRODUCTION);
		// msg.setMessage(text);
		// return msg;
		FrontiaPushUtil.MessageContent msg = FrontiaPushUtil.MessageContent
				.createStringMessage("mMessageId", text);
		return msg;
	}

	/**
	 * 封装数据对象
	 */
	public static FrontiaData buildData(Map<String, Object> data) {
		FrontiaData frontiaData = new FrontiaData();
		if (data != null) {
			Set<Entry<String, Object>> set = data.entrySet();
			for (Entry<String, Object> entry : set) {
				frontiaData.put(entry.getKey(),
						entry.getValue());
			}
		}
		return frontiaData;
	}

	/**
	 * 封装查询对象
	 */
	public static FrontiaQuery buildQuery(Map<String, Object> conditions) {
		FrontiaQuery query = new FrontiaQuery();
		if (conditions != null) {
			Set<Entry<String, Object>> set = conditions.entrySet();
			for (Entry<String, Object> entry : set) {
				FrontiaQuery q = new FrontiaQuery();
				q.equals(entry.getKey(), entry.getValue());
				// and操作
				query.and(q);
			}
		}
		return query;
	}

	/**
	 * Mock查询对象
	 */
	public static FrontiaQuery mockQuery() {
		FrontiaQuery q1 = new FrontiaQuery();
		q1.equals("animal", "Panda");
		FrontiaQuery q2 = new FrontiaQuery();
		q2.equals("animal", "Dragon");
		FrontiaQuery q3 = new FrontiaQuery();
		q3.equals("animal", "Cat");
		FrontiaQuery q4 = new FrontiaQuery();
		q4.equals("animal", "Dog");
		return q1.or(q2).or(q3).or(q4);
	}
}
