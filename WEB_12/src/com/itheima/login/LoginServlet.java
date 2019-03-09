package com.itheima.login;

import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void init() throws ServletException {
        //在Servletcontext域中存一个数据count
        int count = 0;
        this.getServletContext().setAttribute("count", count);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.getWriter().write("<h1>Info</h1></br>");
            System.out.println("doGet running...");
            //获得用户名
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //从数据库验证用户名/密码
            QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
            String sql = "select * from user where username =? and password=?";
            User user = runner.query(sql, new BeanHandler<>(User.class), username, password);

            if (user != null) {
                //从servletcontext中取出count进行++
                ServletContext context = this.getServletContext();
                Integer count = (Integer) context.getAttribute("count");
                count++;
                context.setAttribute("count", count);
                //用户登录成功
                response.getWriter().write(user.toString() + "--you are the " + count + "th user login today.");
            } else {
                //登录失败
                response.getWriter().write("Sorry your username is invalid.");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        //根据返回结果给用户不同显示信息
    }
}
