package cn.jj.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3O0Utils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("itheima");

    public static ComboPooledDataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}
