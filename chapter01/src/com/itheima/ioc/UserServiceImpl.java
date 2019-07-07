package com.itheima.ioc;

public class UserServiceImpl implements UserService {
    //声明UserDao属性
    private UserDao userDao;
    //添加属性的setter方法，用于实现依赖注入
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    //实现接口方法
    @Override
    public void say() {
        //调用userDao中的say()
        System.out.println("userService say hello.");
    }
}
