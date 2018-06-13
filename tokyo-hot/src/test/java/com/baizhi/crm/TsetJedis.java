package com.baizhi.crm;

import com.baizhi.crm.util.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created with mengqing.
 * Date: 2018/5/25 0025
 * Time: 下午 5:30
 * 职位增删改查. 该类作用
 */
public class TsetJedis {
    @Test
    public void testJedis(){
        Jedis jedis = JedisUtil.getJedis();
        jedis.select(3);
        jedis.setex("18249507169",90,"FFTH");
        JedisUtil.closeJedis(jedis);
    }
}
