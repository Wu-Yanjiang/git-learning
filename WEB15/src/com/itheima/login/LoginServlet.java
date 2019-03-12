package com.itheima.login;

import com.itheima.register.User;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获得用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //调用业务方法进行用户查询
        User login = null;
        try {
            login = login(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //通过user是否为null判断用户名和密码是否正确
        if (login != null) {
            //用户名 或密码正确
            //登录成功，跳转网站首页
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            //用户名或密码错误
            //跳回login.jsp
            //如果使用转发到login.jsp,向request域中存储错误信息
            request.setAttribute("loginInfo", "用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);


        }

    }

    public User login(String username, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username=? and password=?";
        User user = runner.query(sql, new BeanHandler<User>(User.class), username, password);
        return user;
    }
}
