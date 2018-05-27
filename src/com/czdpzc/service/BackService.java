package com.czdpzc.service;

import com.czdpzc.dao.BookIODAO;
import com.czdpzc.dao.impl.BookIOImpl;
import com.czdpzc.entity.BooksBorrow;
import com.czdpzc.entity.Users;
import com.czdpzc.utill.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class BackService {
    private BookIODAO bookIODAO = new BookIOImpl();

    public void updateBorrowIdToNull(Users us, BooksBorrow bb){
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);


            bookIODAO.updateBorrowIdToNull(conn,bb);

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

    public double computeBill(BooksBorrow bb,Users us){
        Connection conn = null;
        long day = 0;
        double bill = 0;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            Date back_date = bookIODAO.getBackDate(conn,bb);
            Date current_date = new Date(System.currentTimeMillis());

            //转换成毫秒计算，再把结果转换为天数
            day = current_date.getTime() - back_date.getTime();
            day = day/(1000 * 60 * 60 * 24);


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

        if (day<0){
            return bill;
        }else {
            bill = 0.1*day;
            return bill;
        }
    }

    public void updateBill(Users us,double bill){
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);


            bookIODAO.updateBill(conn,us,bill);

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

    public void deleteBorrowRecord(BooksBorrow bb){
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);


            bookIODAO.deleteBorrowRecord(conn,bb);

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
