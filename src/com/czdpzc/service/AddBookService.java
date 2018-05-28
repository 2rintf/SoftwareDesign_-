package com.czdpzc.service;

import com.czdpzc.dao.BookDAO;
import com.czdpzc.dao.impl.BookDaoImpl;
import com.czdpzc.entity.Books;
import com.czdpzc.utill.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddBookService {

    private BookDAO bookDAO = new BookDaoImpl();

    public boolean addBook(Books books){
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            bookDAO.save(conn,books);


        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
                return false;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            try {
                conn.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public long getBookId(Books books){
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);
            long help = 0;

            ResultSet rs = bookDAO.getAddBookId(conn,books);
            while (rs.next()){
                help = rs.getLong(1);
                return help;
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
        return 0;
    }
}
