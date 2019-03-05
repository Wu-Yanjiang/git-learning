package cn.jj.jdbc.test;

import cn.jj.jdbc.utils.DBCPUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBCPUtilsTest {

    @Test
    public void testUpdatedUserById(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBCPUtils.getConnection();
            String sql = "update tbl_user set upassword=? where uid=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "吕布");
            pstmt.setInt(2, 5);
            int rows = pstmt.executeUpdate();
            if (rows>0){
                System.out.println("更新成功");
            }else {
                System.out.println("失败");
            }
        }catch (Exception e){

        }
    }
}