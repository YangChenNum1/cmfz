package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * @Description 管理员的实体类
 * @Author  杨晨
 * @Time    2018-07-04 14:17:30
 */
public class Manager implements Serializable{

    private String mgrId;
    private String mgrName;
    private String mgrPwd;
    private String mgrSalt;
    private String mgrStatus;

    public Manager() {
    }

    public Manager(String mgrId, String mgrName, String mgrPwd, String mgrSalt, String mgrStatus) {
        this.mgrId = mgrId;
        this.mgrName = mgrName;
        this.mgrPwd = mgrPwd;
        this.mgrSalt = mgrSalt;
        this.mgrStatus = mgrStatus;
    }

    public String getMgrId() {
        return mgrId;
    }

    public void setMgrId(String mgrId) {
        this.mgrId = mgrId;
    }

    public String getMgrName() {
        return mgrName;
    }

    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }

    public String getMgrPwd() {
        return mgrPwd;
    }

    public void setMgrPwd(String mgrPwd) {
        this.mgrPwd = mgrPwd;
    }

    public String getMgrSalt() {
        return mgrSalt;
    }

    public void setMgrSalt(String mgrSalt) {
        this.mgrSalt = mgrSalt;
    }

    public String getMgrStatus() {
        return mgrStatus;
    }

    public void setMgrStatus(String mgrStatus) {
        this.mgrStatus = mgrStatus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mgrId='" + mgrId + '\'' +
                ", mgrName='" + mgrName + '\'' +
                ", mgrPwd='" + mgrPwd + '\'' +
                ", mgrSalt='" + mgrSalt + '\'' +
                ", mgrStatus='" + mgrStatus + '\'' +
                '}';
    }
}
