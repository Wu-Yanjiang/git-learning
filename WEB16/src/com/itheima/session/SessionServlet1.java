package com.itheima.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //创建属于该客户端私有的session区域
        //该方法会判断客户端是否在服务器端已存在session
        /*
        * 实质就是根据JSESSIONID判断是否存在
        * 不存在就创建，存在则返回引用
        * */
        HttpSession session = request.getSession();

        session.setAttribute("name", "jerry");



        String id = session.getId();
        response.getWriter().write("JSESSIONID:" + id);
    }
}
