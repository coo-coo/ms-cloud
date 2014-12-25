package com.coo.ms.cloud.model;

public class NetObject {

	/**
	 * 微信会话
	 */
	public static final int WxSceneSession = 0;
	/**
	 * 微信朋友圈
	 */
	public static final int WxSceneTimeline = 1;

	public NetObject() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 网络标题
	 */
	protected String title = "";
	/**
	 * 网络描述
	 */
	protected String description = "";
	/**
	 * 微信分享场景
	 */
	protected int wxScene = WxSceneSession;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getWxScene() {
		return wxScene;
	}

	public void setWxScene(int wxScene) {
		this.wxScene = wxScene;
	}
}
