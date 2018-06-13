package com.baizhi.crm.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created with mengqing.
 * Date: 2018/5/25 0025
 * Time: 下午 4:25
 * 职位增删改查. 该类作用
 */
public class JedisUtil {
    private final static JedisPool POOL;
     static {
         JedisPoolConfig config = new JedisPoolConfig();
         config.setMaxTotal(20);
         config.setMaxWaitMillis(10000);
         POOL  =  new JedisPool(config,"172.25.35.184",6379);
     }
     public static Jedis getJedis(){
         return POOL.getResource();
     }
     public static void closeJedis(Jedis jedis){
         jedis.close();
     }
}
