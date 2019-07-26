package com.pm.domain.business;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Administrator
 */
public class DeptStaff implements Serializable {


    private String dept_staff_id;
    private String dept_id;
    private String staff_id;
    private Date join_dept_datetime;
    private Date leave_dept_datetime;
    private String description;

    private Timestamp build_datetime;
    private String build_userid;
    private String build_username;
    private String delete_flag;
    private Timestamp delete_datetime;
    private String delete_userid;
    private String delete_username;

    public String getDept_staff_id() {
        return dept_staff_id;
    }

    public void setDept_staff_id(String dept_staff_id) {
        this.dept_staff_id = dept_staff_id;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public Date getJoin_dept_datetime() {
        return join_dept_datetime;
    }

    public void setJoin_dept_datetime(Date join_dept_datetime) {
        this.join_dept_datetime = join_dept_datetime;
    }

    public Date getLeave_dept_datetime() {
        return leave_dept_datetime;
    }

    public void setLeave_dept_datetime(Date leave_dept_datetime) {
        this.leave_dept_datetime = leave_dept_datetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getBuild_datetime() {
        return build_datetime;
    }

    public void setBuild_datetime(Timestamp build_datetime) {
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

    public String getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(String delete_flag) {
        this.delete_flag = delete_flag;
    }

    public Timestamp getDelete_datetime() {
        return delete_datetime;
    }

    public void setDelete_datetime(Timestamp delete_datetime) {
        this.delete_datetime = delete_datetime;
    }

    public String getDelete_userid() {
        return delete_userid;
    }

    public void setDelete_userid(String delete_userid) {
        this.delete_userid = delete_userid;
    }

    public String getDelete_username() {
        return delete_username;
    }

    public void setDelete_username(String delete_username) {
        this.delete_username = delete_username;
    }
}
