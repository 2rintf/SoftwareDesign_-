package com.czdpzc.servlet;

import com.czdpzc.entity.Users;
import com.czdpzc.service.AddUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddUserServlet")
public class AddUserServlet extends HttpServlet {

    private AddUserService aus = new AddUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users users = new Users();
        Date help = new Date(System.currentTimeMillis());
        long add_user_id = 0;

        users.setUserName(request.getParameter("in_user_name"));
        users.setPermi(request.getParameter("class_choose"));
        users.setAddDate(help);
        users.setPassWord("999999");


        RequestDispatcher rd = null;
        String forward = null;


        //在user_tbl中insert新的用户信息,获取新用户的ID
        if (aus.addUser(users)){
            forward = "/god/add_user_success.jsp";

            add_user_id = aus.getAddUserId(users);

            users.setId(add_user_id);
            request.getSession().setAttribute("add_user_info",users);

        }else{
            forward = "/god/add_user_error.jsp";
        }

        rd = request.getRequestDispatcher(forward);
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
