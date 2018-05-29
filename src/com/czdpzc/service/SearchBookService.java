package com.czdpzc.service;

import com.czdpzc.dao.BookDAO;
import com.czdpzc.dao.impl.BookDaoImpl;
import com.czdpzc.entity.Books;
import com.czdpzc.utill.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchBookService {

    private BookDAO bookDAO = new BookDaoImpl();


    public List<Books> search(Books books){

        Connection conn = null;
        Books help = null;
        List<Books> list = new ArrayList<>();
        long bool = 0;

        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            ResultSet rs = bookDAO.get(conn, books);


            while (rs.next()){
                help = new Books();
                help.setId(rs.getLong(1));
                help.setBookName(rs.getString(2));
                help.setBookClass(rs.getString(3));
//                bool = rs.getLong(4);
                help.setBookPub(rs.getString(5));
                help.setBookWriter(rs.getString(6));


                if (rs.getLong(4) == 0 ){
                        help.setIfBorrow(true);
                }else{
                    help.setIfBorrow(false);
                }

                list.add(help);

            }
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


        return list;
    }




}
