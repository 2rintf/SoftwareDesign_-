package com.czdpzc.servlet;

import com.czdpzc.dao.UserDAO;
import com.czdpzc.entity.BooksBorrow;
import com.czdpzc.entity.Users;
import com.czdpzc.service.ModifyPasswordService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifyPasswordServlet")
public class ModifyPasswordServlet extends HttpServlet {

    private ModifyPasswordService mps = new ModifyPasswordService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users us = new Users();
        RequestDispatcher rd = null;
        String forward = null;

        us = (Users) (request.getSession().getAttribute("user_login"));

//        us.setPassWord(request.getParameter("old_password"));

        String newPassword = request.getParameter("new_password_1");
        us.setPassWord(newPassword);

        //更新user_tbl的用户密码
        mps.modifyPassword(us);

        forward = "/normal/modify_success.jsp";
        rd = request.getRequestDispatcher(forward);
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
