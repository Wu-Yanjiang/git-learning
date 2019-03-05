package cn.jj.jdbc.test;

import cn.jj.jdbc.utils.C3P0Utils;
import cn.jj.jdbc.utils.JDBCUtils_V4;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestC3P0 {
    /**
     *
     */
    @Test
    public void testAddUser1() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
//            从池子获取连接对象
            conn = C3P0Utils.getConnection();
            String sql = "insert into tbl_user values(null,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "吕布6");
            pstmt.setString(2, "貂蝉6");
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_V4.release(conn, pstmt, null);
        }
    }


    /**
     * 使用未改造过的Connection
     */
    @Test
    public void testAddUser() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //ComboPooledDataSource dataSource = new ComboPooledDataSource("itheima");
        try {
//            从池子获取连接对象
            conn = dataSource.getConnection();
            String sql = "insert into tbl_user values(null,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "吕布4");
            pstmt.setString(2, "貂蝉4");
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_V4.release(conn, pstmt, null);
        }
    }
}
