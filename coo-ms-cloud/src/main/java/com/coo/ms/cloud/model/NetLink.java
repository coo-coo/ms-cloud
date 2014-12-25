package com.coo.ms.cloud.model;

import android.graphics.Bitmap;

/**
 * 一个网络链接
 * 
 * @author boqing.shen
 * 
 */
public class NetLink extends NetObject{
	
	
	public NetLink() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 构造函数,标题,连接地址,本地Icon
	 */
	public NetLink(String title, String url, Bitmap thumb) {
		this.title = title;
		this.url = url;
		this.thumb = thumb;
	}

	public NetLink(String title, String url, String icon) {
		this.title = title;
		this.url = url;
		this.icon = icon;
	}

	/**
	 * 网络链接
	 */
	private String url = "";
	/**
	 * Icon网络资源
	 */
	private String icon = "";
	
	
	/**
	 * Icon本地Bitmap资源:Bitmap thumb =
	 * BitmapFactory.decodeResource(getResources(),
	 * R.drawable.send_music_thumb);
	 */
	private Bitmap thumb = null;

	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Bitmap getThumb() {
		return thumb;
	}

	public void setThumb(Bitmap thumb) {
		this.thumb = thumb;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
