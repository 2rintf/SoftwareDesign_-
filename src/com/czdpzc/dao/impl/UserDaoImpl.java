package com.czdpzc.dao.impl;

import com.czdpzc.dao.UserDAO;
import com.czdpzc.entity.Users;


import java.sql.*;


/**
 * 对UserDao接口的具体实现类，DAO类
 */
public class UserDaoImpl implements UserDAO {


    /**
     * 新建并保存用户信息
     * 添加姓名、权限
     * 后台管理员使用
     *
     * @param conn
     * @param user
     * @throws SQLException
     */
    @Override
    public void save(Connection conn, Users user) throws SQLException {

        String sql = "INSERT INTO user_tbl(user_name,permission,add_date,password) VALUES (?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getPermi());
        ps.setDate(3, user.getAddDate());
        ps.setString(4,user.getPassWord());

        ps.execute();//执行

    }

    /**
     * 更新用户密码
     *      用于普通用户修改密码
     *
     * @param conn
     * @param id
     * @param user
     * @throws SQLException
     */
    @Override
    public void update(Connection conn, Users user) throws SQLException {

        String sql = "UPDATE user_tbl SET password = ? WHERE user_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);


        ps.setString(1, user.getPassWord());
        ps.setLong(2, user.getId());

        ps.execute();//执行
    }


    /**
     * 根据ID更新用户欠款信息
     * 更新欠款字段
     *
     * @param conn
     * @param id
     * @throws SQLException
     */
    public void billUpdate(Connection conn, long id) throws SQLException {
        String sql = "UPDATE user_tbl SET bill = 0 WHERE user_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, id);

        ps.execute();

    }

    /**
     * 根据ID删除指定用户的信息
     *
     * @param conn
     * @param user
     * @throws SQLException
     */
    @Override
    public void delete(Connection conn, Users user) throws SQLException {
        String deleteSql = "DELETE FROM user_tbl WHERE user_id = ?";
        PreparedStatement ps = conn.prepareStatement(deleteSql);

        ps.setLong(1, user.getId());
        ps.execute();

    }


    /**
     * 验证登陆用户
     *
     * @param conn
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public ResultSet get(Connection conn, Users user) throws SQLException {


        String sql = "SELECT * FROM user_tbl WHERE user_id = ? AND password = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, user.getId());
        ps.setString(2, user.getPassWord());


        return ps.executeQuery();//执行遍历查询，返回查询结果
    }


    /**
     * 通过user_id获取用户非敏感信息，存入user对象，用于借还书操作
     *
     * @param conn
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public ResultSet getUserInfo(Connection conn, Users user) throws SQLException {

        String sql = "SELECT user_name,bill,permission FROM user_tbl WHERE user_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, user.getId());

        return ps.executeQuery();
    }


    @Override
    public ResultSet getAddUserId(Connection conn, Users user) throws SQLException {
        String sql = "SELECT user_id FROM user_tbl WHERE user_name = ? AND add_date = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getUserName());
        ps.setDate(2, user.getAddDate());

        return ps.executeQuery();
    }
}
