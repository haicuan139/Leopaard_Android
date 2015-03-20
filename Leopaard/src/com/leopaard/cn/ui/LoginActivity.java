package com.leopaard.cn.ui;

import java.util.List;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.leopaard.cn.BaseActivity;
import com.leopaard.cn.R;
import com.leopaard.cn.ScrollMainActivity;
import com.leopaard.cn.domain.AppAuthVO;
import com.leopaard.cn.domain.DomainBaseObj;

public class LoginActivity extends BaseActivity {

	private EditText userEdit;
	private EditText passEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		userEdit = (EditText) findViewById(R.id.username);
		passEdit = (EditText) findViewById(R.id.password);
//		String user = getStringValueForKey(USER_NAME);
//		String pass = getStringValueForKey(PASS_WORD);
//		if(!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)){
//			userEdit.setText(user);
//			passEdit.setText(pass);
//			login(user, pass);
//		}
	}

	private void login(String user, String pass) {
		AjaxParams params = new AjaxParams();
		params.put("u_name", user);
		params.put("u_pwd", pass);
		new FinalHttp().post(
				"http://114.215.84.87:8080/cflb/cflb/app_user/doLogin.htm",
				params, new AjaxCallBack<String>() {
					private ProgressDialog dialog;
					@Override
					public void onSuccess(String t) {
						if (!TextUtils.isEmpty(t)) {
							DomainBaseObj user = new Gson().fromJson(t,
									DomainBaseObj.class);
							if (user.getCode().equals("00")) {
								List<AppAuthVO> datas = user.getVal()
										.getAuthList();
								if (datas != null && datas.size() > 0) {
									setStringtForKey(ITEM_JSON,
											new Gson().toJson(user.getVal()));
									startActivity(new Intent(
											LoginActivity.this,
											ScrollMainActivity.class));
									//保存用户名密码
									setStringtForKey(USER_NAME, userEdit.getText().toString());
									setStringtForKey(PASS_WORD , passEdit.getText().toString());
									//保存用户id
									String uid = user.getVal().getSu_id();
									setStringtForKey("uid", uid);
									finish();
								} else {
									Toast.makeText(getApplicationContext(),
											"用户没有被赋予任何权限", Toast.LENGTH_SHORT)
											.show();
								}
							} else {
								Toast.makeText(getApplicationContext(), "登录失败",
										Toast.LENGTH_SHORT).show();
							}
						} else {
							Toast.makeText(getApplicationContext(), "登录信息异常",
									Toast.LENGTH_SHORT).show();
						}
						dialog.dismiss();
						super.onSuccess(t);
					}

					@Override
					public void onFailure(Throwable t, int errorNo,
							String strMsg) {
						Log.e("RET", strMsg, t);
						super.onFailure(t, errorNo, strMsg);
						dialog.dismiss();
					}
					@Override
					public void onStart() {
						super.onStart();
						dialog = ProgressDialog.show(LoginActivity.this, "提示", "加载中..");
					}
				});

	}

	public void onClick(View view) {
		String username = userEdit.getText().toString();
		String passString = passEdit.getText().toString();
		if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(passString))
			login(username, passString);

		}
}
