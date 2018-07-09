package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HP on 2018/7/8.
 */
public interface ArticleDao {
    /**
     * 添加文章
     * @param article
     * @return
     */
    public int insertArticle(Article article);

   /* *//**
     * 分页查询文章列表
     * @param begin
     * @param pageSize
     * @return
     *//*
    public List<Article> selectArticleByPage(@Param("begin") Integer begin, @Param("pageSize") Integer pageSize);

    *//**
     * 根据文章Id查询文章详情
     * @param artId
     * @return
     *//*
    public Article selectArticleById(@Param("artId") String artId);

    *//**
     * 更新文章
     * @param article
     * @return
     *//*
    public int updateArticle(Article article);

    *//**
     * 查询总条数
     * @return
     *//*
    public int selectCount();*/
}
