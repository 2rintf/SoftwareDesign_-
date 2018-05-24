package com.czdpzc.jdbc;

import java.sql.*;

public class JDBCtest {

    /**
     * 获取数据库连接
     * @return
     */
    public static  Connection getConnection(){
        Connection conn = null;
        try {
            //注册JDBC驱动程序
            Class.forName ("com.mysql.cj.jdbc.Driver");
            //获取数据库连接(URL添加 ?serverTimezone=GMT 来解决JDBC的驱动问题)
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db?serverTimezone=GMT","root","");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }

    public static void insert(){
        Connection conn = getConnection();//连接数据库

        try {
            String sql = "INSERT INTO tbl_user(name, password,email)"+
                    "VALUES('Tom','123456','asdasd@dd.com')";
            Statement st = conn.createStatement();

            //执行前面定义的sql语句,执行dml（insert/update/delete）【返回影响的记录条数】和ddl语句【返回0】
            int count = st.executeUpdate(sql);

            System.out.println("用户向表中插入了"+count+"条记录");
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(){
        Connection conn = getConnection();//连接数据库

        try {
            String sql = "UPDATE tbl_user SET email = 'fuck u' WHERE name = 'Tom'";
            Statement st = conn.createStatement();

            //执行前面定义的sql语句,执行dml（insert/update/delete）【返回影响的记录条数】和ddl语句【返回0】
            int count = st.executeUpdate(sql);

            System.out.println("用户向表中更新了"+count+"条记录");
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void delete(){
        Connection conn = getConnection();//连接数据库

        try {
            String sql = "DELETE FROM tbl_user WHERE name = 'Tom'";
            Statement st = conn.createStatement();

            //执行前面定义的sql语句,执行dml（insert/update/delete）【返回影响的记录条数】和ddl语句【返回0】
            int count = st.executeUpdate(sql);

            System.out.println("用户向表中删除了"+count+"条记录");
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String []args){
        String sql = "SELECT * FROM tbl_user";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

//        insert();
//        update();
        delete();
//        try {
//            //注册JDBC驱动程序
//            Class.forName ("com.mysql.cj.jdbc.Driver");
//
//            //获取数据库连接(URL添加 ?serverTimezone=GMT 来解决JDBC的驱动问题)
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db?serverTimezone=GMT","root","");
//
//
//            st = conn.createStatement();//创建一个statement
//            rs = st.executeQuery(sql);//发送前面所定义的sql语句，此方法返回一个ResultSet对象
//
//            //遍历
//            while(rs.next()){
//                System.out.println(rs.getInt("id")+"  ");
//                System.out.println(rs.getString("name")+"  ");
//                System.out.println(rs.getString("password")+"  ");
//                System.out.println(rs.getString("email"));
//                System.out.println();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            //资源清理，由小到大处理
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                st.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

    }
}
