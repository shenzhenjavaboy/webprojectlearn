package com.javaman.webprojectlearn.strage;

import java.math.BigDecimal;

/**
 * @Author:靓仔
 * @Since：2023/12/02
 * @Description: 策略模式学习
 */
public interface Stragety {
    //发放积分
    void sendPoint(Integer point);
    //积分类型
    PointTypeEnum sendType();
}
