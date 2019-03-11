package com.itheima.header;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RefererServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //对新闻来源判断
        String referer = request.getHeader("referer");
        response.setContentType("text/html;charset=utf-8");
        if (referer!=null && referer.startsWith("http://localhost")){
            //是从我自己的网站跳转过来的 可以看新闻
            response.getWriter().write("<p>中国确实已经拿到100块金牌</p>");
        }else {
            response.getWriter().write("盗链者，可耻！");
        }

    }
}
