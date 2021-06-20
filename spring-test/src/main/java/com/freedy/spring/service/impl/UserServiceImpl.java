package com.freedy.spring.service.impl;

import com.freedy.spring.dao.UserDao;
import com.freedy.spring.service.UserService;
import lombok.Setter;

/**
 * @author Freedy
 * @date 2021/6/19 21:51
 */
@Setter
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Override
    public void add() {
        System.out.println("userService...");
        userDao.add();
    }
}
