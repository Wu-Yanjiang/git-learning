package cn.jj.jdbc.DataSource;

import cn.jj.jdbc.JDBCUtils_V4;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MyDataSource implements DataSource {
//    创建容器用于存储Connection对象
    private static LinkedList<Connection> pool = new LinkedList<Connection>();
//    创建5个连接放入容器
    static {
        for (int i=0; i<5; i++){
            Connection conn = JDBCUtils_V4.getConnection();
            pool.add(conn);
        }
    }
    //获取连接方法
    @Override
    public Connection getConnection() throws SQLException {
        Connection conn = null;
//        使用前先判断
        if (pool.size() == 0){
//            池子里没有
            for (int i=0; i<5; i++){
                conn = JDBCUtils_V4.getConnection();
                pool.add(conn);
            }
//            从池子里获取一个连接对象
        }
        conn = pool.remove(0);
        return conn;
    }
    //归还连接对象到连接池
    public void backConnection(Connection conn){
        pool.add(conn);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
