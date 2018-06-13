package com.baizhi.crm.service;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.crm.entity.User;

import java.util.List;

/**
 * Created with mengqing.
 * Date: 2018/5/24 0024
 * Time: 下午 3:19
 * 职位增删改查. 该类作用
 */
public interface UserService {
    public List<User> findUsers();
    public User findUser();
}
