package com.baizhi.cmfz.entity;

/**
 * Created by HP on 2018/7/9.
 */
public class Statistics {
    private String name;
    private Integer value;

    public Statistics() {
    }

    public Statistics(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
