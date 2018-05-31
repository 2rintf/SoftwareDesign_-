package com.czdpzc.dao;

import com.czdpzc.entity.Users;
import com.czdpzc.utill.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDAO {

    //定义接口
    public void save(Connection conn,Users user) throws SQLException;

    public void update(Connection conn,Users user) throws SQLException;

    public void billUpdate(Connection conn,Users users) throws SQLException;

    public void delete(Connection conn,Users user) throws SQLException;

    public ResultSet get(Connection conn,Users user) throws SQLException;

    public ResultSet getUserInfo(Connection conn, Users user) throws SQLException;

    public ResultSet getAddUserId(Connection conn, Users user) throws SQLException;


}
