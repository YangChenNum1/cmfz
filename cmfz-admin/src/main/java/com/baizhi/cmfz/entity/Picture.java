package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by HP on 2018/7/5.
 */
public class Picture implements Serializable {
    private String picId;
    private String picPath;
    private Date picDate;
    private String picDescription;
    private String picStatus;

    public Picture() {
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Date getPicDate() {
        return picDate;
    }

    public void setPicDate(Date picDate) {
        this.picDate = picDate;
    }

    public String getPicDescription() {
        return picDescription;
    }

    public void setPicDescription(String picDescription) {
        this.picDescription = picDescription;
    }

    public String getPicStatus() {
        return picStatus;
    }

    public void setPicStatus(String picStatus) {
        this.picStatus = picStatus;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "picId='" + picId + '\'' +
                ", picPath='" + picPath + '\'' +
                ", picDate='" + picDate + '\'' +
                ", picDescription='" + picDescription + '\'' +
                ", picStatus='" + picStatus + '\'' +
                '}';
    }
}
