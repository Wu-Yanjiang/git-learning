package com.itheima.content;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

public class ContentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获得单个表单值
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        //获得多个表单的值
        for (String hobby : request.getParameterValues("hobby")) {
            System.out.println(hobby);
        }
        //获得所有请求参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            System.out.println(parameterNames.nextElement());
        }
        //获得所有参数封装到一个Map<Stirng, String[]>
        System.out.println("---------------------");
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.print(entry.getKey() + " : " );
            for (String str :  entry.getValue()){
                System.out.print(str + " ");
            }
            System.out.println("\n------------------");
        }

        //get请求方式，上述方法一样适用
    }
}
