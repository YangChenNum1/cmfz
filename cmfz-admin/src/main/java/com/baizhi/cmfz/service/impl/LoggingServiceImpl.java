package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.LoggingDao;
import com.baizhi.cmfz.entity.Logging;
import com.baizhi.cmfz.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HP on 2018/7/9.
 */
@Service
@Transactional
public class LoggingServiceImpl implements LoggingService {

    @Autowired
    private LoggingDao loggingDao;

    @Override
    public int appendLogging(Logging logging) {
        return loggingDao.insertLogging(logging);
    }

    @Override
    public Map<String, Object> queryLoggingByPage(Integer nowPage, Integer pageSize) {
        List<Logging> loggings = loggingDao.findLoggingByPage((nowPage - 1) * pageSize, pageSize);
        int count=loggingDao.selectCount();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total", count);
        map.put("rows", loggings);
        return map;
    }
}
