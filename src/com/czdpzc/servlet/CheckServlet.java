package com.czdpzc.servlet;

import com.czdpzc.entity.Users;
import com.czdpzc.entity.user;
import com.czdpzc.service.CheckUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 此servlet实现控制器的效果，根据CheckUserService的校验返回值，把用户导至相应页面
 */
@WebServlet(name = "CheckServlet")
public class CheckServlet extends HttpServlet {
    private CheckUserService check = new CheckUserService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取表单信息
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");

        String returnUri =request.getParameter("return_uri");

        RequestDispatcher rd = null;
        String forward = null;

        if (uname == null || upwd == null){
            request.setAttribute("msg","用户名或密码为空！");
            rd = request.getRequestDispatcher("/15/error.jsp");
            rd.forward(request,response);
        }
        else{
            Users us = new Users();
            us.setUserName(uname);
            us.setPassWord(upwd);

            int permission = check.check(us);

            if (permission == 1) {
                forward = "/normal/index_normal.jsp";
                request.getSession().setAttribute("flag","login_success_normal");
            } else if (permission == 2) {
                forward = "/gundyr/index_gundyr.jsp";
                request.getSession().setAttribute("flag","login_success_gundyr");
            } else if (permission == 3) {
                forward = "/god/index_god.jsp";
                request.getSession().setAttribute("flag","login_success_god");
            } else {
                request.setAttribute("msg", "用户名或者密码错误！请重新登陆");
                request.getSession().setAttribute("flag","login_error");
                forward = "/15/login.jsp";
            }

            rd  =request.getRequestDispatcher(forward);
            rd.forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
