package com.pm.domain.business;

import java.util.Date;

/**
 * 人员职位晋升
 * @author zhonglihong
 * @date 2016年5月13日 下午5:51:10
 */
@SuppressWarnings("serial")
public class StaffPositions extends IdEntity {
	   
	private String staff_id ;  
	private Date positions_time    ;  
	private String level   ;    
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
	public Date getPositions_time() {
		return positions_time;
	}
	public void setPositions_time(Date positions_time) {
		this.positions_time = positions_time;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
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
