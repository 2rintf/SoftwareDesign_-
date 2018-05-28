package com.czdpzc.service;

import com.czdpzc.dao.UserDAO;
import com.czdpzc.dao.impl.UserDaoImpl;
import com.czdpzc.entity.Users;
import com.czdpzc.utill.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddUserService {

    private UserDAO userDAO = new UserDaoImpl();

    public boolean addUser(Users users) {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);


            userDAO.save(conn, users);


            conn.commit();


        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                return false;
            }
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public long getAddUserId(Users users) {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            long help = 0;

            ResultSet rs = userDAO.getAddUserId(conn, users);

            while (rs.next()) {
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
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }


        return 0;
    }
}
