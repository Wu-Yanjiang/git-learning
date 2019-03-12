package com.itheima.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //创建cookie对象---头 -----cookie不能是中文
        Cookie cookie = new Cookie("name", "zhangsan");


        //为cookie设置持久化时间--Cookie在硬盘上保存的时间
        cookie.setMaxAge(60*10);//10分钟---秒为单位，时间为0代表删除该cookie

        //为Cookie设置携带路径
//        cookie.setPath("/WEB16/sendCookie");//访问sendCookie资源时，才携带这个Cookie
//        cookie.setPath("/WEB16");//访问WEB16下的任何资源时都携带这个cookie
//        cookie.setPath("/");//访问服务器下的所有资源都携带这个cookie
//         默认不写时，在产生这个cookie的目录下携带cookie信息

        //将cookie中存储的信息发送到客户端
        response.addCookie(cookie);
    }
}
