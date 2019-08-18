package panda;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * @author 图片拼接
 */
public class SpellImg {
    public static void main(String[] args) {
        try {
            // 读取第一张图片
            File fileOne = new File("/Users/panda/Downloads/户主.jpg");
            BufferedImage ImageOne = ImageIO.read(fileOne);
            int width = ImageOne.getWidth();// 图片宽度
            int height = ImageOne.getHeight();// 图片高度
            // 从图片中读取RGB
            int[] ImageArrayOne = new int[width * height];
            ImageArrayOne = ImageOne.getRGB(0, 0, width, height, ImageArrayOne,
                    0, width);
            // 对第二张图片做相同的处理

            File fileTwo = new File("/Users/panda/Downloads/本人.jpg");
            BufferedImage ImageTwo = ImageIO.read(fileTwo);
            int[] ImageArrayTwo = new int[width * height];
            ImageArrayTwo = ImageTwo.getRGB(0, 0, width, height, ImageArrayTwo,
                    0, width);
            // 生成新图片
            // BufferedImage ImageNew = new BufferedImage(width * 2, height,
            // BufferedImage.TYPE_INT_RGB);// （左右）
            BufferedImage ImageNew = new BufferedImage(width, height * 2,
                    BufferedImage.TYPE_INT_ARGB); // （上下）
            // TYPE_INT_ARGB（不丢失alpha）TYPE_INT_RGB（丢失alpha）
            ImageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);// 设置左半部分的RGB
            // ImageNew.setRGB(width, 0, width, height, ImageArrayTwo, 0,
            // width);// 设置右半部分的RGB（左右）
            ImageNew.setRGB(0, height, width, height, ImageArrayTwo, 0, width);// 设置右半部分的RGB（上下）
            File outFile = new File("/Users/panda/Downloads/8.png");
            ImageIO.write(ImageNew, "png", outFile);// 写图片

            System.out.println("success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
