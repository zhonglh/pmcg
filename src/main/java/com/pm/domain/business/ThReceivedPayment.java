package com.pm.domain.business;


import java.io.Serializable;
import java.util.Date;

/**
 * 收款历史信息实体类
 * 
 * @author zhonglh
 * @date 2017-9-24 21:59:00
 */
public class ThReceivedPayment extends ReceivedPayment implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;

	private Date hisDate;


	private String hisUserId;


	private String hisUserName;



	private String hisOperationType;



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Date getHisDate() {
		return hisDate;
	}



	public void setHisDate(Date hisDate) {
		this.hisDate = hisDate;
	}



	public String getHisUserId() {
		return hisUserId;
	}



	public void setHisUserId(String hisUserId) {
		this.hisUserId = hisUserId;
	}



	public String getHisUserName() {
		return hisUserName;
	}



	public void setHisUserName(String hisUserName) {
		this.hisUserName = hisUserName;
	}



	public String getHisOperationType() {
		return hisOperationType;
	}



	public void setHisOperationType(String hisOperationType) {
		this.hisOperationType = hisOperationType;
	}



	
}