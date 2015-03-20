package com.leopaard.cn.ui;

import java.util.List;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.leopaard.cn.AutoScrollViewPager;
import com.leopaard.cn.BaseActivity;
import com.leopaard.cn.R;
import com.leopaard.cn.domain.AppAuthVO;
import com.leopaard.cn.domain.CflbInformation;
import com.leopaard.cn.domain.ImagePagerAdapter;
import com.leopaard.cn.domain.LeopaardDelegateSingleInstance;
import com.leopaard.cn.domain.Message;
import com.leopaard.cn.domain.UserChangeCallBack;

public class TongYongActivity_1 extends BaseActivity implements OnItemClickListener,UserChangeCallBack{
	private List<AppAuthVO> dataSourceList;
	private DragGridView mDragGridView;
	private DragAdapter mDragAdapter;
	private AutoScrollViewPager mAdPager;
	private ImagePagerAdapter mImagePagerAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		LeopaardDelegateSingleInstance.getInstance().addListener(this);;
		initData();
	}

	private void initData(){
		mAdPager = (AutoScrollViewPager) findViewById(R.id.adPager);
		dataSourceList = getItemDatasWhthTabType(TONGYONG);
 		mDragGridView = (DragGridView) findViewById(R.id.dragGridView);
 		mDragGridView.setOnItemClickListener(this);
		mDragAdapter = new DragAdapter(this, dataSourceList);
		new FinalHttp().post("http://114.215.84.87:8080/cflb/cflb/cflbInformationControl/app_query_img.htm", new AjaxCallBack<String>() {
			@Override
			public void onStart() {
				super.onStart();
			}
			@Override
			public void onSuccess(String t) {
				List<CflbInformation> fs = new Gson().fromJson(t, new TypeToken<List<CflbInformation>>() {  
                }.getType());
				mImagePagerAdapter = new ImagePagerAdapter(
						TongYongActivity_1.this, fs);
				mImagePagerAdapter.setInfiniteLoop(true);
				mAdPager.setAdapter(mImagePagerAdapter);
				mAdPager.setInterval(3000);
				mAdPager.setBorderAnimation(true);
				mAdPager.startAutoScroll();
				mAdPager.setCurrentItem(0,true);
				
				super.onSuccess(t);
			}
			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				super.onFailure(t, errorNo, strMsg);
				Toast.makeText(getApplicationContext(), "网络异常,消息获取失败", Toast.LENGTH_SHORT).show();;
			}
		});
		//获得消息
		new FinalHttp().post("http://114.215.84.87:8080/cflb//cflb/cflbInformationControl/app_query_msg.htm", new AjaxCallBack<String>() {
			@Override
			public void onSuccess(String t) {
				super.onSuccess(t);
				Message msg = new Gson().fromJson(t, Message.class);
				TextView tv = (TextView) findViewById(R.id.scrolltext);
				tv.setText(msg.getVal());
			}
			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				Toast.makeText(getApplicationContext(), "网络异常,消息获取失败", Toast.LENGTH_SHORT).show();;
				super.onFailure(t, errorNo, strMsg);
			}
		});
		mDragGridView.setAdapter(mDragAdapter);		
	}
	@Override 
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
		Intent i = new Intent(this, H5PageActivity.class);
		i.putExtra("url", dataSourceList.get(position).getUrl());
		startActivity(i);		
	}

	@Override
	public void onUserTypeChange(int type) {
		Log.i("TYPE", "userType = "+type);
		dataSourceList = getItemDatasWhthTabType(TONGYONG);
		mDragAdapter.notifyDataSetChanged();
		
	}

}
