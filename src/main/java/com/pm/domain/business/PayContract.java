package com.pm.domain.business;

import com.pm.util.log.EntityAnnotation;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 付款合同
 * @author Administrator
 */
public class PayContract implements Serializable {

    private String id;


    @EntityAnnotation(item_name="合同编号" ,item_sort=1,length=50)
    private String contract_no;


    @EntityAnnotation(item_name="公司名称" ,item_sort=2,length=100)
    private String company_name;

    @EntityAnnotation(item_name="执行合同" ,item_sort=3,length=300)
    private String exec_contract;

    @EntityAnnotation(item_name="金额" ,item_sort=4,length=12)
    private double amount ;

    @EntityAnnotation(item_name="合同签订日期" ,item_sort=5,length=10)
    private Date signing_date ;


    @EntityAnnotation(item_name="合同有效日期1" ,item_sort=6,length=10)
    private Date validity_date1;

    @EntityAnnotation(item_name="合同有效日期2" ,item_sort=7,length=10)
    private Date validity_date2;

    private String manager_userid;
    private String project_id;


    @EntityAnnotation(item_name="提交日期" ,item_sort=10,length=10)
    private Date submit_date;


    @EntityAnnotation(item_name="客户联系人" ,item_sort=11,length=100)
    private String client_linkman;


    @EntityAnnotation(item_name="邮箱/电话" ,item_sort=12,length=500)
    private String email_phone;



    @EntityAnnotation(item_name="合同份数" ,item_sort=13,length=5)
    private int contract_number;



    @EntityAnnotation(item_name="备注" ,item_sort=14,length=300)
    private String description;

    private Timestamp build_datetime;
    private String build_username;
    private String build_userid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContract_no() {
        return contract_no;
    }

    public void setContract_no(String contract_no) {
        this.contract_no = contract_no;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getExec_contract() {
        return exec_contract;
    }

    public void setExec_contract(String exec_contract) {
        this.exec_contract = exec_contract;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getSigning_date() {
        return signing_date;
    }

    public void setSigning_date(Date signing_date) {
        this.signing_date = signing_date;
    }

    public Date getValidity_date1() {
        return validity_date1;
    }

    public void setValidity_date1(Date validity_date1) {
        this.validity_date1 = validity_date1;
    }

    public Date getValidity_date2() {
        return validity_date2;
    }

    public void setValidity_date2(Date validity_date2) {
        this.validity_date2 = validity_date2;
    }

    public String getManager_userid() {
        return manager_userid;
    }

    public void setManager_userid(String manager_userid) {
        this.manager_userid = manager_userid;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public Date getSubmit_date() {
        return submit_date;
    }

    public void setSubmit_date(Date submit_date) {
        this.submit_date = submit_date;
    }

    public String getClient_linkman() {
        return client_linkman;
    }

    public void setClient_linkman(String client_linkman) {
        this.client_linkman = client_linkman;
    }

    public String getEmail_phone() {
        return email_phone;
    }

    public void setEmail_phone(String email_phone) {
        this.email_phone = email_phone;
    }

    public int getContract_number() {
        return contract_number;
    }

    public void setContract_number(int contract_number) {
        this.contract_number = contract_number;
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
}
