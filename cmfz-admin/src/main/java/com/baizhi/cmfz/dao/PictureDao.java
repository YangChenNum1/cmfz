package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HP on 2018/7/5.
 */
public interface PictureDao {

    /**
     * 添加轮播图
     * @param picture
     * @return
     */
    public int insertPicture(Picture picture);

    /**
     *
     * @param begin
     * @param pageSize
     * @return
     */
    public List<Picture> selectPictureByPage(@Param("begin") Integer begin, @Param("pageSize") Integer pageSize);
    /**
     * 更新轮播图
     * @param picture
     * @return
     */
    public int updatePicture(Picture picture);
    /**
     *查询轮播图信息
     * @param picId
     * @return
     */
    public Picture selectPicture(@Param("picId") String picId);

    /**
     * 查询轮播图总数
     * @return
     */
    public int selectCount();
}
