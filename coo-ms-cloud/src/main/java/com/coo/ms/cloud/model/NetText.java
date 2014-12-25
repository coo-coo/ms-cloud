package com.coo.ms.cloud.model;

public class NetText extends NetObject{
	
	public NetText() {
		// TODO Auto-generated constructor stub
	}
	
	public NetText(String text) {
		this.text = text;
		this.title = text;
		this.description = text;
	}
	
	/**
	 * 网络文本
	 */
	private String text = "";
	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
