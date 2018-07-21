package com.pm.domain.business;

import java.util.Date;

import com.pm.util.log.EntityAnnotation;

/**
 * 潜在客户
 * @author zhonglihong
 * @date 2016年5月13日 上午10:26:51
 */
@SuppressWarnings("serial")
public class PotentialClient extends IdEntity {

	@EntityAnnotation(item_name="客户编号" ,item_sort=1, length=30)
	private String client_no ;          
	@EntityAnnotation(item_name="客户名称",item_sort=2, length=100)
	private String client_name;      

	@EntityAnnotation(item_name="行业",item_sort=3, length=50) 
	private String trade;      
	@EntityAnnotation(item_name="客户地址",item_sort=4, length=250)  
	private String addr ;     
         
	@EntityAnnotation(item_name="联系人",item_sort=5, length=50) 
	private String linkman ;          
	@EntityAnnotation(item_name="手机",item_sort=6, length=20)   
	private String mobile_phone;     
	@EntityAnnotation(item_name="座机" ,item_sort=7, length=20)        
	private String tel ;         
	@EntityAnnotation(item_name="电子邮件" ,item_sort=8, length=60)               
	private String email ;        
	@EntityAnnotation(item_name="QQ号码" ,item_sort=9, length=20)              
	private String qq ;  

	@EntityAnnotation(item_name="技术方向",item_sort=10, length=25)     
	private String technology_direction;
	@EntityAnnotation(item_name="服务类型",item_sort=11, length=25) 
	private String service_type;        
		
	
	private String project_cycle;   

	@EntityAnnotation(item_name="客户需求",item_sort=13, length=500) 
	private String project_requirement ;
	
	private String client_worth  ;   

	@EntityAnnotation(item_name="信息来源" ,item_sort=15, length=25)   
	private String info_source ;     

	private String status;
	private String sale_userid ;   
	
	@EntityAnnotation(item_name="备注" ,item_sort=17, length=150)   
	private String description ;        
	
	private Date build_datetime ;     
	private String build_userid ;       
	private String build_username ;
	
	
	//////////////////////////////////
	//////////////扩展/////////////////
	/////////////////////////////////
	

	@EntityAnnotation(item_name="项目周期",item_sort=12, length=50) 
	private String project_cycle_name;
	

	@EntityAnnotation(item_name="客户价值",item_sort=14, length=50) 
	private String client_worth_name;  
	

	@EntityAnnotation(item_name="客户状态",item_sort=16, length=50) 
	private String status_name;
	
	
	public String getClient_no() {
		return client_no;
	}
	public void setClient_no(String client_no) {
		this.client_no = client_no;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getMobile_phone() {
		return mobile_phone;
	}
	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getTechnology_direction() {
		return technology_direction;
	}
	public void setTechnology_direction(String technology_direction) {
		this.technology_direction = technology_direction;
	}
	public String getService_type() {
		return service_type;
	}
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}
	public String getProject_cycle() {
		return project_cycle;
	}
	public void setProject_cycle(String project_cycle) {
		this.project_cycle = project_cycle;
	}
	public String getProject_requirement() {
		return project_requirement;
	}
	public void setProject_requirement(String project_requirement) {
		this.project_requirement = project_requirement;
	}
	public String getClient_worth() {
		return client_worth;
	}
	public void setClient_worth(String client_worth) {
		this.client_worth = client_worth;
	}
	public String getInfo_source() {
		return info_source;
	}
	public void setInfo_source(String info_source) {
		this.info_source = info_source;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSale_userid() {
		return sale_userid;
	}
	public void setSale_userid(String sale_userid) {
		this.sale_userid = sale_userid;
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
