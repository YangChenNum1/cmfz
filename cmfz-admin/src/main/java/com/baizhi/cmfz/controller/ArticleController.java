package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.RichTextResult;
import com.baizhi.cmfz.service.ArticleService;
import com.baizhi.cmfz.service.GuruService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

/**
 * Created by HP on 2018/7/8.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private GuruService guruService;

    @RequestMapping("add1")
    public @ResponseBody Map<String,Object> addArticle(Article article,String artDescrip){
        Map<String,Object> map=new HashMap<String, Object>();
        System.out.println(artDescrip);
        article.setArtDescrip(artDescrip);
        String artId= UUID.randomUUID().toString().replace("-", "");
        article.setArtId(artId);
        int num=articleService.addArticle(article);
        if(num>0){
            map.put("result","success");
        }else{
            map.put("result",null);
        }
        return map;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public RichTextResult uploadFiles(@RequestParam("myfile") MultipartFile[] files, HttpServletRequest request) throws Exception { // MultipartFile[] 代表多文件上传
        RichTextResult result = new RichTextResult();
        ArrayList<String> data = new ArrayList<>();
        try {
            String realPath = request.getRealPath("");
            String uploadPath = realPath.substring(0,realPath.lastIndexOf("\\"))+"\\Files";
            if(files != null && files.length != 0){
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                    // 将上传的文件转存到服务器中存储
                    file.transferTo(new File(uploadPath+"\\"+fileName));

                    // 将上传的图片在服务器的url响应给客户端  图片回显
                    data.add(request.getContextPath()+"/Files/"+fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }

   /* @RequestMapping("/selectGuru")
    @ResponseBody
     public List selectGuru(){
        List<Guru> gurus=guruService.queryAllGuru();
        return gurus;
    }

    @RequestMapping("/selectArtByPage")
    @ResponseBody
    public Map<String,Object> selectArtByPage(@RequestParam("page") Integer nowPage, @RequestParam("rows") Integer pageSize){
         return articleService.queryArtByPage(nowPage,pageSize);
     }

    @RequestMapping("/modify")
    @ResponseBody
    public Map<String,Object> modifyArt(Article article){
        int num=articleService.modifyArt(article);
        Map<String,Object> map=new HashMap<String, Object>();
        if(num>0){
            map.put("result","success");
        }else {
            map.put("result",null);
        }
        return map;
    }

    @RequestMapping("selectArtById")
    @ResponseBody
    public Article selectArtById(String artId){
        Article article = articleService.queryArtById(artId);
        return article;
    }*/
}
