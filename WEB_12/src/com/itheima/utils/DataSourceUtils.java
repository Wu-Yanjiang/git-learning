package com.itheima.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceUtils {
    private static DataSource dataSource = new ComboPooledDataSource();
    private static ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();

    //获取连接池
    public static DataSource getDataSource(){
        return dataSource;
    }

    //获取连接对象
    public static Connection getConnection() throws SQLException{
        Connection conn = t1.get();
        if (conn == null){
            conn = dataSource.getConnection();
            t1.set(conn);
        }
        return conn;
    }
}
