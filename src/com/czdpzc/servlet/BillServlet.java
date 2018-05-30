package com.czdpzc.servlet;

import com.czdpzc.entity.Users;
import com.czdpzc.service.BillService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BillServlet")
public class BillServlet extends HttpServlet {

    private BillService bs = new BillService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Users users = new Users();
        users = (Users) (request.getSession().getAttribute("bill_us_info"));

//        users.setId(Long.parseLong(request.getParameter("bill_id")));

        RequestDispatcher rd = null;
        String forward = null;

        //将输入id的bill清零
        bs.updateBill(users);

        forward = "/gundyr/bill_success.jsp";

        rd = request.getRequestDispatcher(forward);
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
