package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.util.CreateValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by HP on 2018/7/4.
 */
@Controller
@RequestMapping("vcode")
public class CreateVcodeController {
    @RequestMapping("getcode")
    public void create(HttpSession session, HttpServletResponse response) throws Exception{
        //创建工具对象，生成验证码
        CreateValidateCode vcode=new CreateValidateCode(100, 30, 4, 10);

        //保存session作用域
        session.setAttribute("sessionCode", vcode.getCode());

        //使用response获得向客户端的流对象，输出
        vcode.write(response.getOutputStream());
    }
}
