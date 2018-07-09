package com.baizhi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import java.io.Serializable;

/**
 * Created by HP on 2018/7/6.
 */
@ExcelTarget("Guru")
public class Guru implements Serializable {
    @Excel(name = "guruId",height = 20,width = 30)
    private String guruId;
    @Excel(name = "guruName",height = 20,width = 30)
    private String guruName;
    @Excel(name = "guruPhoto",height = 20,width = 30)
    private String guruPhoto;
    @Excel(name = "guruSummer",height = 20,width = 30)
    private String guruSummer;

    public Guru() {
    }

    public String getGuruId() {
        return guruId;
    }

    public void setGuruId(String guruId) {
        this.guruId = guruId;
    }

    public String getGuruName() {
        return guruName;
    }

    public void setGuruName(String guruName) {
        this.guruName = guruName;
    }

    public String getGuruPhoto() {
        return guruPhoto;
    }

    public void setGuruPhoto(String guruPhoto) {
        this.guruPhoto = guruPhoto;
    }

    public String getGuruSummer() {
        return guruSummer;
    }

    public void setGuruSummer(String guruSummer) {
        this.guruSummer = guruSummer;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "guruId='" + guruId + '\'' +
                ", guruName='" + guruName + '\'' +
                ", guruPhoto='" + guruPhoto + '\'' +
                ", guruSummer='" + guruSummer + '\'' +
                '}';
    }
}
