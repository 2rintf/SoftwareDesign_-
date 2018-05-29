package com.czdpzc.servlet;

import com.czdpzc.entity.BooksBorrow;
import com.czdpzc.entity.Users;
import com.czdpzc.service.BackService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "BackServlet")
public class BackServlet extends HttpServlet {
    private BackService bs = new BackService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Users us = (Users) (request.getSession().getAttribute("us_info"));
        BooksBorrow bb = new BooksBorrow();

        bb.setId(Long.parseLong(request.getParameter("back_book_id")));

        String forward = "gg";
        RequestDispatcher rd = null;

        if (us.getList().size() == 0){
            forward = "/gundyr/can_not_back.jsp";
        }else {

            List<BooksBorrow> list = us.getList();
            BooksBorrow help = new BooksBorrow();

            Iterator it = list.iterator();

            while (it.hasNext()){
                help = (BooksBorrow) (it.next());

                if (help.getId() == bb.getId()){
                    //更新总图书表的借阅标记borrow_id
                    bs.updateBorrowIdToNull(us, bb);
                    //获取应归还日期，与今日日期比较，计算bill
                    double bill = bs.computeBill(bb, us);
                    //更新用户表的bill
                    bs.updateBill(us, bill);
                    //删除借阅表中的借阅记录，根据book_id
                    bs.deleteBorrowRecord(bb);

                    forward = "/gundyr/back_success.jsp";
                }
            }

            if (forward.equals("gg")){
                forward = "/gundyr/back_error.jsp";
            }


        }

        rd = request.getRequestDispatcher(forward);
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
