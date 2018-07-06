package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by HP on 2018/7/5.
 */
@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/findByPage")
    @ResponseBody
    public Map<String,Object> findByPage(@RequestParam("page") Integer nowPage, @RequestParam("rows") Integer pageSize){
        return pictureService.queryPictureByPage(nowPage,pageSize);
    }


    @RequestMapping("/modify")
    @ResponseBody
    public Map<String,Object> modify(Picture picture){
        Map<String, Object> map=new HashMap<String, Object>();
        try {
            int result=pictureService.modifyPicture(picture);
            System.out.println(result);
            map.put("result", "success");
        } catch (Exception e) {
            // TODO: handle exception
            map.put("result", "fail");
        }
        return map;
    }

    @RequestMapping("/select")
    @ResponseBody
    public Map<String,Object> select(String picId){
        Map<String, Object> map=new HashMap<String, Object>();
        try {
            pictureService.queryPicture(picId);
            map.put("result", "success");
        } catch (Exception e) {
            // TODO: handle exception
            map.put("result", "fail");
        }
        return map;
    }

  @RequestMapping("upload")
    public @ResponseBody Map<String,Object> upload(MultipartFile myfile, HttpSession session,Picture picture) throws IOException {
        //1.获得文件夹真实路径
      System.out.println("uefuweridfhieuhgioerhioyhuigui");
        String realPath=session.getServletContext().getRealPath("/");
        //System.out.println("realPath"+realPath);
        int lastIndexOf=realPath.lastIndexOf("\\");
        String substring=realPath.substring(0,lastIndexOf);
        int lastIndexOf1=substring.lastIndexOf("\\");
        String substring1=realPath.substring(0,lastIndexOf1);
        String uploadPath=substring1+"\\Files";
        //System.out.println("uploadPath"+uploadPath);
       //2.生成UUID
        String picId= UUID.randomUUID().toString().replace("-", "");
        picture.setPicId(picId);
       //3.读取文件后缀名
        //（1）获取上传文件名称
        String picPath=myfile.getOriginalFilename();
        //System.out.println("picPath"+picPath);
        picture.setPicPath(picPath);
        //（3）组装
        //System.out.println("pathname"+uploadPath+"/"+picPath);
        myfile.transferTo(new File(uploadPath+"\\"+picPath));

        Date date=new Date();
        picture.setPicDate(date);
        int num=pictureService.addPicture(picture);
        Map<String, Object> map=new HashMap<String, Object>();
        if(num>0){
            map.put("result","succeess");
        }
        return map;
    }
}
