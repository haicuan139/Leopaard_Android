package com.leopaard.cn.domain;

import java.util.List;



/**
 * @ClassName: SysUser
 * @Description: 用户管理VO
 * @author panyf
 * @date 2014年6月18日 下午1:41:23
 */
public class SysUser implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String msg;
	private String su_id;
	private String su_loginname;
	private String su_name;
	private String su_pwd;
	private String su_sex;
	private String su_email;
	private String su_sp_id;
	private String su_so_orgId; //用户标识
	private String su_isLock;
	private String su_startdate;
	private String su_enddate;
	private String su_usertype;
	private String su_usertype_nameref;
	private String su_createdatetime;
	private String su_modifydatetime;
	private Integer su_version;
	private Integer su_errornum;
	private String su_lastlogindata;
	private Integer su_dr;
	private String su_ts;
	private String su_isBinding;
	private String su_ip;
	private String so_orgname;
	private String sp_pdfzd;
	private String su_phone;

	private String su_belongtype;// 所属经销商
	private String su_belongtype_nameref;
	
	private String su_belongpk; // 所属大区经理
	
	private String su_pay_pwd; // 支付密码
	
	private String su_belongpk_nameref; // 归属pk
	/**
	 * 扩展
	 */
	private String user_auth;//用户权限
	private String u_4s_id; //所属4s电
	private String u_dist_id; //所属经销商
	private String u_province; //所属省
	private String u_depart; //所属部门
	private String u_address; //用户详细地址
	private String u_zip_code; // 邮编
	private String u_code; // 员工编号
	private String u_position; // 职位
	private String u_eval; // 当前评定 
	private String u_tick_type; // 发票类型
	private String u_company_name ; // 公司名称
	private String t_name; //用户所在组名称
	
	private String ip_address; //IP地址
	
	private String total_point="0"; //总积分
	private String point_level="";//积分等级
	
	private List<AppAuthVO> authList;

	public String getSu_id() {
		return su_id;
	}

	public void setSu_id(String su_id) {
		this.su_id = su_id;
	}

	public String getSu_loginname() {
		return su_loginname;
	}

	public void setSu_loginname(String su_loginname) {
		this.su_loginname = su_loginname;
	}

	public String getSu_name() {
		return su_name;
	}

	public void setSu_name(String su_name) {
		this.su_name = su_name;
	}

	public String getSu_pwd() {
		return su_pwd;
	}

	public void setSu_pwd(String su_pwd) {
		this.su_pwd = su_pwd;
	}

	public String getSu_sex() {
		return su_sex;
	}

	public void setSu_sex(String su_sex) {
		this.su_sex = su_sex;
	}

	public String getSu_email() {
		return su_email;
	}

	public void setSu_email(String su_email) {
		this.su_email = su_email;
	}

	public String getSu_sp_id() {
		return su_sp_id;
	}

	public void setSu_sp_id(String su_sp_id) {
		this.su_sp_id = su_sp_id;
	}

	public String getSu_so_orgId() {
		return su_so_orgId;
	}

	public void setSu_so_orgId(String su_so_orgId) {
		this.su_so_orgId = su_so_orgId;
	}

	public String getSu_isLock() {
		return su_isLock;
	}

	public void setSu_isLock(String su_isLock) {
		this.su_isLock = su_isLock;
	}

	public String getSu_startdate() {
		return su_startdate;
	}

	public void setSu_startdate(String su_startdate) {
		this.su_startdate = su_startdate;
	}

	public String getSu_enddate() {
		return su_enddate;
	}

	public void setSu_enddate(String su_enddate) {
		this.su_enddate = su_enddate;
	}

	public String getSu_usertype() {
		return su_usertype;
	}

	public void setSu_usertype(String su_usertype) {
		this.su_usertype = su_usertype;
	}

	public String getSu_usertype_nameref() {
		return su_usertype_nameref;
	}

	public void setSu_usertype_nameref(String su_usertype_nameref) {
		this.su_usertype_nameref = su_usertype_nameref;
	}

	public String getSu_createdatetime() {
		return su_createdatetime;
	}

	public void setSu_createdatetime(String su_createdatetime) {
		this.su_createdatetime = su_createdatetime;
	}

	public String getSu_modifydatetime() {
		return su_modifydatetime;
	}

	public void setSu_modifydatetime(String su_modifydatetime) {
		this.su_modifydatetime = su_modifydatetime;
	}

	public Integer getSu_version() {
		return su_version;
	}

	public void setSu_version(Integer su_version) {
		this.su_version = su_version;
	}

	public Integer getSu_errornum() {
		return su_errornum;
	}

	public void setSu_errornum(Integer su_errornum) {
		this.su_errornum = su_errornum;
	}

	public String getSu_lastlogindata() {
		return su_lastlogindata;
	}

	public void setSu_lastlogindata(String su_lastlogindata) {
		this.su_lastlogindata = su_lastlogindata;
	}

	public Integer getSu_dr() {
		return su_dr;
	}

	public void setSu_dr(Integer su_dr) {
		this.su_dr = su_dr;
	}

	public String getSu_ts() {
		return su_ts;
	}

	public void setSu_ts(String su_ts) {
		this.su_ts = su_ts;
	}

	public String getSu_isBinding() {
		return su_isBinding;
	}

	public void setSu_isBinding(String su_isBinding) {
		this.su_isBinding = su_isBinding;
	}

	public String getSu_ip() {
		return su_ip;
	}

	public void setSu_ip(String su_ip) {
		this.su_ip = su_ip;
	}

	public String getSo_orgname() {
		return so_orgname;
	}

	public void setSo_orgname(String so_orgname) {
		this.so_orgname = so_orgname;
	}

	public String getSp_pdfzd() {
		return sp_pdfzd;
	}

	public void setSp_pdfzd(String sp_pdfzd) {
		this.sp_pdfzd = sp_pdfzd;
	}

	public String getSu_phone() {
		return su_phone;
	}

	public void setSu_phone(String su_phone) {
		this.su_phone = su_phone;
	}

	public String getSu_belongtype() {
		return su_belongtype;
	}

	public void setSu_belongtype(String su_belongtype) {
		this.su_belongtype = su_belongtype;
	}

	public String getSu_belongtype_nameref() {
		return su_belongtype_nameref;
	}

	public void setSu_belongtype_nameref(String su_belongtype_nameref) {
		this.su_belongtype_nameref = su_belongtype_nameref;
	}

	public String getSu_belongpk() {
		return su_belongpk;
	}

	public void setSu_belongpk(String su_belongpk) {
		this.su_belongpk = su_belongpk;
	}

	public String getSu_pay_pwd() {
		return su_pay_pwd;
	}

	public void setSu_pay_pwd(String su_pay_pwd) {
		this.su_pay_pwd = su_pay_pwd;
	}

	public String getSu_belongpk_nameref() {
		return su_belongpk_nameref;
	}

	public void setSu_belongpk_nameref(String su_belongpk_nameref) {
		this.su_belongpk_nameref = su_belongpk_nameref;
	}

	public String getUser_auth() {
		return user_auth;
	}

	public void setUser_auth(String user_auth) {
		this.user_auth = user_auth;
	}

	public String getU_4s_id() {
		return u_4s_id;
	}

	public void setU_4s_id(String u_4s_id) {
		this.u_4s_id = u_4s_id;
	}

	public String getU_dist_id() {
		return u_dist_id;
	}

	public void setU_dist_id(String u_dist_id) {
		this.u_dist_id = u_dist_id;
	}

	public String getU_province() {
		return u_province;
	}

	public void setU_province(String u_province) {
		this.u_province = u_province;
	}

	public String getU_depart() {
		return u_depart;
	}

	public void setU_depart(String u_depart) {
		this.u_depart = u_depart;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

	public String getU_zip_code() {
		return u_zip_code;
	}

	public void setU_zip_code(String u_zip_code) {
		this.u_zip_code = u_zip_code;
	}

	public String getU_code() {
		return u_code;
	}

	public void setU_code(String u_code) {
		this.u_code = u_code;
	}

	public String getU_position() {
		return u_position;
	}

	public void setU_position(String u_position) {
		this.u_position = u_position;
	}

	public String getU_eval() {
		return u_eval;
	}

	public void setU_eval(String u_eval) {
		this.u_eval = u_eval;
	}

	public String getU_tick_type() {
		return u_tick_type;
	}

	public void setU_tick_type(String u_tick_type) {
		this.u_tick_type = u_tick_type;
	}

	public String getU_company_name() {
		return u_company_name;
	}

	public void setU_company_name(String u_company_name) {
		this.u_company_name = u_company_name;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public String getTotal_point() {
		return total_point;
	}

	public void setTotal_point(String total_point) {
		this.total_point = total_point;
	}

	public String getPoint_level() {
		return point_level;
	}

	public void setPoint_level(String point_level) {
		this.point_level = point_level;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

	public List<AppAuthVO> getAuthList() {
		return authList;
	}

	public void setAuthList(List<AppAuthVO> authList) {
		this.authList = authList;
	}

//	public List<RowsData> getAuthList() {
//		return authList;
//	}
//
//	public void setAuthList(List<RowsData> authList) {
//		this.authList = authList;
//	}


	

}

