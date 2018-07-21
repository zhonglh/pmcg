package com.pm.domain.business;

import java.sql.Date;

@SuppressWarnings("serial")
public class StaffChilds extends IdEntity {
	
	private String staff_id;
	private String child_id;
	private int level_val ;
	private Date start_date;

	private Date end_date;

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public String getChild_id() {
		return child_id;
	}

	public void setChild_id(String child_id) {
		this.child_id = child_id;
	}

	public int getLevel_val() {
		return level_val;
	}

	public void setLevel_val(int level_val) {
		this.level_val = level_val;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	

}
