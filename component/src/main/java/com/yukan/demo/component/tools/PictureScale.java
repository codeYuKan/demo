package com.yukan.demo.component.tools;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 图片缩放工具
 *
 *
 * @author yukan
 * @date 2021/3/16
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class PictureScale {

    public static void scale(String srcImageFile, String imageFile, int scale, boolean scaleFlag) {
        try {
            BufferedImage srcImage = ImageIO.read(new File(srcImageFile));
            int width = srcImage.getWidth();
            int height = srcImage.getHeight();
            if (scaleFlag) {
                // 放大
                width *= scale;
                height *= scale;
            } else {
                // 缩小
                width /= scale;
                height /= scale;
            }

            Image image = srcImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);

            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics graphics = bufferedImage.getGraphics();
            graphics.drawImage(image, 0, 0, null);
            graphics.dispose();

            ImageIO.write(bufferedImage, "JPEG", new File(imageFile));
        } catch (IOException e) {
            log.error("scale.error:", e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        scale("D:\\test\\i1.jpg", "D:\\test\\i2.jpg", 2, true);
    }
}
