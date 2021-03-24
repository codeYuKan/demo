package com.yukan.demo.component.tools;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author yukan
 * @date 2021/3/23
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class PictureThumbnailsGenerator {

    public static void genThumbnail(String srcImageFile, String imageFile) throws IOException {
        BufferedImage srcImage = ImageIO.read(new File(srcImageFile));
        int width = srcImage.getWidth();
        int height = srcImage.getHeight();
        Thumbnails.of(srcImageFile)
                .size(width,height)
                .toFile(imageFile);
    }


    public static void main(String[] args) throws IOException {
        genThumbnail("D:\\test\\dpi150.jpg", "D:\\test\\dpi96.jpg");
    }
}
