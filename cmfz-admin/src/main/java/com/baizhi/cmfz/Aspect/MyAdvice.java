package com.baizhi.cmfz.Aspect;

import com.baizhi.cmfz.entity.Logging;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.LoggingService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.UUID;


/**
 * Created by HP on 2018/7/9.
 */
@Aspect
public class MyAdvice {

    @Autowired
    private LoggingService loggingService;

    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*.modify*(..)) || execution(* com.baizhi.cmfz.service.impl.*.remove*(..)) || execution(* com.baizhi.cmfz.service.impl.*.add*(..))")
    public void pc(){}

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) throws Exception{  // 连接点
        System.out.println("----------------------star0t-------------------------");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Manager manager = (Manager) session.getAttribute("manager");
        //获取添加用户
        String user=manager.getMgrName();
        Logging logging=new Logging();
        logging.setUser(user);
        //添加日志Id
        String id=UUID.randomUUID().toString().replace("-", "");
        logging.setId(id);
        Object[] args = pjp.getArgs();
        System.out.println("----------------------start1-------------------------");
        //操作详细信息
        String argsToString="";
        for (Object arg : args) {
            argsToString+=arg.toString();
        }
        logging.setMessage(argsToString);
        //操作动作
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        String action=method.getName();
        logging.setAction(action);
        String clazz=pjp.getTarget().getClass().getName();
        int index=clazz.indexOf("ServiceImpl");
        String resource=clazz.substring(0,index);
        System.out.println("----------------------start2-------------------------");
        logging.setResource(resource);
        Object obj = null;
        String result=null;
        try {
            obj = pjp.proceed();
            result="success";
        } catch (Throwable throwable) {
            result="fail";
            throwable.printStackTrace();
        }
        logging.setResult(result);
        loggingService.appendLogging(logging);
        System.out.println("D:\\Users\\HP\\cmfz\\cmfz-admin\\src\\main\\java\\com\\baizhi\\cmfz\\Aspect");
        return obj;
    }
}
