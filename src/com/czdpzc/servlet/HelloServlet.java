package com.czdpzc.servlet;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet{

    @Override
    public void init() throws ServletException {
        System.out.println("=============init without parmeters=============");
        super.init();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("=============init with parameters==============");
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("============service=============");

        //向客户端浏览器发送字符串
        PrintWriter pw = resp.getWriter();
        pw.println("Hello World");
        pw.close();
    }

    @Override
    public void destroy() {
        //进行一些资源释放和日志记录
        System.out.println("=============destroy=============");
        super.destroy();
    }

}
