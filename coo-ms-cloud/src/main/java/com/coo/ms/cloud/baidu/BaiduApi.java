package com.coo.ms.cloud.baidu;

import java.util.Map;

import com.baidu.frontia.FrontiaData;
import com.baidu.frontia.FrontiaQuery;
import com.baidu.frontia.api.FrontiaPushUtil;
import com.kingstar.ngbf.ms.util.Reference;

public final class BaiduApi {

	/**
	 * 初始化...
	 */
	public void init() {

	}

	/**
	 * 保存数据,參見FrontiaData等
	 */
	public static void dataSave(Map<String, Object> data,
			BaiduListenerAdapter listener) {
		FrontiaData fd = BaiduHelper.buildData(data);
		BaiduFactory.getStorage().insertData(fd, listener);
	}

	/**
	 * 删除数据,參見FrontiaData等
	 */
	public static void dataDelete(Map<String, Object> conditions,
			BaiduListenerAdapter listener) {
		FrontiaQuery query = BaiduHelper.buildQuery(conditions);
		BaiduFactory.getStorage().deleteData(query, listener);
	}

	/**
	 * 更新数据,參見FrontiaData等
	 */
	public static void dataUpdate(Map<String, Object> data,
			Map<String, Object> conditions,
			BaiduListenerAdapter listener) {
		FrontiaData fd = BaiduHelper.buildData(data);
		FrontiaQuery query = BaiduHelper.buildQuery(conditions);
		BaiduFactory.getStorage().updateData(query, fd, listener);
	}

	/**
	 * 查询数据,參見FrontiaData等
	 */
	@Reference(note = "http://developer.baidu.com/wiki/index.php?title=docs/frontia")
	public static void dataFind(Map<String, Object> conditions,
			BaiduListenerAdapter listener) {
		FrontiaQuery query = BaiduHelper.buildQuery(conditions);
		BaiduFactory.getStorage().findData(query, listener);
	}

	/**
	 * 三种推送方式：向特定用户推送，根据标签分类向特定用户群体推送，以及向所有用户推送 参见:
	 * 向一个Tag推送一个消息：Tag==person.id;person.group.id等...
	 */
	@Reference(note = "http://developer.baidu.com/wiki/index.php?title=docs/frontia")
	public static void msgPush(String targetTag, String text,
			BaiduListenerAdapter listener) {
		FrontiaPushUtil.MessageContent msg = BaiduHelper.buildMsg(text);
		BaiduFactory.getPush().pushMessage(targetTag, msg, listener);
	}
	
	/**
	 * 推送所有人..
	 */
	public static void msgPush(String text,
			BaiduListenerAdapter listener) {
		FrontiaPushUtil.MessageContent msg = BaiduHelper.buildMsg(text);
		BaiduFactory.getPush().pushMessage(msg, listener);
	}
}
