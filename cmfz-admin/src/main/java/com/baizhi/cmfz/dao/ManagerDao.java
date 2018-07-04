package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * @Description ManagerDao接口
 * @Author  杨晨
 * @Time    2018-07-04 14:21:13
 */
public interface ManagerDao {
    /**
     * 查找管理员
     */
    public Manager selectManager(@Param("mgrName") String mgr_name);
    /**
     * 添加管理员
     */
    public int insertManager(Manager manager);
}
