package com.coo.ms.cloud.weixin;

import android.content.Context;

import com.coo.ms.cloud.model.NetLink;
import com.coo.ms.cloud.model.NetText;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendMessageToWX;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXTextObject;
import com.tencent.mm.sdk.openapi.WXWebpageObject;

public final class WeixinFactory {

	/**
	 * 微信APPID,参见https://open.weixin.qq.com,消磨(正式)
	 */
	public static String APP_ID = "wx8547e71956ff84f6";

	@SuppressWarnings("unused")
	private static String APP_SECRET = "c6bf3d47170ea4b7474707ceedbb7039";

	/**
	 * 创建微信API
	 * 
	 * @deprecated
	 */
	public static IWXAPI createApi(Context context) {
		return WXAPIFactory.createWXAPI(context, APP_ID);
	}

	/**
	 * 创建链接对象分享请求
	 */
	public static SendMessageToWX.Req buildReq(NetLink obj) {
		// 初始化一个WXWebpageObject对象
		WXWebpageObject webpage = new WXWebpageObject();
		webpage.webpageUrl = obj.getUrl();

		// 初始化一个WXMediaMessage对象
		WXMediaMessage msg = new WXMediaMessage(webpage);
		msg.title = obj.getTitle();
		msg.description = obj.getDescription();
		msg.thumbData = WeixinHelper.bmpToByteArray(obj.getThumb(),
				false);
		
		
		
		// 构造一个Req
		SendMessageToWX.Req req = new SendMessageToWX.Req();
		req.transaction = buildTransaction("NL");
		req.message = msg;
		req.scene = obj.getWxScene();
		return req;
	}

	/**
	 * 创建文本对象分享请求
	 */
	public static SendMessageToWX.Req buildReq(NetText obj) {
		// 初始化一个WXTextObject对象
		WXTextObject textObj = new WXTextObject();
		textObj.text = obj.getText();

		// 初始化一个WXMediaMessage对象
		WXMediaMessage msg = new WXMediaMessage();
		msg.mediaObject = textObj;
		// 发送文本类型的消息时，title字段不起作用
		// msg.title = obj.getTitle();
		msg.description = obj.getDescription();

		// 构造一个Req
		SendMessageToWX.Req req = new SendMessageToWX.Req();
		req.transaction = buildTransaction("NT");
		req.message = msg;
		// 缺省是微信会话
		req.scene = obj.getWxScene();
		return req;
	}

	// //////////////////////////////////////////////////////////////////////////////

	private static String buildTransaction(String tag) {
		// transaction字段用于唯一标识一个请求
		return "COO-WX-" + tag + System.currentTimeMillis();
	}

	private WeixinFactory() {
		// TODO Auto-generated constructor stub
	}

}
