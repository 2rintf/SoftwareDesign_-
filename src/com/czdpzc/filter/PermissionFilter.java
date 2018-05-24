package com.czdpzc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "PermissionFilter")
public class PermissionFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse)resp;

        //获取请求中的ServletPath
        String servletPath = request.getServletPath();

        //获取Session对象中flag的值
        HttpSession session = request.getSession();
        String flag = (String)session.getAttribute("flag");

        //如果用户访问的是index、login或者执行登陆操作，则把请求转发给下一个组件进行处理
        if (servletPath != null && (servletPath.equals("/15/login.jsp"))) {

            chain.doFilter(request, response);

        }

        //进行权限校验
        else{
            if (flag != null && (flag.equals("login_success_normal") || flag.equals("login_success_gundyr") || flag.equals("login_success_god"))){
                chain.doFilter(request, response);
            }else if (flag != null && flag.equals("login_error")){
                request.setAttribute("msg","登陆失败，请重新登陆！<br>");
//                request.setAttribute("return_uri",servletPath);
                RequestDispatcher rd = request.getRequestDispatcher("/15/login.jsp");
                rd.forward(request,response);
            }else{
                request.setAttribute("msg","尚未登陆！<br>");
//                request.setAttribute("return_uri",servletPath);
                RequestDispatcher rd = request.getRequestDispatcher("/15/login.jsp");
                rd.forward(request,response);
            }
        }


    }



}
