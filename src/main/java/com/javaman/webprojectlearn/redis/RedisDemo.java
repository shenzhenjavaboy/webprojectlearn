package com.javaman.webprojectlearn.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Arrays;

public class RedisDemo {
    public static void main(String[] args) {
        //ip地址 端口号
        Jedis jedis=new Jedis("192.168.137.137",6379);
        jedis.set("sex","man");
        jedis.set("name","yaozai");
        jedis.set("class", "3");
        jedis.set("grade","6");
        String[] value={jedis.get("name"),jedis.get("sex"),jedis.get("class"),jedis.get("grade")};
        System.out.println();

        System.out.println(Arrays.toString(value));
        jedis.close();
    }



}
