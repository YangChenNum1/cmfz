package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by HP on 2018/7/9.
 */
@Controller
@RequestMapping("log")
public class LoggingController {

    @Autowired
    private LoggingService loggingService;

    @RequestMapping("/findByPage")
    @ResponseBody
    public Map<String,Object> findByPage(@RequestParam("page") Integer nowPage, @RequestParam("rows") Integer pageSize){
        return loggingService.queryLoggingByPage(nowPage,pageSize);
    }
}
