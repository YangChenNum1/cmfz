package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

import java.util.Map;

/**
 * Created by HP on 2018/7/8.
 */
public interface ArticleService {
    /**
     * 添加文章
     * @param article
     * @return
     */
    public int addArticle(Article article);

    /**
     * 分页查询列表
     * @param nowPage
     * @param pageSize
     * @return
     */
    /*public Map<String,Object> queryArtByPage(Integer nowPage, Integer pageSize);

    *//**
     * 查询单个文章信息
     * @param artId
     * @return
     *//*
    public Article queryArtById(String artId);

    *//**
     * 修改文章
     * @param article
     * @return
     *//*
    public int modifyArt(Article article);*/
}
