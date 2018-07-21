package com.pm.domain.business;

import java.sql.Date;

import com.pm.util.log.EntityAnnotation;

@SuppressWarnings("serial")
public class PersonnelMonthlySalary extends IdEntity {

   private String base_id; 
   
   @EntityAnnotation(item_name="入职时间" ,item_sort=5)
   private Date join_datetime ;

   @EntityAnnotation(item_name="调薪时间" ,item_sort=6)
   private Date change_time     ;
   

   @EntityAnnotation(item_name="原薪资" ,item_sort=7)
   private double old_salary ;
   

   @EntityAnnotation(item_name="调薪后薪资" ,item_sort=9)
   private double new_salary  ;       
   

   @EntityAnnotation(item_name="当月工资" ,item_sort=9)
   private double curr_salary  ;

   @EntityAnnotation(item_name="备注" ,item_sort=10)
   private String description      ;
   

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

	public Date getChange_time() {
		return change_time;
	}

	public void setChange_time(Date change_time) {
		this.change_time = change_time;
	}

	public double getOld_salary() {
		return old_salary;
	}

	public void setOld_salary(double old_salary) {
		this.old_salary = old_salary;
	}

	public double getNew_salary() {
		return new_salary;
	}

	public void setNew_salary(double new_salary) {
		this.new_salary = new_salary;
	}

	public double getCurr_salary() {
		return curr_salary;
	}

	public void setCurr_salary(double curr_salary) {
		this.curr_salary = curr_salary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	   
	   
	   
	   

}
