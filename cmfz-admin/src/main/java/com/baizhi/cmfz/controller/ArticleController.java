package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HP on 2018/7/8.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    public @ResponseBody Map<String,Object> addArticle(Article article){
        Map<String,Object> map=new HashMap<String, Object>();
        int num=articleService.addArticle(article);
        if(num>0){
            map.put("result","success");
        }else{
            map.put("result",null);
        }
        return map;
    }

}
