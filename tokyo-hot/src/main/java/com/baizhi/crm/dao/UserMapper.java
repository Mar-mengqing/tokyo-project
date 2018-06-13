package com.baizhi.crm.dao;

import com.baizhi.crm.dao.impl.BaseDaoImpl;
import com.baizhi.crm.entity.User;
import org.springframework.stereotype.Repository;



/**
 * Created with mengqing.
 * Date: 2018/6/5 0005
 * Time: 下午 4:20
 * 职位增删改查. 该类作用
 */
@Repository
public class UserMapper extends BaseDaoImpl {
    public User findUser(){
        return this.findById(User.class,1);
    }
}
