package com.pm.domain.business;



import java.util.Date;

/**
 * 月度结算单历史信息实体类
 * 
 * @author zhonglh
 * @date 2017-9-24 21:59:01
 */
public class ThMonthlyStatement extends MonthlyStatement {
	private static final long serialVersionUID = 1L;

	private String id;


	private Date hisDate;




	private String hisUserId;



	private String hisUserName;




	private String hisOperationType;




	/** 
	 * 历史时间
	 * @return the hisDate
	 */
	public Date getHisDate() {
		return hisDate;
	}
	
	/** 
	 * 历史时间
	 */
	public void setHisDate(Date hisDate) {
		this.hisDate = hisDate;
	}
	/** 
	 * 历史操作人ID
	 * @return the hisUserId
	 */
	public String getHisUserId() {
		return hisUserId;
	}
	
	/** 
	 * 历史操作人ID
	 */
	public void setHisUserId(String hisUserId) {
		this.hisUserId = hisUserId;
	}
	/** 
	 * 历史操作人姓名
	 * @return the hisUserName
	 */
	public String getHisUserName() {
		return hisUserName;
	}
	
	/** 
	 * 历史操作人姓名
	 */
	public void setHisUserName(String hisUserName) {
		this.hisUserName = hisUserName;
	}
	/** 
	 * 历史操作类型
	 * @return the hisOperationType
	 */
	public String getHisOperationType() {
		return hisOperationType;
	}
	
	/** 
	 * 历史操作类型
	 */
	public void setHisOperationType(String hisOperationType) {
		this.hisOperationType = hisOperationType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}