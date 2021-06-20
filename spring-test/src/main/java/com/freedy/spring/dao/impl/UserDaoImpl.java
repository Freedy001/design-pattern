package com.freedy.spring.dao.impl;

import com.freedy.spring.dao.UserDao;
import lombok.ToString;

/**
 * @author Freedy
 * @date 2021/6/19 21:50
 */
@ToString
public class UserDaoImpl implements UserDao {
    private String username;
    private String password;
    static {
        System.out.println("UserDaoImpl init");
    }
    @Override
    public void add() {
        System.out.println("UserDaoImpl 添加！！！！");
        System.out.println(this);
    }
}
