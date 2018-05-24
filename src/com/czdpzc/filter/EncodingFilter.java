package com.czdpzc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 设置统一的编码过滤器UTF-8，解决中文输入的乱码问题
 */
@WebFilter(filterName = "EncodingFilter")
public class EncodingFilter implements Filter {

    private String charEncoding = null;


    public void init(FilterConfig config) throws ServletException {
        charEncoding = config.getInitParameter("encoding");
        if (charEncoding == null){
            throw new ServletException("EncodingFilter中的编码设置为空！");

        }
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (!charEncoding.equals(req.getCharacterEncoding())){
            req.setCharacterEncoding(charEncoding);
        }
        resp.setCharacterEncoding(charEncoding);

        chain.doFilter(req, resp);
    }



}
