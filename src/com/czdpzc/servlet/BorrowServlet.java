package com.czdpzc.servlet;

import com.czdpzc.dao.BookDAO;
import com.czdpzc.entity.Books;
import com.czdpzc.entity.BooksBorrow;
import com.czdpzc.entity.Users;
import com.czdpzc.service.BorrowService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

@WebServlet(name = "BorrowServlet")
public class BorrowServlet extends HttpServlet {

    private BorrowService bs = new BorrowService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users us = (Users) (request.getSession().getAttribute("us_info"));
        BooksBorrow bb = new BooksBorrow();

        bb.setId(Long.parseLong(request.getParameter("borrow_book_id")));

        //查询要借阅的图书的信息,并在bb中存储book_name
        bb.setBook_name(bs.getBookName(bb).getBook_name());

        String forward = null;
        RequestDispatcher rd = null;


        //学生借3本60天，老师借5本90天
        if (us.getPermi().equals("stu")){
            if (us.getBill() >=20 || us.getList().size() == 3){
                forward = "/gundyr/can_not_borrow.jsp";
            }
            else {
                //注意此处是已知要借阅的书的id！！！

                //查询图书是否可借（后期实现）


                //存储借阅日期与应归还日期
                java.util.Date date = new java.util.Date(System.currentTimeMillis());
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.DAY_OF_MONTH,60);
                date  =cal.getTime();
                Date backDate = new Date(date.getTime());

                bb.setBorrow_date(new Date(System.currentTimeMillis()));
                bb.setBack_date(backDate);

                //更新图书表的借阅人id
                bs.updateBorrowId(us,bb);

                //借阅图书表插入借阅信息
                bs.insertBorrowRecord(us,bb);

                //返回结果提示
                forward = "/gundyr/borrow_success.jsp";
            }
        }else {
            if (us.getBill() >=20 || us.getList().size() == 5){
                forward = "/gundyr/can_not_borrow.jsp";
            } else { //注意此处是已知要借阅的书的id！！！
                //查询要借阅的图书的信息


                //查询图书是否可借（后期实现）


                //存储借阅日期与应归还日期
                java.util.Date date1 = new java.util.Date(System.currentTimeMillis());
                Calendar cal = Calendar.getInstance();
                cal.setTime(date1);
                cal.add(Calendar.DAY_OF_MONTH, 90);
                date1 = cal.getTime();
                Date backDate1 = new Date(date1.getTime());

                bb.setBorrow_date(new Date(System.currentTimeMillis()));
                bb.setBack_date(backDate1);

                //更新图书表的借阅人id
                bs.updateBorrowId(us, bb);

                //借阅图书表插入借阅信息
                bs.insertBorrowRecord(us, bb);

            //返回结果提示
            forward = "/gundyr/borrow_success.jsp";
            }

        }

        rd = request.getRequestDispatcher(forward);
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
