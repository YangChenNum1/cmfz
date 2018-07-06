package com.baizhi.cmfz.test;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.service.PictureService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by HP on 2018/7/6.
 */
public class Test2 {
    @Test
    public void test1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("/applicationContext.xml");
        PictureService pictureService= (PictureService)ctx.getBean("pictureServiceImpl");
        Picture picture=new Picture();
        picture.setPicStatus("展示");
        picture.setPicId("1");
        int i = pictureService.modifyPicture(picture);
        System.out.println(i);
    }
}
