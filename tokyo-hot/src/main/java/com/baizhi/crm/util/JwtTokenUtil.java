package com.baizhi.crm.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * JWT帮助类
 * 项目权限的处理
 */
@Component
public class JwtTokenUtil implements Serializable{
    private static final long serialVersionUID = -3301605581108950415L;

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    //请求头
    @Value("${jwt.header}")
    public String tokenHeader;
    //token头
    @Value("${jwt.tokenHead}")
    public String tokenHead;
    //私钥
    @Value("${jwt.secret}")
    private String secret;
    //过期时间
    @Value("${jwt.expiration}")
    private Long expiration;
    //从token获取user对象

}
