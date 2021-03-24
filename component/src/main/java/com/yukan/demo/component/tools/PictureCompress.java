package com.yukan.demo.component.tools;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

import java.io.IOException;

/**
 * 图片压缩
 *
 * @author yukan
 * @date 2021/3/23
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class PictureCompress {

    /**
     * 无损压缩
     */
    public static void losslessCompress(String srcImageFile, String imageFile) throws IOException {

        PictureThumbnailsGenerator.genThumbnail(srcImageFile, imageFile);

    }
}
