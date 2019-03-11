package com.itheima.line;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得请求方式
        String method = request.getMethod();
        System.out.println("method:" + method);
        //获得请求的资源的相关内容
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("uri:" + requestURI);
        System.out.println("url:" + requestURL);
        //获得web应用名称
        String contextPath = request.getContextPath();
        System.out.println("web应用:" + contextPath);
        //地址后的参数的字符串
        //post方法获取的是空,因为没跟在URL后，get方法就会获得?后的参数
        String queryString = request.getQueryString();
        System.out.println(queryString);
        //获得客户机的IP
        String remoteAddr = request.getRemoteAddr();
        System.out.println("ip:" + remoteAddr);
    }
}
