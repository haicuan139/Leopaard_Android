package com.leopaard.cn.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.leopaard.cn.R;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewPager pager = new ViewPager(this);
		ImageView nav_1 = new ImageView(this);
		nav_1.setBackgroundResource(R.drawable.w1);
		ImageView nav_2 = new ImageView(this);
		nav_2.setBackgroundResource(R.drawable.w2);
		nav_2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
				startActivity(new Intent(WelcomeActivity.this , LoginActivity.class));
			}
		});
		List<View> list = new ArrayList<View>();
		list.add(nav_1);
		list.add(nav_2);
		pager.setAdapter(new MyPagerAdapter(list));
		setContentView(pager);
	}
	/**
     * ViewPager适配器
*/
    public class MyPagerAdapter extends PagerAdapter {
        public List<View> mListViews;

        public MyPagerAdapter(List<View> mListViews) {
            this.mListViews = mListViews;
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView(mListViews.get(arg1));
        }

        @Override
        public void finishUpdate(View arg0) {
        }

        @Override
        public int getCount() {
            return mListViews.size();
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(mListViews.get(arg1), 0);
            return mListViews.get(arg1);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == (arg1);
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {
        }
    }
}
