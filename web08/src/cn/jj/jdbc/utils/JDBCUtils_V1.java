package cn.jj.jdbc.utils;

import java.sql.*;

/*
 *
 * @param null
  * @return
 * @author wuyanjiang
 * @date
 * @description 提供获取连接释放资源的方法
 */
public class JDBCUtils_V1 {
    /*
     *
     * @param null
      * @return
     * @author wuyanjiang
     * @date
     * @description 获取连接
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://119.28.82.234/web08", "root", "123456");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
