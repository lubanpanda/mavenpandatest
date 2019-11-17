package com.panda;

/**
 * @author panda   84305510@qq.com
 * @date 2019-07-01 14:26
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



public class kuang {
    public static void main(String[] args) {
        new kuang().addBorderToImage("/Users/panda/Downloads/baidu.png");
    }

    public void addBorderToImage(String filePath) {
        try {
            File _file = new File(filePath); // 读入文件
            Image src = javax.imageio.ImageIO.read(_file); // 构造Image对象
            int width = src.getWidth(null); // 得到源图宽
            int height = src.getHeight(null); // 得到源图长
            System.out.println(width);
            System.out.println(height);
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics graphics = image.getGraphics();
            graphics.drawImage(src, 0, 0, width, height, null); // 绘制图
            graphics.setColor(Color.RED);
            graphics.drawRect(110, 270, width - 200, height - 450); //控制框的位置
            FileOutputStream out = new FileOutputStream("/Users/panda/Downloads/baidu1.png"); // 输出到文件流
            ImageIO.write(image, "png", out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
