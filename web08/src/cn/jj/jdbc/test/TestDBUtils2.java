package cn.jj.jdbc.test;

import cn.jj.domain.User;
import cn.jj.jdbc.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 测试DBUtils查询操作
 */
public class TestDBUtils2 {
    /**
     * 查询所有用户方法
     */
    @Test
    public void testQueyAll() {
        try {
//        获取核心类
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//        SQL语句
            String sql = "select * from tbl_user";
//        执行查询
            List<User> users = qr.query(sql, new BeanListHandler<>(User.class));
//            结果集遍历
            for (User user : users) {
                System.out.println(user.getUname() + ":" + user.getUpassword());
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 根据ID查询用户方法
     */
    @Test
    public void testQueyUserById() {
        try {
//        获取核心类
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//        SQL语句
            String sql = "select * from tbl_user where uid=?";
//            为占位符设置参数
            Object[] params = {11};
            User user = qr.query(sql, new BeanHandler<>(User.class), params);
//        执行查询
            System.out.println(user.getUname() + ":" + user.getUpassword());
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    /**
     * 查询用户个数
     */
    @Test
    public void testQueyCount() {
        try {
//        获取核心类
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//        SQL语句
            String sql = "select count(*) from tbl_user";
//        执行查询
            Long count = (Long) qr.query(sql, new ScalarHandler());
            System.out.println(count);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    /**
     * 查询所有用户
     */
    @Test
    public void testQueyAll1() {
        try {
//        获取核心类
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//        SQL语句
            String sql = "select * from tbl_user";
//        执行查询
            List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
//            结果集遍历
            for (Map<String, Object> map : list) {
                System.out.println(map);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    /**
     * 查询所有用户
     */
    @Test
    public void testQueyAll2() {
        try {
//        获取核心类
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//        SQL语句
            String sql = "select * from tbl_user";
//        执行查询
            List<Object> list = qr.query(sql, new ColumnListHandler("uname"));
            for (Object o : list) {
                System.out.println(o);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
