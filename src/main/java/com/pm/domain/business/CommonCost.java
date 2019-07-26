package com.pm.domain.business;

import com.pm.util.log.EntityAnnotation;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 公共费用
 * @author Administrator
 */
public class CommonCost implements Serializable {


    private String id;

    //报销人员
    private String staff_id;

    //费用类别
    private String pay_item_id;



    @EntityAnnotation(item_name="月份",item_sort=5)
    private int use_month;

    @EntityAnnotation(item_name="支付月份",item_sort=5)
    private Date pay_date;


    @EntityAnnotation(item_name="金额"  ,item_sort=8,length=15)
    private double amount ;


    @EntityAnnotation(item_name="备注" ,item_sort=13,length=300)
    private String description;


    private int import_order;

    private Timestamp build_datetime;
    private String build_username;
    private String build_userid;
    private String verify_username;
    private String verify_userid;
    private Timestamp verify_datetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getPay_item_id() {
        return pay_item_id;
    }

    public void setPay_item_id(String pay_item_id) {
        this.pay_item_id = pay_item_id;
    }

    public int getUse_month() {
        return use_month;
    }

    public void setUse_month(int use_month) {
        this.use_month = use_month;
    }

    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
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

    public int getImport_order() {
        return import_order;
    }

    public void setImport_order(int import_order) {
        this.import_order = import_order;
    }

    public Timestamp getBuild_datetime() {
        return build_datetime;
    }

    public void setBuild_datetime(Timestamp build_datetime) {
        this.build_datetime = build_datetime;
    }

    public String getBuild_username() {
        return build_username;
    }

    public void setBuild_username(String build_username) {
        this.build_username = build_username;
    }

    public String getBuild_userid() {
        return build_userid;
    }

    public void setBuild_userid(String build_userid) {
        this.build_userid = build_userid;
    }

    public String getVerify_username() {
        return verify_username;
    }

    public void setVerify_username(String verify_username) {
        this.verify_username = verify_username;
    }

    public String getVerify_userid() {
        return verify_userid;
    }

    public void setVerify_userid(String verify_userid) {
        this.verify_userid = verify_userid;
    }

    public Timestamp getVerify_datetime() {
        return verify_datetime;
    }

    public void setVerify_datetime(Timestamp verify_datetime) {
        this.verify_datetime = verify_datetime;
    }
}
