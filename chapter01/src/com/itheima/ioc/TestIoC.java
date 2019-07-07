package com.itheima.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoC {
    public static void main(String[] args) {
        //初始化容器，加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //用容器获取实例
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        //调用实例方法
        userDao.say();
    }
}
