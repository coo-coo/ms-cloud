package com.coo.ms.cloud.weixin;

import android.content.Context;

import com.coo.ms.cloud.model.NetLink;
import com.coo.ms.cloud.model.NetText;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendMessageToWX;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

public final class WeixinApi {

	public WeixinApi() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 注册SDK,参见WeixinApi.register(getApplicationContext());
	 * @param context
	 */
	public static void register(Context context) {
		IWXAPI wxapi = WXAPIFactory.createWXAPI(context, null);
		wxapi.registerApp(WeixinFactory.APP_ID);
	}
	
	/**
	 * 分享文本
	 * @param nt
	 */
	public static boolean share(Context context,NetText object) {
		IWXAPI wxapi = WXAPIFactory.createWXAPI(context, WeixinFactory.APP_ID);
		SendMessageToWX.Req req = WeixinFactory.buildReq(object);
		return wxapi.sendReq(req);
	}
	
	/**
	 * 分享連接
	 * @param nt
	 */
	public static boolean share(Context context,NetLink object) {
		IWXAPI wxapi = WXAPIFactory.createWXAPI(context, WeixinFactory.APP_ID);
		SendMessageToWX.Req req = WeixinFactory.buildReq(object);
		return wxapi.sendReq(req);
	}

}
