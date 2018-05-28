package com.czdpzc.service;

import com.czdpzc.dao.UserDAO;
import com.czdpzc.dao.impl.UserDaoImpl;
import com.czdpzc.entity.Users;
import com.czdpzc.entity.user;
import com.czdpzc.utill.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckUserService {

    private UserDAO userDAO = new UserDaoImpl();

    /**
     * 实现登陆检验的逻辑
     *      返回0：无用户
     *      返回1：学生用户、老师用户
     *      返回2：柜台管理员
     *      返回3：后台管理员
     * @param us
     * @return
     */
    public  Users check(Users us){
        Connection conn = null;
        Users help = new Users();
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);

            ResultSet resultSet = userDAO.get(conn,us);//遍历查询后返回查询结果


            //resultSet.next()遍历查询结果，若有记录，返回true；若无查询记录，返回false，跳出循环
            while(resultSet.next()){
//               System.out.println("=======测试========");
//               System.out.println(resultSet.getInt(1));
//               System.out.println(resultSet.getString(2));
//               System.out.println(resultSet.getString(3));

               help.setUserName(resultSet.getString(2));
               help.setPermi(resultSet.getString(5));

//               if (help.getPermi().equals("stu") || help.getPermi().equals("tea")){
//                   return 1;
//               }else if (help.getPermi().equals("rcp")){
//                   return 2;
//               }else{
//                   return 3;
//               }
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
//        return 0;
        help.setPermi("silly");
        return help;

    }




}
