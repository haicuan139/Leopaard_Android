/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2015
 */

package com.leopaard.cn.domain;


public class CflbInformation implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//columns START111
	//	
	private String i_id;
	//	
	private String i_title;
	//资料类型 1- 汽车知识培训 2-公司内部资料培训 3-销售话术查询 4-销售资料5-新闻咨询 6-图片列表 7-消息
	private String i_type;
	private String i_type_nameref;
	//资料内容	
	private String i_content;
	//资料保存地址	
	private String i_save_path;
	//资料状态 0 - 未启用 1-已启用	
	private String i_status;
	private String i_status_nameref;
	//下载次数	
	private Integer i_down_num;
	//创建时间	
	private String i_create_time;
	//资料备注	
	private String i_remark;
	public String getI_id() {
		return i_id;
	}
	public void setI_id(String i_id) {
		this.i_id = i_id;
	}
	public String getI_title() {
		return i_title;
	}
	public void setI_title(String i_title) {
		this.i_title = i_title;
	}
	public String getI_type() {
		return i_type;
	}
	public void setI_type(String i_type) {
		this.i_type = i_type;
	}
	public String getI_type_nameref() {
		return i_type_nameref;
	}
	public void setI_type_nameref(String i_type_nameref) {
		this.i_type_nameref = i_type_nameref;
	}
	public String getI_content() {
		return i_content;
	}
	public void setI_content(String i_content) {
		this.i_content = i_content;
	}
	public String getI_save_path() {
		return i_save_path;
	}
	public void setI_save_path(String i_save_path) {
		this.i_save_path = i_save_path;
	}
	public String getI_status() {
		return i_status;
	}
	public void setI_status(String i_status) {
		this.i_status = i_status;
	}
	public String getI_status_nameref() {
		return i_status_nameref;
	}
	public void setI_status_nameref(String i_status_nameref) {
		this.i_status_nameref = i_status_nameref;
	}
	public Integer getI_down_num() {
		return i_down_num;
	}
	public void setI_down_num(Integer i_down_num) {
		this.i_down_num = i_down_num;
	}
	public String getI_create_time() {
		return i_create_time;
	}
	public void setI_create_time(String i_create_time) {
		this.i_create_time = i_create_time;
	}
	public String getI_remark() {
		return i_remark;
	}
	public void setI_remark(String i_remark) {
		this.i_remark = i_remark;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}

