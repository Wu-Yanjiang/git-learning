package com.itheima.register;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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


        //使用BeanUtils进行自动映射封装
        //工作原理：将一个map中的数据，根据key与实体的属性的对应关系封装
        //只要key的名字与实体的属性的名字一样 就自动封装到实体中
        Map<String, String[]> properties = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //现在User对象已经封装好
        //手动封装uid-----uuid----随机不重复字符串--Java代码生成后是36位
        user.setUid(UUID.randomUUID().toString());

        //将参数传递给一个业务操作方法


    }

    //注册的方法
    public void register(User user){
        //操作数据库
        QueryRunner runner = new QueryRunner(DataSourceUtils);
    }
}
