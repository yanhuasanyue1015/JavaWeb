package com.youyou.servlet;

import com.youyou.util.Config;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by zhanglei-account on 2016/10/31.
 */
public class InitServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        ServletContext servletContext = servletConfig.getServletContext();
        Config.Encoding = servletContext.getInitParameter("encoding");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
