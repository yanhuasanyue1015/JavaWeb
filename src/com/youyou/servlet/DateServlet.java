package com.youyou.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;

/**
 * Created by zhanglei-account on 2016/10/31.
 */
public class DateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*
        Cache-Control:no-cache
        Expireds:-1(非常特殊,转换特定日期格式才可以)   值是日期类型
        Pragma:no-cache
*/

        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expireds", -1);
        resp.setHeader("Pragma", "no-cache");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(String.format("当前的时间是:%s", time));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
