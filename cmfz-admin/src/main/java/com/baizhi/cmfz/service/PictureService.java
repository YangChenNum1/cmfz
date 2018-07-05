package com.baizhi.cmfz.service;


import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by HP on 2018/7/5.
 */
public interface PictureService {
    /**
     *
     * @return
     * 添加图片
     */
    public int addPicture(Picture picture);

    /**
     * 分页查询
     * @param nowPage
     * @param pageSize
     * @return
     */
    public Map<String, Object> queryPictureByPage(Integer nowPage, Integer pageSize);
    /**
     * 更新轮播图
     * @param picture
     * @return
     */
    public int modifyPicture(Picture picture);
    /**
     *查询轮播图信息
     * @param picId
     * @return
     */
    public Picture queryPicture(@Param("picId") String picId);

    /**
     * 查询轮播图总数
     * @return
     */
    public int queryCount();
}
