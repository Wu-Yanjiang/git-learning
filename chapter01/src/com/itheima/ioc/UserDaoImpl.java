package com.itheima.ioc;

public class UserDaoImpl implements UserDao {
    @Override
    public void say() {
        System.out.println("UserDao say hello!");
    }
}