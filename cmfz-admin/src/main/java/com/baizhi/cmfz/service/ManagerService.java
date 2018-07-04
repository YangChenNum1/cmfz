package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;

/**
 * @Description ManagerService接口
 * @Author  杨晨
 * @Time    2018-07-04 14:45:12
 */
public interface ManagerService {
    /**
     * 查找Mnanger
     * @param mgrName
     */
    public Manager queryManager(String mgrName,String mgrPwd);
    /**
     * 插入Manager
     *@param manager
     */
    public int addManager(Manager manager);
    /**
     * 查找Mnanger,校验
     */
    public Manager queryCheckManager(String mgrName);
}
