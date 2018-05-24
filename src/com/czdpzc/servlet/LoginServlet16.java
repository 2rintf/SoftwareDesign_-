package com.czdpzc.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet16")
public class LoginServlet16 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("uname");
        String password = request.getParameter("upwd");
        System.out.println("=============doPost测试=================");

        System.out.println("用户名 ==》" + userName);
        System.out.println("密码 ==》" + password);

        String forward = null;

        if (userName.equals("陈科比") && password.equals("000000")){
            //将请求转发至另一个jsp
            forward = "/16/success.jsp";


            RequestDispatcher rd = request.getRequestDispatcher(forward);
            rd.forward(request,response);//将这两个对象转发给另一个jsp

        }
        else {
            //请求转发
            forward = "/16/error.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(forward);
            rd.forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
