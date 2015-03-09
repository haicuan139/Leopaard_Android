package com.leopaard.cn;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.leopaard.cn.domain.AppAuthVO;
import com.leopaard.cn.domain.Content;

public class BaseActivity extends Activity implements Content{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sp = getSharedPreferences(CONFIG_NAME, MODE_PRIVATE);
	}
	protected int getUserAuth() {
		return getIntValueForKey(USER_AUTH);
	}
	protected void setUserAuth(int auth) {
		setIntForKey(USER_AUTH, auth);
	}
	private SharedPreferences sp;
//	public static final String TONGYONG_A = "tongyong_a.json";
//	public static final String TONGYONG_B = "tongyong_b.json";
//	public  static final String PEIXUN_A = "peixun_a.json";
//	public  static final String PEIXUN_B = "peixun_b.json";
//	public  static final String ZIXUN_A = "zixun_a.json";
//	public  static final String ZIXUN_B = "zixun_b.json";
//	public  static final String GENGDUO = "gengduo.json";

	public static final int TONGYONG = 1;
	public static final int ZIXUN = 2;
	public static final int PEIXUN = 3;
	public static final int GENGDUO = 4;
	protected List<AppAuthVO> getItemDatasWhthTabType(int type) {
		String str = getStringValueForKey(ITEM_JSON);
//		try {
//			InputStream in = getAssets().open("itemjson.json");
//			  byte b[]=new byte[in.available()];   
//			  in.read(b);    
//			  in.close();
//			  str = new String(b);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		List<AppAuthVO> datas = new ArrayList<AppAuthVO>();
		if(TextUtils.isEmpty(str)){
			return datas;
		}
		AppAuthVO data = new Gson().fromJson(str, AppAuthVO.class);
		for (int i = 0; i < data.getAuthList().size(); i++) {
			AppAuthVO r = data.getAuthList().get(i);
			if( Integer.parseInt(r.getTabType()) == type){
				datas.add(r);
			}
		}
		return datas;
	}
	protected void setStringtForKey(String key, String value) {
		sp.edit().putString(key, value).commit();
	}

	protected void setBooleanForKey(String key, boolean value) {
		sp.edit().putBoolean(key, value).commit();
	}

	protected void setIntForKey(String key, int value) {
		sp.edit().putInt(key, value).commit();
	}

	protected void setFloatForKey(String key, float value) {
		sp.edit().putFloat(key, value).commit();
	}

	protected String getStringValueForKey(String key) {
		return sp.getString(key, "");
	}

	protected float getFloatValueForKey(String key) {
		return sp.getFloat(key, 0.0f);
	}

	protected boolean getBoleanValueForKey(String key) {
		return sp.getBoolean(key, false);
	}

	protected int getIntValueForKey(String key) {
		return sp.getInt(key, 0);
	}
}
