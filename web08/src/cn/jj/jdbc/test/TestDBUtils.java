package cn.jj.jdbc.test;

import cn.jj.jdbc.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;

public class TestDBUtils {


    @Test
    public void testAddUer() {
        try {
            //创建核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
//        编写SQL语句
            String sql = "insert into tbl_user values(null, ?, ?)";
//        为占位符设置参数
            Object[] params = {"余淮", "耿耿"};
//        执行添加操作
            int rows = qr.update(sql, params);
            if (rows>0){
                System.out.println("添加成功");
            }else {

                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

