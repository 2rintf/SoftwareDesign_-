package com.czdpzc.utill;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * @author czdpzc
 * 工具类，用于与数据库建立连接
 * 使用前，新建或修改 dbconfig.properties 文件，添加以下键值对：@driver、@dburl、@user、@password
 * 使用：
 *      1.getInstance()获取实例；
 *      2.makeConnection()建立连接
 *
 */
public class ConnectionFactory {

    private static String driver;
    private static String dburl;
    private static String user;
    private static String password;

    private  static final ConnectionFactory factory = new ConnectionFactory();

    private Connection conn;

    //静态代码块来从属性文件中读取配置信息
    //静态代码块用于初始化类，
    static{
        Properties prop = new Properties();

        try {
            InputStream in = ConnectionFactory.class
                    .getClassLoader().getResourceAsStream("dbconfig.properties");
            prop.load(in);//从输入流中中读取键值对
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = prop.getProperty("driver");
        dburl = prop.getProperty("dburl");
        user = prop.getProperty("user");
        password = prop.getProperty("password");

    }

    private ConnectionFactory(){

    }

    /**
     * 获取一个ConnectionFactory的实例，保证每一次只有一个实例
     * @return factory
     */
    public static ConnectionFactory getInstance(){
        return factory;
    }

    /**
     * 建立与数据库的连接
     * @return conn
     */
    public Connection makeConnection(){
        try {
            //注册JDBC驱动程序
            Class.forName (driver);
            //获取数据库连接(URL添加 ?serverTimezone=GMT 来解决JDBC的驱动问题)
            conn = DriverManager.getConnection(dburl,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }
}
