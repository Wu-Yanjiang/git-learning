package com.itheima.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获得客户端携带的所有cookie信息
        Cookie[] cookies = request.getCookies();
        //通过cookie名称获得想要的cookie
        for (Cookie cookie : cookies) {
            //获得cookie的名称
            String cookieName = cookie.getName();
            if (cookieName.equals("name")){
                //获得cookie值
                String cookieValue = cookie.getValue();
                System.out.println(cookieValue);
            }
        }
    }
}
