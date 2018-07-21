package com.pm.domain.business;

import java.io.Serializable;

/**
 * 月度结算单明细历史信息实体类
 * 
 * @author zhonglh
 * @date 2017-9-24 21:59:01
 */
public class ThMonthlyStatementDetail extends MonthlyStatementDetail implements Serializable {
	private static final long serialVersionUID = 1L;


	private String id;


	private String monthlyStatementHisId;




	private String monthlyStatementDetailId;




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getMonthlyStatementHisId() {
		return monthlyStatementHisId;
	}




	public void setMonthlyStatementHisId(String monthlyStatementHisId) {
		this.monthlyStatementHisId = monthlyStatementHisId;
	}




	public String getMonthlyStatementDetailId() {
		return monthlyStatementDetailId;
	}




	public void setMonthlyStatementDetailId(String monthlyStatementDetailId) {
		this.monthlyStatementDetailId = monthlyStatementDetailId;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}