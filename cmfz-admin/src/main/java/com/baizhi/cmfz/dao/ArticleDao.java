package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;

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
}
