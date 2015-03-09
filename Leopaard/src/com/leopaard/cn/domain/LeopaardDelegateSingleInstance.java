package com.leopaard.cn.domain;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

public class LeopaardDelegateSingleInstance {

	private static LeopaardDelegateSingleInstance mLeopaardDelegateSingleInstance = null;
	private List<UserChangeCallBack> mCallBacks = new ArrayList<UserChangeCallBack>(); 
	private LeopaardDelegateSingleInstance() {
		
	}
	public static LeopaardDelegateSingleInstance getInstance(){
		if(mLeopaardDelegateSingleInstance == null){
			mLeopaardDelegateSingleInstance = new LeopaardDelegateSingleInstance();
		}
		return mLeopaardDelegateSingleInstance;
	}
	public void addListener(UserChangeCallBack callBack){
		if(mCallBacks != null){
			mCallBacks.add(callBack);
		}
	}
	public void fireUserChangeTypeEvent(int type){
		//保存用户权限
		for (int i = 0; i < mCallBacks.size(); i++) {
			UserChangeCallBack c = mCallBacks.get(i);
			c.onUserTypeChange(type);
		}
	}
}
