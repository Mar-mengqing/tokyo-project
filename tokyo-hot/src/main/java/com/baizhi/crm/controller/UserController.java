package com.baizhi.crm.controller;

import com.baizhi.crm.dao.UserMapper;
import com.baizhi.crm.entity.User;
//import com.baizhi.crm.repository.UserRepository;
import com.baizhi.crm.repository.UserRepository;
import com.baizhi.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with mengqing.
 * Date: 2018/5/24 0024
 * Time: 下午 3:24
 * 职位增删改查. 该类作用
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("findUsers")
    public List<User> findUsers(){
        return userService.findUsers();
    }
    @RequestMapping("findUser")
    public List<User> findUser(){
        List<User> list = userRepository.findAll();
        return list;
    }
    @RequestMapping("find")
    public User find(){
        User list = userMapper.findUser();
        return list;
    }
}
