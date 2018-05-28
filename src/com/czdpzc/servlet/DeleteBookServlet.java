package com.czdpzc.servlet;

import com.czdpzc.entity.Books;
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Books books = new Books();
        books.setId(Long.parseLong(request.getParameter("delete_book_id")));

        RequestDispatcher rd = null;
        String forward = null;

        //先查询是否有这本书

        //确认删除后，从tbl_book表中删除此纪录


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
