package com.czdpzc.servlet;

import com.czdpzc.entity.Users;

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
 * @author czdpzc
 */
@WebServlet(name = "CheckServlet")
public class CheckServlet extends HttpServlet {
    private CheckUserService check = new CheckUserService();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取表单信息
//        String uname = request.getParameter("uname");
        long login_id = 0;
        login_id = Long.parseLong(request.getParameter("login_id"));
        String upwd = request.getParameter("upwd");







        String returnUri =request.getParameter("return_uri");

        RequestDispatcher rd = null;
        String forward = null;

        if (login_id== 0 || upwd == null){
            request.setAttribute("msg","ID或密码为空！");
            rd = request.getRequestDispatcher("/15/error.jsp");
            rd.forward(request,response);
        }
        else{
            Users us = new Users();
            us.setId(login_id);
            us.setPassWord(upwd);
            int permission = 0;


            us = check.check(us);
            us.setId(login_id);
            //用于欢迎界面显示用户名字
            request.getSession().setAttribute("uname",us.getUserName());

            if (us.getPermi().equals("stu") || us.getPermi().equals("tea")){
                  permission = 1;
               }else if (us.getPermi().equals("rcp")){
                   permission = 2;
               }else if (us.getPermi().equals("god")){
                   permission = 3;
               }
               else {
                permission = 4;
            }

            if (permission == 1) {
                forward = "/normal/index_normal.jsp";
                request.getSession().setAttribute("flag","login_success_normal");

                //将登陆用户的信息放在session可供调用，主要是用于学生和老师用户的查询界面
                request.getSession().setAttribute("user_login",us);

            } else if (permission == 2) {
                forward = "/gundyr/index_gundyr.jsp";
                request.getSession().setAttribute("flag","login_success_gundyr");
                request.getSession().setAttribute("user_login",us);
            } else if (permission == 3) {
                forward = "/god/index_god.jsp";
                request.getSession().setAttribute("flag","login_success_god");
                request.getSession().setAttribute("user_login",us);
            } else {
                request.setAttribute("msg", "用户名或者密码错误！请重新登陆");
                request.getSession().setAttribute("flag","login_error");
                forward = "/15/error.jsp";
            }

            rd  =request.getRequestDispatcher(forward);
            rd.forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
