package com.leopaard.cn.domain;


import java.io.Serializable;

public class RowsData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userAuth;
	private int tabType;
	private String title;
	private String icon;
	private String url;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getUserAuth() {
		return userAuth;
	}
	public void setUserAuth(int userAuth) {
		this.userAuth = userAuth;
	}
	public int getTabType() {
		return tabType;
	}
	public void setTabType(int tabType) {
		this.tabType = tabType;
	}
}
