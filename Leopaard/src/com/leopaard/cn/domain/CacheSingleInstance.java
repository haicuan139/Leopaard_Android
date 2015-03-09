package com.leopaard.cn.domain;

public class CacheSingleInstance {

	private SysUser userInfo; 
	private static CacheSingleInstance mCacheSingleInstance= null;
	private CacheSingleInstance() {
	}
	public static CacheSingleInstance getInstance(){
		if(mCacheSingleInstance == null){
			mCacheSingleInstance = new CacheSingleInstance();
		}
		return mCacheSingleInstance;
	}
	public SysUser getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(SysUser userInfo) {
		this.userInfo = userInfo;
	}
}
