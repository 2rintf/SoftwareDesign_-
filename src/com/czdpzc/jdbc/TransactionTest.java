package com.czdpzc.jdbc;

import com.czdpzc.jdbc.JDBCtest;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.czdpzc.jdbc.JDBCtest.getConnection;

/**
 * 事务管理
 * 保存Tom的用户信息和地址信息，插入数据时，认为造成异常，观察程序效果
 */
public class TransactionTest {

    public static void insertUserData(Connection conn) throws SQLException {
//        Connection conn = getConnection();

//        try {
        String sql = "INSERT INTO tbl_user(id,name,password,email) VALUE(10,'Tom','123456','asdasd@wow.com')";
        Statement st = conn.createStatement();

        int count = st.executeUpdate(sql);
        System.out.println("向用户表插入了" + count + "条记录");
//            conn.close();

//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void insertAddressData(Connection conn) throws SQLException{
//        Connection conn = getConnection();

//        try {
            String sql = "INSERT INTO tbl_address(id,city,country,user_id) VALUE(1,'Shanghai','China','10')";
            Statement st = conn.createStatement();

            int count = st.executeUpdate(sql);
            System.out.println("向用户表插入了"+count+"条记录");
//            conn.close();

//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    public static void main(String []args){
        Connection conn = null;

        try {
            conn = getConnection();
            conn.setAutoCommit(false);//禁止事务的自动提交

            insertUserData(conn);
            insertAddressData(conn);

            conn.commit();//事务提交
        } catch (SQLException e) {
            System.out.println("==============捕获SQL异常==============");
            e.printStackTrace();

            try {
                conn.rollback();
                System.out.println("=============事务回滚成功================");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }finally {

            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

}
