package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HP on 2018/7/5.
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDao pictureDao;
    @Override
    public int addPicture(Picture picture) {
        return pictureDao.insertPicture(picture);
    }

    @Override
    public Map<String, Object> queryPictureByPage(Integer nowPage, Integer pageSize) {
        // TODO Auto-generated method stub
        List<Picture> pictures=pictureDao.selectPictureByPage((nowPage - 1) * pageSize,pageSize);
        int count=pictureDao.selectCount();
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total", count);
        map.put("rows", pictures);
        return map;
    }

    @Override
    public int modifyPicture(Picture picture) {
        return pictureDao.updatePicture(picture);
    }

    @Override
    public Picture queryPicture(String picId) {
        return pictureDao.selectPicture(picId);
    }

    @Override
    public int queryCount() {
        return pictureDao.selectCount();
    }
}
