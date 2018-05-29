package com.czdpzc.service;

import com.czdpzc.dao.UserDAO;
import com.czdpzc.dao.impl.UserDaoImpl;
import com.czdpzc.entity.Users;
import com.czdpzc.utill.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class ModifyPasswordService {
    private UserDAO userDAO = new UserDaoImpl();

    public void modifyPassword(Users users){
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            userDAO.update(conn,users);

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
