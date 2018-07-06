package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HP on 2018/7/6.
 */
public interface GuruDao {
    /**
     * 插入上师
     * @param guru
     * @return
     */
    public int insertGuru(Guru guru);

    /**
     * 更新上师信息
     * @param guru
     * @return
     */
    public int updateGuru(Guru guru);

    /**
     * 分页查询上师
     * @param begin
     * @param pageSize
     * @return
     */
    public List<Guru> findGuruByPage(@Param("begin") Integer begin, @Param("pageSize") Integer pageSize);
    /**
     * 根据法名模糊查询并分页
     * @param value
     * @param begin
     * @param pageSize
     * @return
     */
    public List<Guru> findGuruByPageMohu(@Param("value") String value, @Param("begin") Integer begin, @Param("pageSize") Integer pageSize);
    /**
     *查询条数
     * @return
     */
    public int selectCount();

    /**
     * 模糊查询条数
     * @param value
     * @return
     */
    public int selectCountMohu(@Param("value") String value);

}
