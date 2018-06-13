package com.baizhi.crm.service.impl;

import com.baizhi.crm.dao.UserDAO;
import com.baizhi.crm.dao.UserMapper;
import com.baizhi.crm.entity.User;
import com.baizhi.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with mengqing.
 * Date: 2018/5/24 0024
 * Time: 下午 3:20
 * 职位增删改查. 该类作用
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findUsers() {
        List<User> users = userDAO.selectUsers();
        return users;
    }
    @Override
    public User findUser(){
        User user =  userMapper.findUser();
        return user;
    }
}
