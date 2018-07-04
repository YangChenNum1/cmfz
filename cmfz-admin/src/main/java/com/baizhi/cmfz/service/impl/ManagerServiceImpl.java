package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by HP on 2018/7/4.
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public Manager queryManager(String mgrName,String mgrPwd) {
        Manager manager=managerDao.selectManager(mgrName);
        System.out.println(manager);
        Manager mgr=null;
        String pwd= EncryptionUtils.encryption(mgrPwd+manager.getMgrSalt());
        if(pwd.equals(manager.getMgrPwd())){
            mgr=manager;
        }
        return mgr;
    }

    @Override
    public int addManager(Manager manager) {
        int result=0;
       String salt=EncryptionUtils.getSalt(6);
       manager.setMgrSalt(salt);
       String mgrPwd=manager.getMgrPwd();
       manager.setMgrPwd(EncryptionUtils.encryption(mgrPwd+salt));
       int num=managerDao.insertManager(manager);
       if(num>0){
           result=num;
       }
       return  result;
    }

    @Override
    public Manager queryCheckManager(String mgrName) {
        return managerDao.selectManager(mgrName);
    }
}
