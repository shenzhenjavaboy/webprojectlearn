package com.javaman.webprojectlearn.strage;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author:靓仔
 * @Since：2023/12/02
 * @Description:
 */
@Component
public class StragetyB implements Stragety{
    @Override
    public void sendPoint(Integer point) {
        System.out.println("积分"+point);
    }

    @Override
    public PointTypeEnum sendType() {
        return PointTypeEnum.B;
    }
}
