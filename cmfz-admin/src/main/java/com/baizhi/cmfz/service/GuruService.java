package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Guru;

import java.util.List;
import java.util.Map;

/**
 * Created by HP on 2018/7/6.
 */
public interface GuruService {
    public Map<String,Object> queryGuruByPage(Integer nowPage, Integer pageSize);

    public Map<String,Object> queryGuruByPageMohu(String value, Integer nowPage, Integer pageSize);

    public int addGuru(Guru guru);

    public int modifyGuru(Guru guru);

    public List<Guru> queryAllGuru();

    public int addAllGuru(List<Guru> gurus);

}
