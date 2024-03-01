package com.javaman.webprojectlearn.thread;

import com.google.common.collect.Lists;
import org.elasticsearch.common.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:靓仔
 * @Since：2024/02/22
 * @Description:
 */
public class ThreadPool {
    public static void main(String[] args) {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start("duoxiancheng");
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < 10009; i++) {
            list.add(i);
        }
      /*  list.forEach(
                o->{
                    System.out.println(o);
                }
        );*/
        //把集合分成100个一组
        List<List<Integer>> partition = Lists.partition(list, 100);
        //创建线程池，线程数为分批的数
        ExecutorService executorService = Executors.newFixedThreadPool(partition.size());
        //线程技术器  分批的数
        CountDownLatch countDownLatch = new CountDownLatch(partition.size());
        partition.forEach(
                o->{
                    executorService.execute(
                            ()->{
                                o.forEach(num->{
                                    System.out.println(num);
                                });
                            }
                    );
                    countDownLatch.countDown();
                }
        );
        try {
            countDownLatch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
        stopWatch.stop();
        String s = stopWatch.prettyPrint();

        System.out.println(s);
    }
}
