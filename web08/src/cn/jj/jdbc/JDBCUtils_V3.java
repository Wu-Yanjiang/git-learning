package cn.jj.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

/*
 *
 * @param null
 * @return
 * @author wuyanjiang
 * @date
 * @description 提供获取连接释放资源的方法
 */
public class JDBCUtils_V3 {
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
        try {
//        通过当前类获取类加载器
            ClassLoader classLoader = JDBCUtils_V3.class.getClassLoader();
//        通过类加载器的方法获得一个输入流
            InputStream is = classLoader.getResourceAsStream("db.properties");
//        创建properties对象
            Properties props = new Properties();
//        加载输入流
            props.load(is);
//        获取相关参数值
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            username = props.getProperty("username");
            password = props.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }

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
