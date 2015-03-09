package com.leopaard.cn.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;

import com.leopaard.cn.BaseActivity;
import com.leopaard.cn.R;
import com.leopaard.cn.ScrollMainActivity;

public class SplashActivity extends BaseActivity {

	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			finish();
			if(!getBoleanValueForKey(FIRST_RUN)){
				startActivity(new Intent(SplashActivity.this, WelcomeActivity.class));
				setBooleanForKey(FIRST_RUN, true);
			} else {
				String user = getStringValueForKey(USER_NAME);
				String pass = getStringValueForKey(PASS_WORD);
				if(!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)){
					startActivity(new Intent(
							SplashActivity.this,
							ScrollMainActivity.class));
				} else {
					startActivity(new Intent(SplashActivity.this, LoginActivity.class));
				}
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		//读取ITEM信息
//		new FinalHttp().get("http://114.215.196.175/itemjson.json", new AjaxCallBack<String>() {
//			@Override
//			public void onSuccess(String t) {
//				super.onSuccess(t);
//				setStringtForKey(ITEM_JSON, t);
//				new Thread(new Runnable() {
//					@Override
//					public void run() {
//						SystemClock.sleep(1000);
//						mHandler.sendEmptyMessage(0);
//					}
//				}).start();
//			}
//			@Override
//			public void onFailure(Throwable t, int errorNo, String strMsg) {
//				super.onFailure(t, errorNo, strMsg);
//				Toast.makeText(getApplicationContext(), "网络异常", Toast.LENGTH_SHORT).show();
//			}
//		});
		new Thread(new Runnable() {
			@Override
			public void run() {
				SystemClock.sleep(1000);
				mHandler.sendEmptyMessage(0);
			}
		}).start();		
	}
}
