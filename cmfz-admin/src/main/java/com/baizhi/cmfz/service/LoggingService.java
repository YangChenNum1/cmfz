package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Logging;

import java.util.Map;

/**
 * Created by HP on 2018/7/9.
 */
public interface LoggingService {

    public int appendLogging(Logging logging);

    public Map<String,Object> queryLoggingByPage(Integer nowPage, Integer pageSize);

}
