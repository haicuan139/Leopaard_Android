package com.leopaard.cn.ui;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.leopaard.cn.R;
import com.leopaard.cn.domain.AppAuthVO;
import com.leopaard.cn.domain.RowsData;
/**
 * @blog http://blog.csdn.net/xiaanming 
 * 
 * @author xiaanming 
 *
 */
public class DragAdapter extends BaseAdapter implements DragGridBaseAdapter{
	private List<AppAuthVO> list;
	private LayoutInflater mInflater;
	private int mHidePosition = -1;
	private Context mContext;
	public DragAdapter(Context context, List<AppAuthVO> list){
		this.list = list;
		this.mContext = context;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * ���ڸ���convertView����ĳЩitem��ʧ�ˣ��������ﲻ����item��
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = mInflater.inflate(R.layout.grid_item, null);
		ImageView mImageView = (ImageView) convertView.findViewById(R.id.item_image);
		TextView mTextView = (TextView) convertView.findViewById(R.id.item_text);
		AppAuthVO data = list.get(position);
//		mImageView.setBackgroundResource(R.drawable.ic_launcher);
		try {
			Bitmap b = BitmapFactory.decodeStream(mContext.getAssets().open(data.getIcon()));
				mImageView.setImageBitmap(b);
		} catch (IOException e) {
			mImageView.setBackgroundResource(R.drawable.ic_launcher);;
			e.printStackTrace();
		}
		mTextView.setText((CharSequence) data.getTitle());
		if(position == mHidePosition){
			convertView.setVisibility(View.INVISIBLE);
		}
		return convertView;
	}
	

	@Override
	public void reorderItems(int oldPosition, int newPosition) {
		AppAuthVO temp = list.get(oldPosition);
		if(oldPosition < newPosition){
			for(int i=oldPosition; i<newPosition; i++){
				Collections.swap(list, i, i+1);
			}
		}else if(oldPosition > newPosition){
			for(int i=oldPosition; i>newPosition; i--){
				Collections.swap(list, i, i-1);
			}
		}
		
		list.set(newPosition, temp);
	}

	@Override
	public void setHideItem(int hidePosition) {
		this.mHidePosition = hidePosition; 
		notifyDataSetChanged();
	}


}
