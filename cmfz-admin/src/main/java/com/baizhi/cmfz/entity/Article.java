package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by HP on 2018/7/8.
 */
public class Article implements Serializable {
    private String artId;
    private String artName;
    private String guruId;
    private String artDescrip;
    private Date artDate;

    public Article() {
    }

    public String getArtId() {
        return artId;
    }

    public void setArtId(String artId) {
        this.artId = artId;
    }

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getArtDescrip() {
        return artDescrip;
    }

    public void setArtDescrip(String artDescrip) {
        this.artDescrip = artDescrip;
    }

    public Date getArtDate() {
        return artDate;
    }

    public void setArtDate(Date artDate) {
        this.artDate = artDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "artId='" + artId + '\'' +
                ", artName='" + artName + '\'' +
                ", guruId='" + guruId + '\'' +
                ", artDescrip='" + artDescrip + '\'' +
                ", artDate=" + artDate +
                '}';
    }
}
