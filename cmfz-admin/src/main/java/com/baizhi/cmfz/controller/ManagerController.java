package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * Created by HP on 2018/7/4.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    public ManagerService managerService;

    @RequestMapping("/login")
    public String login(String mgrName,String mgrPwd,String enCode,HttpSession session,String isRememberUsername,HttpServletResponse response)throws Exception{
        if(isRememberUsername==null){
            isRememberUsername="false";
        }
        Manager manager=managerService.queryManager(mgrName,mgrPwd);

        System.out.println(isRememberUsername);
        if(manager!=null){
            if(enCode.equalsIgnoreCase((String) session.getAttribute("sessionCode"))){
                if (isRememberUsername.equals("true")){
                    Cookie c1=new Cookie("mgrName",URLEncoder.encode(mgrName,"UTF-8"));
                    Cookie c2=new Cookie("mgrPwd",URLEncoder.encode(mgrPwd,"UTF-8"));
                    response.addCookie(c1);
                    response.addCookie(c2);
                }
                session.setAttribute("manager", manager);
                return "redirect:/main.jsp";
            }else{
                return "login";
            }
        }else{
            return "login";
        }
    }

    @RequestMapping("register")
    public String register(Manager manager){
        String mgr_id=getUUID(UUID.randomUUID());
        System.out.println(manager.getMgrName());
        manager.setMgrId(mgr_id);
        int num=managerService.addManager(manager);
       if(num>0){
           return "login";
       }else{
           return  "register";
       }
    }

    @RequestMapping("toLogin")
    public String tologin(HttpServletRequest request, ModelMap map)throws Exception{
        Cookie []cookies=request.getCookies();
        String mgrName="";
        String mgrPwd="";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("mgrName")){
                mgrName= URLDecoder.decode(cookie.getValue(),"utf-8");
            }
            if (cookie.getName().equals("mgrPwd")){
                mgrPwd= URLDecoder.decode(cookie.getValue(),"utf-8");
            }
        }
        map.addAttribute("mgrName",mgrName);
        map.addAttribute("mgrPwd",mgrPwd);
        return "login";
    }

    @RequestMapping("checkMgrName")
    public void checkMgrName(String mgrName,HttpServletResponse response) throws IOException {
        String message="";
        Manager manager=managerService.queryCheckManager(mgrName);
        if(manager!=null){
            message="invalidate ID";
        }else{
            message="usable ID";
        }
        PrintWriter out=response.getWriter();
        out.println(message);
        out.flush();
    }

    public String getUUID(UUID uuid){
        return uuid.toString().replace("-", "");
    }
}
