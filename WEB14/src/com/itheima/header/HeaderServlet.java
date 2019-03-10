package com.itheima.header;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class HeaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date date = new Date();
        //设置响应头
        response.addHeader("name", "zhangsan");
//        response.addIntHeader("age", 28);
//        response.addDateHeader("birthday", date.getTime());

        response.addHeader("name", "lisi");//add同名，都会有

        response.setHeader("age", "28");
        response.setHeader("age", "50");//set重名会覆盖之前的值

    }
}
