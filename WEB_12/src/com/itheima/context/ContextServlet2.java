package com.itheima.context;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ContextServlet2")
public class ContextServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        //域对象--从servletContext中取数据
        String attribute = (String) this.getServletContext().getAttribute("name");
        System.out.println("ContextServlet2 got name :" + attribute);

        //域对象通用方法
        //setAttribute(String name, Object obj)
        //getAttribute(String name)
        //removeAttribute(String name)

    }
}
