package com.czdpzc.service;

import com.czdpzc.dao.BookDAO;
import com.czdpzc.dao.BookIODAO;
import com.czdpzc.dao.impl.BookDaoImpl;
import com.czdpzc.dao.impl.BookIOImpl;
import com.czdpzc.entity.BooksBorrow;
import com.czdpzc.entity.Users;
import com.czdpzc.utill.ConnectionFactory;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BorrowService {
    private BookIODAO bookIODAO = new BookIOImpl();

//    private BookDAO bk = new BookDaoImpl();

    public void updateBorrowId(Users us, BooksBorrow bb){
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            bookIODAO.updateBorrowId(conn,bb,us);

            conn.commit();


        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void insertBorrowRecord(Users us,BooksBorrow bb){
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            bookIODAO.insertBorrowRecord(conn,bb,us);

            conn.commit();


        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public BooksBorrow getBookName(BooksBorrow bb){
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            ResultSet rs = bookIODAO.getBorrowBookName(conn,bb);
            while (rs.next()){
                bb.setBook_name(rs.getString(1));
            }



        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return bb;
    }
}

