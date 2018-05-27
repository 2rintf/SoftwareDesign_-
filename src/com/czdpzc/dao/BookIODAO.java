package com.czdpzc.dao;

import com.czdpzc.entity.BooksBorrow;
import com.czdpzc.entity.Users;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface BookIODAO {

    /**
     * 借书用方法
     * @param conn
     * @param bb
     * @param user
     * @throws SQLException
     */
    public void updateBorrowId(Connection conn, BooksBorrow bb, Users user) throws SQLException;


    public void insertBorrowRecord(Connection conn, BooksBorrow bb, Users user) throws SQLException;

    /**
     * 还书用方法
     * 避免使用user_id来寻找，因为一个用户可以借多本书，所以使用BooksBorrow的ID
     * @param conn
     * @param bb
     * @return
     */
    public Date getBackDate(Connection conn, BooksBorrow bb) throws SQLException;

    public void updateBill(Connection conn, Users user, double bill) throws SQLException;

    public void deleteBorrowRecord(Connection conn, BooksBorrow bb) throws SQLException;

    public boolean ifBookCanBorrow(Connection conn, BooksBorrow bb) throws SQLException;

    public ResultSet getBorrowBookName(Connection conn, BooksBorrow bb) throws SQLException;
}
