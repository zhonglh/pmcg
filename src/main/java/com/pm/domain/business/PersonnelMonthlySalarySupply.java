package com.pm.domain.business;

import java.sql.Date;

import com.pm.util.log.EntityAnnotation;

@SuppressWarnings("serial")
public class PersonnelMonthlySalarySupply extends IdEntity{


	   private String base_id; 
	   

	   private String supply_type ;
	   

	   @EntityAnnotation(item_name="时间" ,item_sort=6)
	   private Date supply_time;
	   

	   @EntityAnnotation(item_name="补贴/扣除金额" ,item_sort=7)
	   private double amount ;

	   @EntityAnnotation(item_name="备注" ,item_sort=8)
	   private String description      ;

	public String getBase_id() {
		return base_id;
	}

	public void setBase_id(String base_id) {
		this.base_id = base_id;
	}

	public String getSupply_type() {
		return supply_type;
	}

	public void setSupply_type(String supply_type) {
		this.supply_type = supply_type;
	}

	public Date getSupply_time() {
		return supply_time;
	}

	public void setSupply_time(Date supply_time) {
		this.supply_time = supply_time;
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
	   
	   
	   
	   
}
