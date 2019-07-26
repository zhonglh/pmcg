package com.pm.domain.system;


import com.pm.domain.business.IdEntity;

/**
 * 用户管理的部门设置
 */
public class UserManageDept  extends IdEntity {

    private String user_id;
    private String dept_id;


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }
}
