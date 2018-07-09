package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.GuruDao;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HP on 2018/7/6.
 */
@Service
@Transactional
public class GuruServiceImpl implements GuruService {

   @Autowired
    private GuruDao guruDao;
    @Override
    public Map<String, Object> queryGuruByPage(Integer nowPage, Integer pageSize) {
        List<Guru> gurus = guruDao.findGuruByPage((nowPage - 1) * pageSize, pageSize);
        int count=guruDao.selectCount();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total", count);
        map.put("rows", gurus);
        return map;
    }

    @Override
    public Map<String, Object> queryGuruByPageMohu(String value, Integer nowPage, Integer pageSize) {
        String value1="%"+value+"%";
        List<Guru> gurus = guruDao.findGuruByPageMohu(value1,(nowPage - 1) * pageSize, pageSize);
        int count=guruDao.selectCountMohu(value1);
        System.out.println("count  "+count);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total", count);
        map.put("rows", gurus);
        return map;
    }

    @Override
    public int addGuru(Guru guru) {
        return guruDao.insertGuru(guru);
    }

    @Override
    public int modifyGuru(Guru guru) {
        return guruDao.updateGuru(guru);
    }

    @Override
    public List<Guru> queryAllGuru() {
        return guruDao.selectAllGuru();
    }

    @Override
    public int addAllGuru(List<Guru> gurus) {
        return guruDao.insertBatch(gurus);
    }
}
