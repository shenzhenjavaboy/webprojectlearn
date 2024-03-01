package com.javaman.webprojectlearn.powermockdemo;

import com.javaman.webprojectlearn.powermock.dao.MomDao;
import com.javaman.webprojectlearn.powermock.pojo.Mom;
import com.javaman.webprojectlearn.powermock.service.MomService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
//如果要使用@MockBean注解，运行器要用SpringRunner
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
//如果没有该注解的话，下面从容器取MomService就会报错
@ContextConfiguration(classes ={MomService.class} )
//下面这个注解  说实话不太清楚起什么作用---2021、07、02 应该是mock静态类的时候需要用到
//@PrepareForTest(MomDao.class)
public class MyPowermock {

    @Autowired
    private MomService momService;
    //如果要使用MockBean，运行器需要使用SpringRunner
    @MockBean
    private MomDao momDao;

    @Test
    public void testmock1(){
        PowerMockito.when(momDao.addMom(Mockito.any())).thenReturn(10);
        Mom mom=new Mom();
        mom.setId(1);
        MomService momService1=new MomService(momDao);
        int nums = momService1.addMom(mom);

        assertEquals(nums,10);

    }

    @Test
    //局部变量无参
    public void testmock2(){

        try {
            MomService momService=new MomService();
            MomDao momDao=new MomDao();
            Mom mom=new Mom();
            PowerMockito.whenNew(MomDao.class).withNoArguments().thenReturn(momDao);
            Mockito.doReturn(10).when(momDao).addMom(mom);
            int nums=momService.addMom2(mom);
            assertEquals(nums,10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Mom mom=new Mom();
        mom.setId(1);
        MomService momService1=new MomService(momDao);
    }
}
