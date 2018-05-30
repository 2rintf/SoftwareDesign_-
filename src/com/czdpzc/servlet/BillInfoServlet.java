package com.czdpzc.servlet;

import com.czdpzc.entity.BooksBorrow;
import com.czdpzc.entity.Users;
import com.czdpzc.service.GetInfoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BillInfoServlet")
public class BillInfoServlet extends HttpServlet {

    private GetInfoService gis = new GetInfoService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users us = new Users();
        BooksBorrow bb = new BooksBorrow();
//        String book_name = null;
        //用户信息
        us.setId(Long.parseLong(request.getParameter("uid")));


        RequestDispatcher rd = null;
        String forward = null;

        //getUserInfo
        us = gis.getuserInfo(us);

        //getBookInfo
//        us.setList(gis.getBorrowBookInfo(bb, us));


        request.getSession().setAttribute("bill_us_info", us);
//        //是否还要传bookborrow???
//        request.getSession().setAttribute("borrow_book_info", bb);

        forward = "/gundyr/bill_manage2.jsp";
        rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
