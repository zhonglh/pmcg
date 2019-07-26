package com.pm.domain.business;

import com.pm.util.log.EntityAnnotation;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Administrator
 */
public class ProjectExpendPay extends IdEntity implements Serializable {


    private String project_expend_id;

    @EntityAnnotation(item_name="收到的发票号"  ,item_sort=30,length=200)
    private String invoiceno;

    @EntityAnnotation(item_name="实际支付日期", item_sort=40,length=10)
    private Timestamp pay_date;

    @EntityAnnotation(item_name="实付金额" ,item_sort=50,length=12)
    private double pay_amount;



    @EntityAnnotation(item_name="备注" ,item_sort=60,length=150)
    private String description;


    private Timestamp build_datetime;
    private String build_username;
    private String build_userid;
    private String verify_username;
    private String verify_userid;
    private Timestamp verify_datetime;


    ///////////////////////////////////



    /*@EntityAnnotation(item_name="项目名称" ,item_sort=10)
    private String project_name;

    @EntityAnnotation(item_name="项目编号",item_sort=20)
    private String project_no;


    @EntityAnnotation(item_name="应付金额" ,item_sort=23)
    private double amount;

    @EntityAnnotation(item_name="累计已付金额" ,item_sort=26)
    private double pay_amount_total;*/


    public String getProject_expend_id() {
        return project_expend_id;
    }

    public void setProject_expend_id(String project_expend_id) {
        this.project_expend_id = project_expend_id;
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno;
    }

    public Timestamp getPay_date() {
        return pay_date;
    }

    public void setPay_date(Timestamp pay_date) {
        this.pay_date = pay_date;
    }

    public double getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(double pay_amount) {
        this.pay_amount = pay_amount;
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
