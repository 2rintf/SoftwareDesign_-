package com.czdpzc.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userName = req.getParameter("uname");
//        String password = req.getParameter("upwd");
//        System.out.println("=============测试=================");
//
//        System.out.println("用户名 ==》" + userName);
//        System.out.println("密码 ==》" + password);
//    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //使doGet转换为doPost执行，更安全，不会明文显示
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("uname");
        String password = req.getParameter("upwd");
        System.out.println("=============doPost测试=================");

        System.out.println("用户名 ==》" + userName);
        System.out.println("密码 ==》" + password);

        String forward = null;



        if (userName.equals("123") && password.equals("321")){
            //将请求转发至另一个jsp
            forward = "/login/success.jsp";
//            forward = "index.jsp";

            RequestDispatcher rd = req.getRequestDispatcher(forward);
            rd.forward(req,resp);//将这两个对象转发给另一个jsp


            //请求重定向，但无法转发表单信息
//            resp.sendRedirect(req.getContextPath()+"/login/success.jsp");
        }
        else {
            //请求转发
            forward = "/login/error.jsp";
            RequestDispatcher rd = req.getRequestDispatcher(forward);
            rd.forward(req,resp);

//            resp.sendRedirect(req.getContextPath()+"/login/error.jsp");
        }
    }


}
