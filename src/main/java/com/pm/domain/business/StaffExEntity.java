package com.pm.domain.business;

import com.pm.util.log.EntityAnnotation;

public class StaffExEntity extends IdEntity {
	
	private String salary_model;
	@EntityAnnotation(item_name="垫资金额", item_sort=1,length=30)
	private double guarantee_amount; 
	private String parent_id;
	@EntityAnnotation(item_name="其它支出金额", item_sort=1,length=30)
	private String other_expenditures;
	
	
	
	

}
