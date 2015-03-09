package com.leopaard.cn.ui;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.leopaard.cn.BaseActivity;
import com.leopaard.cn.R;
import com.leopaard.cn.domain.AppAuthVO;
import com.leopaard.cn.domain.LeopaardDelegateSingleInstance;
import com.leopaard.cn.domain.UserChangeCallBack;

public class TongYongActivity_1 extends BaseActivity implements OnItemClickListener,UserChangeCallBack{
	private List<AppAuthVO> dataSourceList;
	private DragGridView mDragGridView;
	private DragAdapter mDragAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		LeopaardDelegateSingleInstance.getInstance().addListener(this);;
		initData();
		 
	}

	private void initData(){
		dataSourceList = getItemDatasWhthTabType(TONGYONG);
 		mDragGridView = (DragGridView) findViewById(R.id.dragGridView);
 		mDragGridView.setOnItemClickListener(this);
		mDragAdapter = new DragAdapter(this, dataSourceList);
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
