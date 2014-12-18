package com.coo.ms.cloud.baidu;

import com.baidu.frontia.Frontia;
import com.baidu.frontia.FrontiaApplication;
import com.baidu.frontia.api.FrontiaPush;
import com.baidu.frontia.api.FrontiaStorage;

public final class BaiduFactory {

	private BaiduFactory() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 检查初始化
	 */
	public static boolean INITED = false;

	/**
	 * 初始化百度SDK...在Application中初始化该方法
	 */
	public static boolean initSDK(android.content.Context context) {
		// FrontiaApplication初始化,否则报FrontiaImpl找不到等错误
		FrontiaApplication.initFrontiaApplication(context);
		// 初始化APIKey
		boolean result = Frontia.init(context, APIKEY);
		// 赋值给INITED备用
		INITED = result;
		return result;
	}

	/**
	 * APIKEY:http://developer.baidu.com/console#app/3349453
	 */
	private static String APIKEY = "O5G0O6oo7T9mAhqQqWEl5XCX";

	private static FrontiaStorage frontiaStorage = null;

	private static FrontiaPush frontiaPush = null;

	/**
	 * 获得存储句柄
	 * 
	 * @return
	 */
	public static synchronized FrontiaStorage getStorage() {
		if (frontiaStorage == null) {
			frontiaStorage = Frontia.getStorage();
		}
		return frontiaStorage;
	}

	/**
	 * 获得Push句柄
	 * 
	 * @return
	 */
	public static synchronized FrontiaPush getPush() {
		if (frontiaPush == null) {
			frontiaPush = Frontia.getPush();
		}
		return frontiaPush;
	}

}
