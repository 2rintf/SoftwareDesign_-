package com.czdpzc.servlet;

import com.czdpzc.entity.BooksBorrow;
import com.czdpzc.entity.Users;
import com.czdpzc.service.BackService;
import com.czdpzc.service.GetInfoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetUserInfoServlet")
public class GetUserInfoServlet extends HttpServlet {

    private GetInfoService gis = new GetInfoService();
//    private BackService bs = new BackService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users us = new Users();
        BooksBorrow bb = new BooksBorrow();
        String book_name = null;

        us = (Users) (request.getSession().getAttribute("user_login"));


        us.setUserName(request.getParameter("uname"));
//        gis.getuserInfo(us);




        //用户信息
//        long idHelp = Long.parseLong(request.getParameter("uid"));
//        us.setId(Long.parseLong(request.getParameter("uid")));


        RequestDispatcher rd = null;
        String forward = null;

        //getUserInfo
        us = gis.getuserInfo(us);

        //getBookInfo
        us.setList(gis.getBorrowBookInfo(bb, us));


        request.getSession().setAttribute("us_info", us);


        forward = "/normal/show_user_info.jsp";
        rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
