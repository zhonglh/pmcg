package com.pm.domain.business;

@SuppressWarnings("serial")
public class ShareToUser extends IdEntity implements java.io.Serializable{
	
	private String share_id;
	private String to_user_id;
	
	public String getShare_id() {
		return share_id;
	}
	public void setShare_id(String share_id) {
		this.share_id = share_id;
	}
	public String getTo_user_id() {
		return to_user_id;
	}
	public void setTo_user_id(String to_user_id) {
		this.to_user_id = to_user_id;
	}
	
	

}
