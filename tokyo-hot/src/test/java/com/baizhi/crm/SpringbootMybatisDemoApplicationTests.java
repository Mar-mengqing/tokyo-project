package com.baizhi.crm;

import com.baizhi.crm.dao.UserDAO;
import com.baizhi.crm.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisDemoApplicationTests {
	@Autowired
	private UserDAO userDAO;
	@Test
	public void contextLoads() {
		List<User> users = userDAO.selectUsers();
		for (User user : users) {
			System.out.println(user);
		}
	}

}
