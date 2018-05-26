package com.czdpzc.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @deprecated
 * 此SERVLET的逻辑为：
 *      1.获取表单输入内容，如果为空，跳login；不为空，则比较是否匹配
 *      2.若不匹配，设立login_error的flag，并跳转回login
 *      3.若匹配，则设立login_success的flag。然后判断returnUri，若为空，跳至index；
 *              不为空，跳至returnUri指定的页面
 */
@WebServlet(name = "LoginServlet17")
public class LoginServlet17 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        String returnUri = request.getParameter("return_uri");

        System.out.println("用户名："+uname);
        System.out.println("密码:"+ upwd);
        System.out.println("return uri:"+ returnUri);

        RequestDispatcher rd = null;
        if (uname == null||upwd == null){
            request.setAttribute("msg","用户名或密码为空<br>");
            rd = request.getRequestDispatcher("/17/login.jsp");
            rd.forward(request,response);
        }
        else{
            if (uname.equals("陈科比") && upwd.equals("000000")){

                //登陆成功后，存储一个flag，表明用户的登陆状态
                request.getSession().setAttribute("flag","login_success");
                if (returnUri != null){
                    rd = request.getRequestDispatcher(returnUri);
                    rd.forward(request,response);
                }
                else {
                    rd = request.getRequestDispatcher("/17/index.jsp");
                    rd.forward(request,response);
                }
            }
            else{
                request.getSession().setAttribute("flag","login_error");
                request.setAttribute("msg","用户名或密码输入错误！");
                rd = request.getRequestDispatcher("/17/login.jsp");
                rd.forward(request,response);
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
