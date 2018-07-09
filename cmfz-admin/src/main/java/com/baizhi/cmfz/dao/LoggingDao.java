package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Logging;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HP on 2018/7/9.
 */
public interface LoggingDao {
    /**
     * 插入日志信息
     * @param logging
     * @return
     */
    public int insertLogging(Logging logging);
    /**
     * 分页查询日志信息
     * @param begin
     * @param pageSize
     * @return
     */
    public List<Logging> findLoggingByPage(@Param("begin") Integer begin, @Param("pageSize") Integer pageSize);
    /**
     *查询条数
     * @return
     */
    public int selectCount();

}
