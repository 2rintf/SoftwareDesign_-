package com.czdpzc.servlet;

import com.czdpzc.entity.Users;
import com.czdpzc.service.DeleteBookService;
import com.czdpzc.service.DeleteUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {

    private DeleteUserService dus = new DeleteUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users users = new Users();
        RequestDispatcher rd = null;
        String forward = null;

        users.setId(Long.parseLong(request.getParameter("delete_user_id")));

        //查询是否有这个用户
       if(!(dus.ifUserExist(users))) {
           forward = "/god/delete_user_error.jsp";
       }else {

           //删除user_tbl的用户
           dus.deleteUser(users);

           forward = "/god/delete_user_success.jsp";

       }
        rd = request.getRequestDispatcher(forward);
        rd.forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
