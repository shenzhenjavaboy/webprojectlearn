package com.javaman.webprojectlearn.powermock.service;

import com.javaman.webprojectlearn.powermock.dao.MomDao;
import com.javaman.webprojectlearn.powermock.pojo.Mom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class MomService {

    @Autowired
    private MomDao momDao;

    public MomService(){

    }
    //写一个构造方法去关联userdao
    public MomService(MomDao momDao){

        this.momDao=momDao;
    }
    //查询mom
    public void queryMom(){

    }

    //增加mom
    public int addMom(Mom mom){


        return momDao.addMom(mom);
    }

    //增加mom
    public int addMom2(Mom mom){
        MomDao momDao=new MomDao();
        return momDao.addMom(mom);
    }
}
