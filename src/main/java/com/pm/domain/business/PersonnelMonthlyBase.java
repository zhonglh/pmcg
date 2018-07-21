package com.pm.domain.business;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@SuppressWarnings("serial")
public class PersonnelMonthlyBase extends IdEntity implements Serializable {
		
		
	//月份
	private String the_month;		

	//类型
	private String monthly_type;		
	
	private String dept_id;	
		
	private String project_id;	
		
	private String staff_id;
			

	private int import_order;
	private Timestamp build_datetime;
	private String build_userid;
	private String build_username;		
	private String verify_username;		
	private String verify_userid;		
	private Timestamp verify_datetime;
	
	
	
	public String getThe_month() {
		return the_month;
	}
	public void setThe_month(String the_month) {
		this.the_month = the_month;
	}
	public String getMonthly_type() {
		return monthly_type;
	}
	public void setMonthly_type(String monthly_type) {
		this.monthly_type = monthly_type;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public int getImport_order() {
		return import_order;
	}
	public void setImport_order(int import_order) {
		this.import_order = import_order;
	}
	public Timestamp getBuild_datetime() {
		return build_datetime;
	}
	public void setBuild_datetime(Timestamp build_datetime) {
		this.build_datetime = build_datetime;
	}
	public String getBuild_userid() {
		return build_userid;
	}
	public void setBuild_userid(String build_userid) {
		this.build_userid = build_userid;
	}
	public String getBuild_username() {
		return build_username;
	}
	public void setBuild_username(String build_username) {
		this.build_username = build_username;
	}
	public String getVerify_username() {
		return verify_username;
	}
	public void setVerify_username(String verify_username) {
		this.verify_username = verify_username;
	}
	public String getVerify_userid() {
		return verify_userid;
	}
	public void setVerify_userid(String verify_userid) {
		this.verify_userid = verify_userid;
	}
	public Timestamp getVerify_datetime() {
		return verify_datetime;
	}
	public void setVerify_datetime(Timestamp verify_datetime) {
		this.verify_datetime = verify_datetime;
	}
	
	
	
	
	
	
	
	
	
}