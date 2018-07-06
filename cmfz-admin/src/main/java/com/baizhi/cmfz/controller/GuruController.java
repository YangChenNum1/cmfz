package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by HP on 2018/7/6.
 */
@Controller
@RequestMapping("/guru")
public class GuruController {

    @Autowired
    private GuruService guruService;

    @RequestMapping("/findByPage")
    @ResponseBody
    public Map<String,Object> findByPage(@RequestParam("page") Integer nowPage, @RequestParam("rows") Integer pageSize){
        return guruService.queryGuruByPage(nowPage,pageSize);
    }

    @RequestMapping("/findByPageMohu")
    @ResponseBody
    public Map<String,Object> findByPageMohu(String value,@RequestParam("page") Integer nowPage,@RequestParam("rows") Integer pageSize){
        return guruService.queryGuruByPageMohu(value,nowPage,pageSize);
    }


    @RequestMapping("/modify")
    @ResponseBody
    public Map<String,Object> modify(Guru guru){
        Map<String, Object> map=new HashMap<String, Object>();
        try {
            int result=guruService.modifyGuru(guru);
            map.put("result", "success");
        } catch (Exception e) {
            // TODO: handle exception
            map.put("result", "fail");
        }
        return map;
    }

    @RequestMapping("/upload")
    public @ResponseBody Map<String,Object> upload(MultipartFile myfile, HttpSession session,Guru guru) throws IOException {
        //1.获得文件夹真实路径
        String realPath=session.getServletContext().getRealPath("/");
        int lastIndexOf=realPath.lastIndexOf("\\");
        String substring=realPath.substring(0,lastIndexOf);
        int lastIndexOf1=substring.lastIndexOf("\\");
        String substring1=realPath.substring(0,lastIndexOf1);
        String uploadPath=substring1+"\\Files";
        //2.生成UUID
        String guruId= UUID.randomUUID().toString().replace("-", "");
        guru.setGuruId(guruId);
        //3.读取文件后缀名
        //（1）获取上传文件名称
        String guruPhoto=myfile.getOriginalFilename();
        guru.setGuruPhoto(guruPhoto);
        //（3）组装
        myfile.transferTo(new File(uploadPath+"\\"+guruPhoto));
        int num=guruService.addGuru(guru);
        Map<String, Object> map=new HashMap<String, Object>();
        if(num>0){
            map.put("result","succeess");
        }
        return map;
    }
}
