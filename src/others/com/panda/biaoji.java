package panda;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;

/**
 * @use 利用Java代码给图片加水印
 * 方便查看
 */
public class biaoji {

    /**
     * @param srcImgPath       源图片路径
     * @param tarImgPath       保存的图片路径
     * @param waterMarkContent 水印内容
     * @param markContentColor 水印颜色
     * @param font             水印字体
     */
    public void addWaterMark(String srcImgPath, String tarImgPath, String waterMarkContent, Color markContentColor, Font font) {

        try {
            // 读取原图片信息
            File srcImgFile = new File(srcImgPath);//得到文件
            Image srcImg = ImageIO.read(srcImgFile);//文件转化为图片
            int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);//获取图片的高
            System.out.println("图片的宽" + srcImgWidth);
            System.out.println("图片的高" + srcImgHeight);
            // 加标记文字内容
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor); //根据图片的背景设置水印颜色
            g.setFont(font);              //设置字体

            //设置水印的坐标
//            int x = srcImgWidth - 20 * getWatermarkLength(waterMarkContent, g);
//            int y = srcImgHeight - 20 * getWatermarkLength(waterMarkContent, g);
            int x = srcImgWidth / 5;
            int y = srcImgHeight / 5;

            g.drawString(waterMarkContent, x, y);  //画出水印
            g.dispose();
            //g.setStroke(new BasicStroke(1.0f));
            // 输出图片
            FileOutputStream outImgStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg, "png", outImgStream);
            System.out.println("添加标记完成");
            outImgStream.flush();   //写入
            outImgStream.close();   //关闭

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        int b = g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
        System.out.print("这是个b的int值" + b + "\n");
        return b;
    }

    public static void main(String[] args) {
        Font font = new Font("微软雅黑", Font.PLAIN, 40);                     //水印字体
        String srcImgPath = "/Users/panda/Downloads/baidu.png"; //源图片地址
        String tarImgPath = "/Users/panda/Downloads/t.png"; //待存储的地址
        String waterMarkContent = "这是aaaaaaa";  //标注内容
        Color color = new Color(255, 8, 25, 255);                               //水印图片色彩以及透明度
        biaoji a = new biaoji();
        try {
            a.addWaterMark(srcImgPath, tarImgPath, waterMarkContent, color, font);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}