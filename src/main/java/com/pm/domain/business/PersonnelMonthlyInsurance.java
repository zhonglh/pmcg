package com.pm.domain.business;

import com.pm.util.log.EntityAnnotation;

@SuppressWarnings("serial")
public class PersonnelMonthlyInsurance extends IdEntity{
	
	


   private String base_id;    

   private String insurance_grade_id;    
   
   @EntityAnnotation(item_name="社保缴纳单位" ,item_sort=14)
   private String securty_unit;

   //@EntityAnnotation(item_name="社保说明" ,item_sort=14)
   private String social_security ;

   //@EntityAnnotation(item_name="参保城市" ,item_sort=15)
   private String insured_city ;

   
	   
	/**
	@EntityAnnotation(item_name="养老个人", item_sort=6)
	private double endowment_insurance_bypersonal;
	
	@EntityAnnotation(item_name="养老公司", item_sort=7)
	private double endowment_insurance_bycompany;
	
	
	@EntityAnnotation(item_name="医疗个人", item_sort=8)
	private double medical_insurance_bypersonal;
	
	@EntityAnnotation(item_name="医疗公司", item_sort=9)
	private double medical_insurance_bycompany;
	
	@EntityAnnotation(item_name="失业个人", item_sort=10)
	private double losejob_insurance_bypersonal;
	
	@EntityAnnotation(item_name="失业公司", item_sort=11)
	private double losejob_insurance_bycompany;
	
	@EntityAnnotation(item_name="工伤单位", item_sort=12)
	private double jobharm_insurance_bycompany;
	
	@EntityAnnotation(item_name="生育单位", item_sort=13)
	private double maternity_insurance_bycompany; 	   
	   
	
	@EntityAnnotation(item_name="社保档次", item_sort=5)
	private String insurance_grade_name;
	
	*/
	   
	
	public String getBase_id() {
		return base_id;
	}
	
	public void setBase_id(String base_id) {
		this.base_id = base_id;
	}
	
	public String getInsurance_grade_id() {
		return insurance_grade_id;
	}
	
	public void setInsurance_grade_id(String insurance_grade_id) {
		this.insurance_grade_id = insurance_grade_id;
	}
	
	public String getSecurty_unit() {
		return securty_unit;
	}
	
	public void setSecurty_unit(String securty_unit) {
		this.securty_unit = securty_unit;
	}
	
	public String getSocial_security() {
		return social_security;
	}
	
	public void setSocial_security(String social_security) {
		this.social_security = social_security;
	}
	
	public String getInsured_city() {
		return insured_city;
	}
	
	public void setInsured_city(String insured_city) {
		this.insured_city = insured_city;
	}
	   
	   

}
