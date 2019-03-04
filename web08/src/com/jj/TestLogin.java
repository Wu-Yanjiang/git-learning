package com.jj;

import org.junit.Test;

import java.sql.*;

/*
 *
 * @param null
 *
 * @return
 * @author wuyanjiang
 * @date
 * @description 测试SQL注入问题
 */
public class TestLogin {
    @Test
    public void testLogin() throws SQLException, ClassNotFoundException {
        login1("老王 ' or ' 老王", "666");
    }

    /*
     *
     * @param
     * @return
     * @author wuyanjiang
     * @date
     * @description
     */
    public void Login(String username, String password) throws SQLException, ClassNotFoundException {
//      1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
//      2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://119.28.82.234:3306/web08", "root", "123456");
//      3.创建执行SQL语句对象
        Statement stmt = conn.createStatement();
//      4.书写SQL语句
        String sql = "select * from tbl_user where uname = '" + username + "' and upassword = '" + password + "'";
//      5.执行SQL语句
        ResultSet rs = stmt.executeQuery(sql);
//      6.对结果集进行处理
        if (rs.next()) {
            System.out.println(username + "登陆成功");
            System.out.println(sql);
        } else {
            System.out.println("登录失败");
        }
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();

    }

    public void login1(String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://119.28.82.234/web08", "root", "123456");
        String sql = "select * from tbl_user where uname=? and upassword=?";
//        设置参数
        //      创建预处理对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        //      6.对结果集进行处理
        if (rs.next()) {
            System.out.println(username + "登陆成功");
            System.out.println(sql);
        } else {
            System.out.println("登录失败");
        }
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
}
