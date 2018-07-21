package com.pm.domain.business;

import java.sql.Date;

import com.pm.util.log.EntityAnnotation;


@SuppressWarnings("serial")
public class PersonnelMonthlyOfficial extends IdEntity{
	

   private String base_id; 
   

   @EntityAnnotation(item_name="入职时间" ,item_sort=5)
   private Date join_datetime ;
   

   @EntityAnnotation(item_name="转正时间" ,item_sort=6)
   private Date confirmation_date;
   

   @EntityAnnotation(item_name="试用期工资" ,item_sort=7)
   private double tryout_salary ;
   

   @EntityAnnotation(item_name="正式工资" ,item_sort=8)
   private double official_salary;
   

   @EntityAnnotation(item_name="当月转正工资" ,item_sort=9)
   private double curr_salary  ;

   
   

	public String getBase_id() {
		return base_id;
	}


	public void setBase_id(String base_id) {
		this.base_id = base_id;
	}


	public Date getJoin_datetime() {
		return join_datetime;
	}


	public void setJoin_datetime(Date join_datetime) {
		this.join_datetime = join_datetime;
	}


	public Date getConfirmation_date() {
		return confirmation_date;
	}


	public void setConfirmation_date(Date confirmation_date) {
		this.confirmation_date = confirmation_date;
	}


	public double getTryout_salary() {
		return tryout_salary;
	}


	public void setTryout_salary(double tryout_salary) {
		this.tryout_salary = tryout_salary;
	}


	public double getOfficial_salary() {
		return official_salary;
	}


	public void setOfficial_salary(double official_salary) {
		this.official_salary = official_salary;
	}


	public double getCurr_salary() {
		return curr_salary;
	}


	public void setCurr_salary(double curr_salary) {
		this.curr_salary = curr_salary;
	}
	   
	   
	   

}
