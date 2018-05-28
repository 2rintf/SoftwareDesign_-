package com.czdpzc.servlet;

import com.czdpzc.entity.Books;
import com.czdpzc.service.AddBookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "AddBookServlet")
public class AddBookServlet extends HttpServlet {
    private AddBookService abs = new AddBookService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Books books = new Books();
        Date add_date = new Date(System.currentTimeMillis());
        long add_book_id = 0;

        books.setBookName(request.getParameter("in_book_name"));
        books.setBookWriter(request.getParameter("in_book_writer"));
        books.setBookClass(request.getParameter("class_choose"));
        books.setBookPub(request.getParameter("in_book_pub"));
        books.setAddBookDate(add_date);


        RequestDispatcher rd = null;
        String forward = null;

        //在tbl_book中insert图书
        if (abs.addBook(books)){
            forward = "/god/add_book_success.jsp";

            add_book_id = abs.getBookId(books);

            books.setId(add_book_id);

        }else {
            forward = "/god/add_book_error.jsp";
        }

        rd = request.getRequestDispatcher(forward);
        rd.forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
