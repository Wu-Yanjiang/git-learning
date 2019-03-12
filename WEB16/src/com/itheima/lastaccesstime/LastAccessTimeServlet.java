package com.itheima.lastaccesstime;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LastAccessTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获得当前时间
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime = URLEncoder.encode(format.format(date), "utf-8");

        //创建cookie记录当前最新的访问时间
        Cookie cookie = new Cookie("LastAccessTime", currentTime);
        cookie.setMaxAge(60 * 10 * 500);
        response.addCookie(cookie);

        //获得客户端携带cookie————lastAccessTime
        String lastAccessTime = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookieName : cookies) {
                if (cookieName.getName().equals("LastAccessTime")) {
                    lastAccessTime = cookieName.getValue();
                    System.out.println(URLDecoder.decode(lastAccessTime, "utf-8"));
                }
            }
        }

        response.setContentType("text/html;charset=utf-8");
        if (lastAccessTime == null) {
            response.getWriter().write("您第一次访问");
        } else {
            response.getWriter().write("您上次访问时间是：" + URLDecoder.decode(lastAccessTime, "utf-8"));
        }

    }
}
