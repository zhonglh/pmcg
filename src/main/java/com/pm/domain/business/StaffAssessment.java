package com.pm.domain.business;

import java.util.Date;

/**
 * 人员绩效考核
 * @author zhonglihong
 * @date 2016年5月13日 下午5:51:10
 */
@SuppressWarnings("serial")
public class StaffAssessment extends IdEntity {
	   
	private String staff_id ;  
	private Date assessment_time    ;  
	private double attendance_rate   ;    
	private int score;
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
	public Date getAssessment_time() {
		return assessment_time;
	}
	public void setAssessment_time(Date assessment_time) {
		this.assessment_time = assessment_time;
	}
	public double getAttendance_rate() {
		return attendance_rate;
	}
	public void setAttendance_rate(double attendance_rate) {
		this.attendance_rate = attendance_rate;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
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
