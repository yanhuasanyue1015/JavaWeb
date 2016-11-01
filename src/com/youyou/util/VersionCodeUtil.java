package com.youyou.util;

import com.youyou.servlet.LoginServlet;
import com.youyou.servlet.VersionCodeServlet;

import java.awt.*;
import java.awt.font.NumericShaper;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by zhanglei-account on 2016/11/2.
 */
public class VersionCodeUtil {
    private Random random = new Random();
    private BufferedImage bufferedImage;
    private int height;
    private int width;
    private final Graphics graphics;
    private final int LeftRightPadding = 5;
    private final int TopBottomPadding = 10;
    //字之间的间距
    private final int IntervalBetweenStr = 4;
    private int[] heightRange = new int[2];
    private int[] widthRange = new int[2];
    private char[] chars;
    private Color bgColor;

    public VersionCodeUtil(int height, int width) {
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graphics = bufferedImage.getGraphics();
        initHeightRange(height, TopBottomPadding);
        initWidthRange(width, LeftRightPadding);
    }

    public VersionCodeUtil bgColor(Color color) {
        this.bgColor = color;
        graphics.setColor(color);
        graphics.fillRect(0, 0, width, height);
        return this;
    }

    public VersionCodeUtil addStrings(Color textColor, char... chars) {
        if (this.chars != null) {
            this.chars = chars;
            if (bgColor != null) {
                bgColor(bgColor);
            }
        }
        graphics.setColor(textColor);
        long CellWidth = (widthRange[1] - widthRange[0] - IntervalBetweenStr * (chars.length - 1)) / chars.length;
        for (int i = 0; i < chars.length; i++) {
            int y = random.nextInt(heightRange[1] - heightRange[0]) + heightRange[0];
            int x = random.nextInt((int) CellWidth) + widthRange[0] + i * IntervalBetweenStr + (int) (CellWidth * i);
            graphics.drawString(chars[i] + "", x, y);
        }
        return this;
    }

    public BufferedImage build() {
        return bufferedImage;
    }

    private void initHeightRange(int height, int TopBottomPadding) {
        heightRange[0] = TopBottomPadding;
        heightRange[1] = height - TopBottomPadding;
    }

    private void initWidthRange(int width, int LeftRightPadding) {
        widthRange[0] = LeftRightPadding;
        widthRange[1] = width - LeftRightPadding;
    }

    private void drawInterferingLines() {

    }
}
