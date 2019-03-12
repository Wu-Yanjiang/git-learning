package com.itheima.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //从session中获得存储的数据
        HttpSession session = request.getSession();
        String attribute = (String) session.getAttribute("name");

        response.getWriter().write(attribute);

        /* 第一次getSession()创建 */
        /* 服务器（非正常）关闭
            session过期/失效  从不操作服务器端资源开始计时
            手动销毁session

            */
    }
}
