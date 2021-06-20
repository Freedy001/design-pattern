package com.freedy.spring.controller;


import com.freedy.customSpring.context.ApplicationContext;
import com.freedy.customSpring.context.support.ClassPathXmlApplicationContext;
import com.freedy.spring.service.UserService;

/**
 * @author Freedy
 * @date 2021/6/19 21:52
 */
public class UserController {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = context.getBean("userService", UserService.class);
        service.add();
    }
}
