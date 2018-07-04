package com.baizhi.cmfz.test;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by HP on 2018/7/4.
 */
public class Test1 {

    @Test
    public void test1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("/applicationContext.xml");

        ManagerDao md=(ManagerDao) ctx.getBean("managerDao");

        Manager manager=new Manager();

        manager.setMgrId("123");
        manager.setMgrName("zs");
        manager.setMgrPwd("123456");
        manager.setMgrSalt("yuiszs");

        int result=md.insertManager(manager);

        System.out.println(result);
    }

    @Test
    public void test2(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("/applicationContext.xml");

        ManagerDao md=(ManagerDao) ctx.getBean("managerDao");

        Manager manager=md.selectManager("zs");

        System.out.println(manager);
    }

    @Test
    public void test3(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("/applicationContext.xml");
        ManagerService managerService = (ManagerService)ctx.getBean("managerServiceImpl");
        Manager manager=new Manager();
        manager.setMgrId("123456");
        manager.setMgrName("zs");
        manager.setMgrPwd("123456");
       int num=managerService.addManager(manager);
        System.out.println(num);
    }

    @Test
    public void test4(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("/applicationContext.xml");
        ManagerService managerService = (ManagerService)ctx.getBean("managerServiceImpl");
        Manager manager=managerService.queryManager("zs","123456");
    }


}
