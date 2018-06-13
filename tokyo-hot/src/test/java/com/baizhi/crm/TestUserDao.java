package com.baizhi.crm;

import com.baizhi.crm.dao.UserDAO;
import com.baizhi.crm.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with mengqing.
 * Date: 2018/5/24 0024
 * Time: 下午 5:38
 * 职位增删改查. 该类作用
 */
public class TestUserDao extends BaseTest{
    @Autowired
    private UserDAO userDAO;
    @Test
    public void test(){
        List<User> users = userDAO.selectUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
