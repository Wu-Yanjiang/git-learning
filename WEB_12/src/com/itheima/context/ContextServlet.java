package com.itheima.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得ServletContext对象
        //作用：
        //获得web应用全局初始化参数

        ServletContext context = this.getServletContext();
        //获得初始化参数
        String initParameter = context.getInitParameter("driver");
        System.out.println(initParameter);
        //通过context对象获得参数
        //获得web应用中任何资源的绝对路径
        //获得a.txt
        String realPath_A = context.getRealPath("/a.txt");
        System.out.println(realPath_A);
        //b.txt
        String realPath_B = context.getRealPath("/WEB-INF/b.txt");
        System.out.println(realPath_B);
        //c.txt
        String realPath_C = context.getRealPath("/WEB-INF/classes/c.txt");
        System.out.println(realPath_C);
        //d.txt
        //获取不到


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
