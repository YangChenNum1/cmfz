package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * Created by HP on 2018/7/6.
 */
public class Guru implements Serializable {
    private String guruId;
    private String guruName;
    private String guruPhoto;
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
