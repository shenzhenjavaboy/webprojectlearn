package com.javaman.webprojectlearn.strage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:靓仔
 * @Since：2023/12/02
 * @Description:
 */
@Component
public class PointSendText {

    @Autowired
    private List<Stragety> safeties;

    private  final Map<PointTypeEnum,Stragety> map=new HashMap<>();


    @PostConstruct
    public void init(){
        safeties.forEach(
                o->map.put(o.sendType(),o)
        );
    }

    public void sendPoint(PointTypeEnum pointTypeEnum,Integer point){
        Stragety stragety = map.get(pointTypeEnum);
        stragety.sendPoint(point);
    }
}
