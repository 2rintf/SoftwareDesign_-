package com.czdpzc.service;

import com.czdpzc.dao.BookDAO;
import com.czdpzc.dao.impl.BookDaoImpl;
import com.czdpzc.entity.Books;
import com.czdpzc.utill.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteBookService {

    private BookDAO bookDAO = new BookDaoImpl();

    public void deleteBook(Books books){

        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            bookDAO.delete(conn,books);


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

}
