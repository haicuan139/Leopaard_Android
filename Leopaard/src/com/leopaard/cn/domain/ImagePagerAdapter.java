/*
 * Copyright 2014 trinea.cn All right reserved. This software is the confidential and proprietary information of
 * trinea.cn ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with trinea.cn.
 */
package com.leopaard.cn.domain;

import java.util.List;

import net.tsz.afinal.FinalBitmap;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.leopaard.cn.R;

/**
 * ImagePagerAdapter
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2014-2-23
 */
public class ImagePagerAdapter extends RecyclingPagerAdapter{

    private Context       context;
    private FinalBitmap mFinalBitmap;
    private int           size;
    private boolean       isInfiniteLoop;
    List<CflbInformation> mLoopAdInfos;
    public ImagePagerAdapter(Context context, List<CflbInformation> mLoopAdInfos) {
    	this.mLoopAdInfos = mLoopAdInfos;
    	mFinalBitmap = FinalBitmap.create(context);
        this.context = context;
        this.size = mLoopAdInfos.size();
        isInfiniteLoop = false;
        
    }

    @Override
    public int getCount() {
        // Infinite loop
        return isInfiniteLoop ? Integer.MAX_VALUE : mLoopAdInfos.size();
    }

    /**
     * get really position
     * 
     * @param position
     * @return
     */
    private int getPosition(int position) {
        return isInfiniteLoop ? position % size : position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup container) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = holder.imageView = new ImageView(context);
            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }
        String url = mLoopAdInfos.get(getPosition(position)).getI_save_path();
        mFinalBitmap.display(holder.imageView , url,BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher));
        holder.imageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
//				Intent i = new Intent(context,ActivityAdDetail_HTML5.class);
//				i.putExtra(INTENT_KEY_ADINFO, mLoopAdInfos.get(getPosition(position)));
//				context.startActivity(i);
			}
		});
        return view;
    }

    private static class ViewHolder {

        ImageView imageView;
    }

    /**
     * @return the isInfiniteLoop
     */
    public boolean isInfiniteLoop() {
        return isInfiniteLoop;
    }

    
    /**
     * @param isInfiniteLoop the isInfiniteLoop to set
     */
    public ImagePagerAdapter setInfiniteLoop(boolean isInfiniteLoop) {
        this.isInfiniteLoop = isInfiniteLoop;
        return this;
    }
}
