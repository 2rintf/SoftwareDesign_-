package com.czdpzc.service;

import com.czdpzc.dao.BookDAO;
import com.czdpzc.dao.BookIODAO;
import com.czdpzc.dao.UserDAO;
import com.czdpzc.dao.impl.BookDaoImpl;
import com.czdpzc.dao.impl.BookIOImpl;
import com.czdpzc.dao.impl.UserDaoImpl;
import com.czdpzc.entity.BooksBorrow;
import com.czdpzc.entity.Users;
import com.czdpzc.utill.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GetInfoService {


    private UserDAO userDAO = new UserDaoImpl();
    private BookIODAO bookIODAO = new BookIOImpl();
    private BookDAO bookDAO = new BookDaoImpl();


    /**
     * 获取用户非敏感信息的服务，返回存好信息的Users对象
     * @param us
     * @return
     */
    public Users getuserInfo(Users us){
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);


            ResultSet resultSet = userDAO.getUserInfo(conn,us);
            while(resultSet.next()) {
                us.setUserName(resultSet.getString(1));
                us.setBill(resultSet.getLong(2));
                us.setPermi(resultSet.getString(3));
            }
            return us;


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
        return null;
    }

    /**
     * 查询已借阅图书信息
     * @param bb
     * @return
     */
    public List<BooksBorrow> getBorrowBookInfo(BooksBorrow bb, Users us){
        Connection conn = null;
        List<BooksBorrow> list = new ArrayList<>();
        BooksBorrow help = null;

        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            ResultSet resultSet = bookDAO.getInfoFromBorrow(conn,bb,us);

            while(resultSet.next()){

                help = new BooksBorrow();

                help.setBook_name(resultSet.getString(1));
                help.setBorrow_date(resultSet.getDate(2));
                help.setBack_date(resultSet.getDate(3));
                help.setId(resultSet.getLong(4));

                list.add(help);

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

        return list;
    }
}
