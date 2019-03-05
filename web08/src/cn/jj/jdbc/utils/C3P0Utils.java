package cn.jj.jdbc.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Utils {
    //    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("itheima");
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    //连接url里不需要端口号
    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
