package com.itheima.forward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //向request域中存数据
        request.setAttribute("name", "tom");
        //request域的作用范围：一次请求中



        /******************请求转发****************/
//        转发是在服务器内部进行，客户端是一次请求，重定向是2次请求
        //servlet1将请求转发给servlet2
        RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet2");
        //执行转发方法
        dispatcher.forward(request, response);


        /*ServletContext:
         *创建：服务器启动
         * 销毁：服务器关闭
         * 域的作用范围：整个web应用
         *
         * request：
         * 创建：访问时创建request
         * 销毁：响应结束request
         * 域的作用范围：一次请求中
         *
         *
         * 转发域重定向区别：
         * 重定向：两次       转发：一次
         *   地址变化              不变
         *  可以访问外部网站        只能访问站点内部资源
         *                          性能更优
         *
         *  客户端地址：客户端访问服务器的地址，服务器外部的地址 特点：写上web应用名称
         *  直接输入地址、
         *  重定向
         *
         *  服务器端地址写法：服务器内部资源的跳转的地址 特点：不需要写web应用名称
         *  转发
         *
         *
         */
    }
}
