package com.pm.domain.business;

import com.pm.util.log.EntityAnnotation;

@SuppressWarnings("serial")
public class PersonnelMonthlyReserveFund extends IdEntity{
	
	



   private String insurance_grade_id;
   

   @EntityAnnotation(item_name="备注" ,item_sort=8)
   private String description      ;
	   

	public String getInsurance_grade_id() {
		return insurance_grade_id;
	}
	
	public void setInsurance_grade_id(String insurance_grade_id) {
		this.insurance_grade_id = insurance_grade_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
