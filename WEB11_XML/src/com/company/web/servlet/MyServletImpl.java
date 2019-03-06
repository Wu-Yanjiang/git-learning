package com.company.web.servlet;

public class MyServletImpl implements IMyServlet {
    @Override
    public void init() {
        System.out.println("俺来也");
    }

    @Override
    public void service() {

        System.out.println("俺服务也");
    }

    @Override
    public void destroy() {

        System.out.println("俺去也");
    }
}
