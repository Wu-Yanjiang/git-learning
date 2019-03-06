package com.company.web.servlet1;

import com.company.web.servlet.IMyServlet;

public class MyServlet2 implements IMyServlet {
    @Override
    public void init() {
        System.out.println("MyServlet2诞生了。。。");
    }

    @Override
    public void service() {

        System.out.println("MyServlet2开始服务了。。。");
    }

    @Override
    public void destroy() {

        System.out.println("MyServlet2销毁了。。。");
    }
}
