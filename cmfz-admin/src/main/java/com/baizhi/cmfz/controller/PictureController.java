package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("/insert")
    @ResponseBody
    public Map<String,Object> insert(Picture picture){
        Map<String, Object> map=new HashMap<String, Object>();
        try {
            pictureService.addPicture(picture);
            map.put("result", "success");
        } catch (Exception e) {
            // TODO: handle exception
            map.put("result", "fail");
        }
        return map;
    }

    @RequestMapping("/modify")
    @ResponseBody
    public Map<String,Object> modify(Picture picture){
        Map<String, Object> map=new HashMap<String, Object>();
        try {
            int result=pictureService.modifyPicture(picture);
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

}
