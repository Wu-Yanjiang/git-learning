package com.itheima.content;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置response查询码表
        //response.setCharacterEncoding("UTF-8");
        //写这一句就可以
        //通过一个Content-Type告知客户端使用的码表
        //response.setHeader("Content-Type", "text/html;charset=UTF-8");
        //用这个封装好的方法即可
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("Hello response!!");
        writer.write("你好！");//不设置码表中文就乱码

    }
}
