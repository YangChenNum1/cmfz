package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HP on 2018/7/8.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public int addArticle(Article article){
        return articleDao.insertArticle(article);
    }

   /* @Override
    public Map<String, Object> queryArtByPage(Integer nowPage, Integer pageSize){
        List<Article> articles =articleDao.selectArticleByPage((nowPage-1)*pageSize,pageSize);
        int count=articleDao.selectCount();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total", count);
        map.put("rows", articles);
        return map;
    }*/

   /* @Override
    public Article queryArtById(String artId) {
        return articleDao.selectArticleById(artId);
    }

    @Override
    public int modifyArt(Article article) {
        return articleDao.updateArticle(article);
    }*/
}
