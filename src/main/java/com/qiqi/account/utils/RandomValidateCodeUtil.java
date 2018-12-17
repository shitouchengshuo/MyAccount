package com.qiqi.account.utils;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class RandomValidateCodeUtil {
    // 放到session中的key
    public static final String RANDOM_CODE_KEY = "RANDOM_VAL_I_DATE_CODE_KEY";
    /**
     * 日志
     */
    private static final Logger logger = Logger.getLogger(RandomValidateCodeUtil.class);
    // 随机产生的字符串
    private static final String randString = "1234567890123456789ABCDEFGHKMNPQRSTUVWabcdefghijkmnpqrstuvwxyz";
    // 图片宽
    private static final int width = 90;
    // 图片高
    private static final int height = 34;
    // 干扰线数量
    private static final int lineSize = 40;
    // 随机产生字符数量
    private static final int stringNumber = 4;
    private Random random = new Random();

    /*
     * 获得字体
     */
    private Font getFont() {
        return new Font("Fixedsys", Font.CENTER_BASELINE, 20);
    }

    /*
     * 获得颜色
     */
    private Color getRandColor(int fc, int bc) {
        int fcn = fc;
        int bcn = bc;
        if (fc > 255)
            fcn = 255;
        if (bc > 255)
            bcn = 255;
        int r = fcn + random.nextInt(bcn - fcn - 16);
        int g = fcn + random.nextInt(bcn - fcn - 14);
        int b = fcn + random.nextInt(bcn - fcn - 18);
        return new Color(r, g, b);
    }

    /**
     * 生成随机图片
     */
    public void getRandCode(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        // BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        // 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
        Graphics graphics = image.getGraphics();
        graphics.fillRect(0, 0, width, height);
        graphics.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
        graphics.setColor(getRandColor(110, 133));
        // 绘制干扰线
        for (int i = 0; i <= lineSize; i++) {
            drawLine(graphics);
        }
        // 绘制随机字符
        String randomString = "";
        for (int i = 1; i <= stringNumber; i++) {
            randomString = drawString(graphics, randomString, i);
        }
        session.removeAttribute(RANDOM_CODE_KEY);
        session.setAttribute(RANDOM_CODE_KEY, randomString.toLowerCase());
        graphics.dispose();
        try {
            ImageIO.write(image, "JPEG", response.getOutputStream());// 将内存中的图片通过流动形式输出到客户端
        } catch (Exception e) {
            //logger.info(ExceptionUtils.getRootCauseMessage(e));
        }
    }

    /*
     * 绘制字符串
     */
    private String drawString(Graphics g, String randomString, int i) {
        g.setFont(getFont());
        g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
        String rand = String.valueOf(getRandomString(random.nextInt(randString.length())));
        String randomString1 = randomString + rand;
        g.translate(random.nextInt(3), random.nextInt(3));
        g.drawString(rand, 13 * i, 20);
        return randomString1;
    }

    /*
     * 绘制干扰线
     */
    private void drawLine(Graphics g) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }

    /*
     * 获取随机的字符
     */
    private String getRandomString(int num) {
        return String.valueOf(randString.charAt(num));
    }
}