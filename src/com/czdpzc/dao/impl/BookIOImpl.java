package com.czdpzc.dao.impl;

import com.czdpzc.dao.BookIODAO;
import com.czdpzc.entity.Books;
import com.czdpzc.entity.BooksBorrow;
import com.czdpzc.entity.Users;

import java.awt.print.Book;
import java.sql.*;

public class BookIOImpl implements BookIODAO{
    @Override
    public void updateBorrowId(Connection conn, BooksBorrow bb, Users user) throws SQLException {

        String sql = "UPDATE tbl_book SET borrow_id = ? WHERE book_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setLong(1,user.getId());
        ps.setLong(2,bb.getId());

        ps.execute();
    }

    /**
     * 需要的变量：图书ID、用户ID、图书借阅日期、可借阅日期（由user查表得到）
     * @param conn
     * @param bb
     * @param user
     * @throws SQLException
     */
    @Override
    public void insertBorrowRecord(Connection conn, BooksBorrow bb, Users user) throws SQLException {

        //insert into tbl_user (name,password,email,date,date_back) values("kobe", "24242424","kobe@24.com",now(),date_add(now(),interval 5 day));
        String sql = "INSERT INTO tbl_borrow (book_id, user_id, borrow_date, back_date) VALUES (?,?,?,date_add(?,INTERVAL ? DAY ))";

        int day = 0;
        if (user.getPermi().equals("stu")){
            day = 60;
        }else{
            day = 90;
        }

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setLong(1,bb.getId());
        ps.setLong(2,user.getId());
        ps.setDate(3,bb.getBorrow_date());
        ps.setDate(4,bb.getBorrow_date());
        ps.setInt(5,day);

        ps.execute();

    }

    @Override
    public Date getBackDate(Connection conn, BooksBorrow bb) throws SQLException {
        return null;
    }

    @Override
    public void updateBill(Connection conn, Users user, double bill) throws SQLException {

    }

    @Override
    public void deleteBorrowRecord(Connection conn, BooksBorrow bb) throws SQLException {

    }
}
