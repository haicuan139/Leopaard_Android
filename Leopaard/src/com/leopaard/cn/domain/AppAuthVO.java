package com.leopaard.cn.domain;

import java.util.List;

/**
 * APP 端 权限
 * 
 * @author panyf
 * 
 */
public class AppAuthVO {

	private List<AppAuthVO> authList;
	private String userAuth = "";
	private String tabType = "";
	private String title = "";
	private String icon = "";
	private String url = "";

	public String getUserAuth() {
		return userAuth;
	}

	public void setUserAuth(String userAuth) {
		this.userAuth = userAuth;
	}

	public String getTabType() {
		return tabType;
	}

	public void setTabType(String tabType) {
		this.tabType = tabType;
	}

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

	public List<AppAuthVO> getAuthList() {
		return authList;
	}

	public void setAuthList(List<AppAuthVO> authList) {
		this.authList = authList;
	}

}
