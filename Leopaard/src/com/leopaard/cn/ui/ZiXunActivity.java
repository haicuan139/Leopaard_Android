package com.leopaard.cn.ui;

import java.io.IOException;
import java.util.List;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.leopaard.cn.BaseActivity;
import com.leopaard.cn.R;
import com.leopaard.cn.domain.AppAuthVO;
import com.leopaard.cn.domain.RowsData;
import com.leopaard.cn.domain.UserChangeCallBack;

public class ZiXunActivity extends BaseActivity implements OnItemClickListener ,UserChangeCallBack{

	private ListView mListView;
	private List<AppAuthVO> datas;
	private MyAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zixun);
		mListView = (ListView) findViewById(R.id.listView);
		mListView.setDivider(new ColorDrawable(Color.parseColor("#E3E3E3")));  
		mListView.setDividerHeight(1);
		mListView.setOnItemClickListener(this);
		datas = getItemDatasWhthTabType(ZIXUN);
		mAdapter = new MyAdapter();
		mListView.setAdapter(mAdapter);
		
	}
	class MyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return datas.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			AppAuthVO data = datas.get(position);
			View view = View.inflate(ZiXunActivity.this, R.layout.list_item, null);
			ImageView i = (ImageView) view.findViewById(R.id.itemImage);
			TextView t = (TextView) view.findViewById(R.id.itemText);
			try {
				Bitmap b = BitmapFactory.decodeStream(getAssets().open(data.getIcon()));
					i.setImageBitmap(b);
			} catch (IOException e) {
				i.setBackgroundResource(R.drawable.ic_launcher);;
				e.printStackTrace();
			}
			t.setText(data.getTitle());
			return view;
		}
		
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		Intent i = new Intent(this, H5PageActivity.class);
		i.putExtra("url", datas.get(position).getUrl());
		startActivity(i);
	}
	@Override
	public void onUserTypeChange(int type) {
		datas = getItemDatasWhthTabType(ZIXUN);
		mAdapter.notifyDataSetChanged();
	}
}
