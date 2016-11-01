package com.youyou.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by zhanglei-account on 2016/10/31.
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/imags/外国美女.jpg");
        File file = new File(path);
        if (!(file.exists())) {
            return;
        }
        String mineType = URLConnection.guessContentTypeFromName(path);
        if (mineType == null) {
            mineType = "application/octet-stream";
        }
        resp.setContentType(mineType);
        resp.setContentLengthLong(file.length());
        String encodeDFileName;
        String userAgent = req.getHeader("User-Agent");
//        String browserName = UserAgent.parseUserAgentString(userAgent).getBrowser().getGroup().getName();
//        if (browserName.equals("Chrome") || browserName.equals("Internet Exploer") || browserName.equals("Safari")) {
            encodeDFileName = URLEncoder.encode(file.getName(), "UTF-8").replaceAll("\\+", "%20");
//        } else {
//            encodeDFileName = MimeUtility.encodeWord(file.getName());
//        }
        resp.setHeader("Content-Disposition", "attachment;filename=" + encodeDFileName);
        System.out.println(req.getRemoteAddr());
        System.out.println(req.getHeader("User-Agent"));
        InputStream inputStream = new FileInputStream(file);
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] temp = new byte[2048];
        int length = -1;
        while ((length = inputStream.read(temp)) != -1) {
            outputStream.write(temp, 0, length);
        }
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
