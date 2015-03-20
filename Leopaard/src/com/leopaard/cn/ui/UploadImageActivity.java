package com.leopaard.cn.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.leopaard.cn.BaseActivity;
import com.leopaard.cn.R;
import com.leopaard.cn.domain.UploadRetObj;

public class UploadImageActivity extends BaseActivity {

	private File uploadImageLocalPath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uploadimage);
		findViewById(R.id.rightItem).setVisibility(View.GONE);
		uploadImageLocalPath = new File(getCacheDir(),"uploadimage.jpg");
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.takePhoto:
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(intent, 1);
			break;
		case R.id.xiangce:
			Intent picture = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(picture, 2);
			break;
		case R.id.upload:
			upload();
			break;

		default:
			break;
		}
	}

	private void upload() {
		AjaxParams params = new AjaxParams();
		try {
			params.put("file", uploadImageLocalPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		params.put("user_id", getStringValueForKey("uid"));
		String type = getIntent().getStringExtra("uploadType");
		params.put("action_type", type);
		new FinalHttp()
				.post("http://114.215.84.87:8080/cflb/cflb/uploadFileUtilControl/app_upload_img",
						params, new AjaxCallBack<String>() {
							@Override
							public void onSuccess(String t) {
								super.onSuccess(t);
								UploadRetObj o = new Gson().fromJson(t, UploadRetObj.class);
								Toast.makeText(getApplicationContext(), o.getMsg(), Toast.LENGTH_SHORT).show();
								if(o.getCode().contains("00")){
									//成功
									Intent i = new Intent();
									i.putExtra("retUrl", o.getVal());
									setResult(10,i);
									finish();
								}
							}

							@Override
							public void onFailure(Throwable t, int errorNo,
									String strMsg) {
								super.onFailure(t, errorNo, strMsg);
								Toast.makeText(getApplicationContext(), "网络异常",
										Toast.LENGTH_SHORT).show();
							}
						});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_OK && requestCode == 1) {
			Bundle bundle = data.getExtras();
			Bitmap bitmap = saveImage(bundle);
			ImageView i = (ImageView) findViewById(R.id.takeimage);
			i.setImageBitmap(bitmap);
		} else if(resultCode == Activity.RESULT_OK && requestCode == 2){
			//相册
				Uri selectedImage = data.getData();
			   String[] filePathColumns={MediaStore.Images.Media.DATA};
			   Cursor c = this.getContentResolver().query(selectedImage, filePathColumns, null,null, null);
			   c.moveToFirst();
			   int columnIndex = c.getColumnIndex(filePathColumns[0]);
			   String picturePath= c.getString(columnIndex);
			   c.close();
			   //保存图片
			   Bitmap bitmap = BitmapFactory.decodeFile(picturePath);
			   ImageView i = (ImageView) findViewById(R.id.takeimage);
			   i.setImageBitmap(bitmap);
			   FileOutputStream b = null;
				try {
					b = new FileOutputStream(uploadImageLocalPath);
					bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						b.flush();
						b.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
		}
	}

	private Bitmap saveImage(Bundle bundle) {
		Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式
		FileOutputStream b = null;
		try {
			b = new FileOutputStream(uploadImageLocalPath);
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				b.flush();
				b.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bitmap;
	}
}
