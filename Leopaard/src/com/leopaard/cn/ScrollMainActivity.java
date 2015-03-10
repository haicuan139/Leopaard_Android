package com.leopaard.cn;

import java.util.ArrayList;
import java.util.List;

import android.app.ActivityGroup;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leopaard.cn.ui.HomeViewPagerAdapter;
import com.leopaard.cn.ui.LoginActivity;
import com.leopaard.cn.ui.MoreActivity;
import com.leopaard.cn.ui.MyViewPager;
import com.leopaard.cn.ui.PeiXunActivity;
import com.leopaard.cn.ui.TongYongActivity_1;
import com.leopaard.cn.ui.ZiXunActivity;

@SuppressWarnings("deprecation")
public class ScrollMainActivity extends ActivityGroup implements android.view.View.OnClickListener{
	private MyViewPager mHomePager;
	private String[] titleIds = null;
	private List<Button> mTableButtonList;
	private TextView titleText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainscroll);
		titleIds = new String[] { getResources().getString(R.string.tongyong), getResources().getString(R.string.zixun),getResources().getString(R.string.peixun), getResources().getString(R.string.gengduo) };
		mHomePager = (MyViewPager) findViewById(R.id.homePager);
		mHomePager.setOffscreenPageLimit(4);
		mHomePager.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				return true;
			}
		});
		View home = getLocalActivityManager().startActivity("tongyong",
				new Intent(this, TongYongActivity_1.class)).getDecorView();
		View zixun = getLocalActivityManager().startActivity("zixun",
				new Intent(this, ZiXunActivity.class)).getDecorView();
		View peixun = getLocalActivityManager().startActivity("peixun", 
				new Intent(this, PeiXunActivity.class)).getDecorView();
		View more = getLocalActivityManager().startActivity("more",
				new Intent(this, MoreActivity.class)).getDecorView();
		List<View> mListViews = new ArrayList<View>();
		mListViews.add(home);
		mListViews.add(zixun);
		mListViews.add(peixun);
		mListViews.add(more);
		HomeViewPagerAdapter mAdapter = new HomeViewPagerAdapter(mListViews);
		titleText = (TextView) findViewById(R.id.titleText);
		mHomePager.setAdapter(mAdapter);
		LinearLayout tab = (LinearLayout) findViewById(R.id.bottomlayout);
		mTableButtonList = new ArrayList<Button>();
		for (int i = 0; i < tab.getChildCount(); i++) {
			Button b = (Button) tab.getChildAt(i);
			mTableButtonList.add(b);
			b.setOnClickListener(this);
		}
		mHomePager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				titleText.setText(titleIds[position]);
				changeButtonColor(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
		mHomePager.setCurrentItem(0, true);
		changeButtonColor(0);
		findViewById(R.id.leftItem).setOnClickListener(this);
		findViewById(R.id.rightItem).setOnClickListener(this);
		
	}
	private void changeButtonColor(int position) {
		switch (position) {
		case 0:
			
			mTableButtonList.get(0).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.bottom_home_selected), null, null);
			mTableButtonList.get(1).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.bottom_recommed_normal), null, null);
			mTableButtonList.get(2).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.bottom_my_normal), null, null);
			mTableButtonList.get(3).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.bottom_more_normal), null, null);
			mTableButtonList.get(0).setTextColor(Color.parseColor("#13369B"));
			mTableButtonList.get(1).setTextColor(Color.parseColor("#777777"));
			mTableButtonList.get(2).setTextColor(Color.parseColor("#777777"));
			mTableButtonList.get(3).setTextColor(Color.parseColor("#777777"));
			break;
		case 1:
			mTableButtonList.get(0).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.bottom_home_normal), null, null);
			mTableButtonList.get(1).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.bottom_recommed_selected), null, null);
			mTableButtonList.get(2).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.bottom_my_normal), null, null);
			mTableButtonList.get(3).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.bottom_more_normal), null, null);
			mTableButtonList.get(0).setTextColor(Color.parseColor("#777777"));
			mTableButtonList.get(1).setTextColor(Color.parseColor("#13369B"));
			mTableButtonList.get(2).setTextColor(Color.parseColor("#777777"));
			mTableButtonList.get(3).setTextColor(Color.parseColor("#777777"));
			break;
		case 2:
			mTableButtonList.get(0).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.bottom_home_normal), null, null);
			mTableButtonList.get(1).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.bottom_recommed_normal), null, null);
			mTableButtonList.get(2).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.bottom_my_selected), null, null);
			mTableButtonList.get(3).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.bottom_more_normal), null, null);
			mTableButtonList.get(0).setTextColor(Color.parseColor("#777777"));
			mTableButtonList.get(1).setTextColor(Color.parseColor("#777777"));
			mTableButtonList.get(2).setTextColor(Color.parseColor("#13369B"));
			mTableButtonList.get(3).setTextColor(Color.parseColor("#777777"));
			break;
		case 3:
			mTableButtonList.get(0).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.bottom_home_normal), null, null);
			mTableButtonList.get(1).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.bottom_recommed_normal), null, null);
			mTableButtonList.get(2).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.bottom_my_normal), null, null);
			mTableButtonList.get(3).setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.bottom_more_selected), null, null);
			mTableButtonList.get(0).setTextColor(Color.parseColor("#777777"));
			mTableButtonList.get(1).setTextColor(Color.parseColor("#777777"));
			mTableButtonList.get(2).setTextColor(Color.parseColor("#777777"));
			mTableButtonList.get(3).setTextColor(Color.parseColor("#13369B"));
			break;

		default:
			break;
		}
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.tab_index:
			mHomePager.setCurrentItem(0, true);
			changeButtonColor(0);
			break;
		case R.id.tab_recommend:
			mHomePager.setCurrentItem(1, true);
			changeButtonColor(1);
			break;
		case R.id.tab_my:
			mHomePager.setCurrentItem(2, true);
			changeButtonColor(2);
			break;
		case R.id.tab_more:
			mHomePager.setCurrentItem(3, true);
			changeButtonColor(3);
			break;
		case R.id.leftItem:
			break;
		case R.id.rightItem:
			startActivity(new Intent(this , LoginActivity.class));
			break;
		default:
			break;
		}		
	}
}
