package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

/**
 * Created by HP on 2018/7/5.
 */
public interface MenuDao {
    public List<Menu> selectAllMenus();
}
