package com.itheima.header;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //没有响应的资源，告知客户端重定向到Servlet2
        //设置状态码
//        response.setStatus(302);
        //设置响应头
//        response.setHeader("Location", "/WEB14/servlet2");

        //封装成一个重定向的方法sendRedirect(url)
        response.sendRedirect("/WEB14/servlet2");
    }
}
