package com.itheima.register;

import com.itheima.utils.DataSourceUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取数据
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        //....太麻烦不用

        //将散装数据封装到JavaBean中
//        User user = new User();
//        user.setUsername(username);
        //...

        //只适合post方式的表单提交的中文乱码
        //request.setCharacterEncoding("UTF-8");
        //服务器默认查的是ISO8859-

        //get方式乱码解决  也适用与post
        String username = request.getParameter("username");
        //先用ISO8859-1编码，再使用utf-8解码
        username = new String(username.getBytes("iso8859-1"), "utf-8");
        //表单一多就麻烦，不适用



        //使用BeanUtils进行自动映射封装
        //工作原理：将一个map中的数据，根据key与实体的属性的对应关系封装
        //只要key的名字与实体的属性的名字一样 就自动封装到实体中
        Map<String, String[]> properties = request.getParameterMap();
        User user = new User();
        try {
            /******这里有一个异常不知道怎么解决，想想办法手动实现这个过程吧！**********/
            BeanUtils.populate(user, properties);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        //现在User对象已经封装好
        //手动封装uid-----uuid----随机不重复字符串32位--Java代码生成后是36位,4个小杠
        user.setUid(UUID.randomUUID().toString());

        //将参数传递给一个业务操作方法
        try {
            register(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //注册成功跳转登录页面
        //提高复用性用getContextPath(),避免项目名改变
        response.sendRedirect(request.getContextPath() + "/login.jsp");


    }

    //注册的方法
    private void register(User user) throws SQLException {
        //操作数据库
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";

        runner.update(sql, user.getUid(), user.getUsername(), user.getPassword(),
                user.getName(), user.getEmail(), null, user.getBirthday(), user.getSex(), null, null);


    }
}
