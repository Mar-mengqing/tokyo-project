package com.baizhi.crm.repository;

import com.baizhi.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with mengqing.
 * Date: 2018/6/5 0005
 * Time: 上午 11:31
 * 职位增删改查.
 */
@Transactional
@Repository
public interface UserRepository extends JpaRepository<User,String>,JpaSpecificationExecutor<User> {
}
