package com.youyou.servlet;

import com.youyou.util.VersionCodeUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by zhanglei-account on 2016/11/2.
 */
public class VersionCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VersionCodeUtil versionCodeUtil = new VersionCodeUtil(50, 200);
        versionCodeUtil.bgColor(Color.BLUE).addStrings(Color.white, 'a', 'b','c','d','e','f');
        ImageIO.write(versionCodeUtil.build(), "jpg", resp.getOutputStream());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
