package com.leopaard.cn.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.leopaard.cn.BaseActivity;
import com.leopaard.cn.R;

@SuppressLint("NewApi")
public class H5PageActivity extends BaseActivity implements
		NativeJavaScriptCallBack {

	private WebView mWebView;
	private ProgressBar mProgressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_h5page);
		mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
		 String url = getIntent().getStringExtra("url");
		mWebView = (WebView) findViewById(R.id.webview);
		mWebView.loadUrl(url);
		initWebSetting(mWebView);
		findViewById(R.id.leftItem).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}

	@SuppressLint("JavascriptInterface")
	private void initWebSetting(WebView webview) {
		WebSettings webSettings = webview.getSettings();
		webSettings.setAllowContentAccess(true);
		webSettings.setAllowFileAccess(true);
		webSettings.setDomStorageEnabled(true);
		webSettings.setDatabaseEnabled(true);
		webSettings.setUseWideViewPort(true);
		webSettings.setJavaScriptEnabled(true);
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
		webSettings.setRenderPriority(RenderPriority.HIGH);
		webSettings.setDefaultTextEncodingName("utf-8");
		webSettings.setLoadWithOverviewMode(true);
		webSettings.setGeolocationEnabled(true);
		webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
		webview.setHorizontalScrollBarEnabled(false);
		webview.setVerticalScrollBarEnabled(false);
		webview.addJavascriptInterface(this, "cflbJavaCallBack");
		webview.setWebViewClient(new WebViewClient() {
			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				// 加载失败
				super.onReceivedError(view, errorCode, description, failingUrl);
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
			}
		});
		mWebView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				super.onProgressChanged(view, newProgress);
				mProgressBar.setVisibility(View.VISIBLE);
				mProgressBar.setProgress(newProgress);
				if (newProgress == 100) {
					mProgressBar.setVisibility(View.GONE);
				}
			}
		});
	}

	@Override
	public String getUserInfo() {
		return getStringValueForKey(ITEM_JSON);
	}

	@Override
	public void logOut() {
		setStringtForKey(USER_NAME, "");
		setStringtForKey(PASS_WORD, "");
	}

	@Override
	public void uploadImage(String type) {
		Intent i = new Intent(this, UploadImageActivity.class);
		i.putExtra("uploadType", type);
		startActivityForResult(i, 100);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == 10 && requestCode == 100) {
			// 调用JS方法
			String url = data.getStringExtra("retUrl");
			mWebView.loadUrl("javascript:getImgurl('" + url + "')");
		}
	}
}
