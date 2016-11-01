package com.youyou.servlet;

import com.youyou.util.Config;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhanglei-account on 2016/10/31.
 */
public class TextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        writeBytes(resp, "哈哈,你好");
        writeCharacters(resp, "哈哈,我很好");
    }

    private void writeBytes(HttpServletResponse resp, String content) throws IOException {
        resp.setHeader("Content-Type","text/html;charset=" + Config.Encoding);
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(content.getBytes(Config.Encoding));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    private void writeCharacters(HttpServletResponse resp, String content) throws IOException {
        resp.setHeader("Content-Type","text/html;charset=" + Config.Encoding);
        resp.setCharacterEncoding(Config.Encoding);
        resp.getWriter().write(content);
    }
}
