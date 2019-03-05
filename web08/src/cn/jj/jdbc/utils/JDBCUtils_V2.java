package cn.jj.jdbc.utils;

import java.sql.*;
import java.util.ResourceBundle;

/*
 *
 * @param null
 * @return
 * @author wuyanjiang
 * @date
 * @description 提供获取连接释放资源的方法
 */
public class JDBCUtils_V2 {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;


    /*
     *
     * @param null
     * @return
     * @author wuyanjiang
     * @date
     * @description 静态代码块加载配置文件信息
     */
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        driver = bundle.getString("driver");
        url = bundle.getString("url");
        username = bundle.getString("username");
        password = bundle.getString("password");
    }

    /*
     *
     * @param null
     * @return
     * @author wuyanjiang
     * @date
     * @description 获取连接
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
