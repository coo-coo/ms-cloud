package com.coo.ms.cloud.weixin;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.coo.ms.cloud.model.NetLink;
import com.coo.ms.cloud.model.NetText;

/**
 * 采用Handler进行消息的发送,实现WeixinAPI的次线程发送
 * 
 * @author boqing.shen
 * @since 1.0.0.0
 */
public class WeixinHandler extends Handler {
	private Context context;

	private static int WHAT = 10001;

	/**
	 * 构造方法,引入Context
	 * 
	 * @param context
	 */
	public WeixinHandler(Context context) {
		this.context = context;
	}

	/**
	 * 分享NetText
	 * 
	 * @param nt
	 */
	public void share(NetText nt) {
		this.sendMessage(message(nt));
	}

	/**
	 * 分享NetLink
	 * 
	 * @param nt
	 */
	public void share(NetLink nl) {
		this.sendMessage(message(nl));
	}

	/**
	 * 创建Message
	 * 
	 * @param obj
	 * @return
	 */
	private static Message message(Object obj) {
		Message msg = new Message();
		msg.what = WHAT;
		msg.obj = obj;
		return msg;
	}

	@Override
	public void handleMessage(Message msg) {
		if (msg.obj instanceof NetText) {
			NetText nt = (NetText) msg.obj;
			WeixinApi.share(context, nt);
		} else if (msg.obj instanceof NetLink) {
			NetLink nl = (NetLink) msg.obj;
			WeixinApi.share(context, nl);
		} else {

		}
	};
}
