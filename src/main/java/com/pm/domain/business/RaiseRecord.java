package com.pm.domain.business;

import java.util.Date;

/**
 * 加薪记录
 * @author zhonglihong
 * @date 2016年5月13日 下午4:22:25
 */
@SuppressWarnings("serial")
public class RaiseRecord extends IdEntity {
	   
	private String staff_id ;  
	private Date raise_time    ;  
	private double amount      ;    
	private String description ;    
	private Date build_datetime ; 
	private String build_userid ;   
	private String build_username  ;
	
	
	
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public Date getRaise_time() {
		return raise_time;
	}
	public void setRaise_time(Date raise_time) {
		this.raise_time = raise_time;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getBuild_datetime() {
		return build_datetime;
	}
	public void setBuild_datetime(Date build_datetime) {
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


}
