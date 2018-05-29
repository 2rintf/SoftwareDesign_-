package com.czdpzc.servlet;

import com.czdpzc.entity.Books;
import com.czdpzc.service.SearchBookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchBookServlet")
public class SearchBookServlet extends HttpServlet {
    private SearchBookService sbs = new SearchBookService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Books books = new Books();
        List<Books> search = new ArrayList<>();

        books.setBookName(request.getParameter("in_book_name"));
        books.setBookWriter(request.getParameter("in_book_writer"));
        books.setBookClass(request.getParameter("class_choose"));
        books.setBookPub(request.getParameter("in_book_pub"));

        if (books.getBookClass() == null){
            books.setBookClass("");
        }

        RequestDispatcher rd = null;
        String forward = null;


        //在tbl_book中查询
        search = sbs.search(books);

        request.getSession().setAttribute("search_book_info", search);

        forward = "/normal/search_result.jsp";
        rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
