package com.itheima.servlet;

import javax.servlet.*;
import java.io.IOException;

public class QuickStartServlet implements Servlet {

    //servlet对象创建时执行
    //默认第一次访问servlet时创建该对象
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //获得servlet的name <servlet-name>MyFirstServlet</servlet-name>
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);
        //获得Servlet的初始化参数
        String initParameter = servletConfig.getInitParameter("url");
        System.out.println(initParameter);
        //获得Servletcontext对象
        ServletContext servletContext = servletConfig.getServletContext();


        System.out.println("init running");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**每次请求执行
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("QuickStartServlet 111 runnning...");
        servletResponse.getWriter().write("<h1 style='color : red'>Hello world.</h1>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * servlet对象销毁执行
     * 服务器关闭servlet销毁
     */
    @Override
    public void destroy() {
        System.out.println("destroy runnning");
    }
}
