package com.leopaard.cn.domain;

public class DomainBaseObj {

	private String code;
	private String msg;
	private boolean success;
	private SysUser val;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public SysUser getVal() {
		return val;
	}
	public void setVal(SysUser val) {
		this.val = val;
	}
}
