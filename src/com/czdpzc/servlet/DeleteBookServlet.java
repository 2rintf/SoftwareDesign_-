package com.czdpzc.servlet;

import com.czdpzc.entity.Books;
import com.czdpzc.entity.BooksBorrow;
import com.czdpzc.service.BorrowService;
import com.czdpzc.service.DeleteBookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {

    private DeleteBookService dbs = new DeleteBookService();
    private BorrowService bs = new BorrowService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Books books = new Books();
        BooksBorrow booksBorrow = new BooksBorrow();
        books.setId(Long.parseLong(request.getParameter("delete_book_id")));
        booksBorrow.setId(Long.parseLong(request.getParameter("delete_book_id")));

        RequestDispatcher rd = null;
        String forward = null;

        //先查询是否有这本书
        if (!(bs.ifBookExist(booksBorrow))){
            forward = "/god/delete_book_error.jsp";
        }else{
            //确认删除后，从tbl_book表中删除此纪录
            dbs.deleteBook(books);
            forward = "/god/delete_book_success.jsp";

        }

        rd = request.getRequestDispatcher(forward);
        rd.forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
