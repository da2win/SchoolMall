package com.da2win.scmall.util;

import jdk.internal.util.xml.impl.Input;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author Darwin
 * @date 2018/5/24
 */
public class ImageUtil {

    private static final String BASE_PATH = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyMMddhhmmss");
    private static final Random random = new Random();

    public static String generateThumbnail(InputStream thumbnailInputStream, String fileName, String targetAddr) {
        String realFilename = getRandomFileName();
        String extension = getFileExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFilename + extension;
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnailInputStream).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(BASE_PATH + "/watermark.png ")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及的目录
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPah = PathUtil.getImgBasePath() + targetAddr;
        File file = new File(realFileParentPah);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File("E:\\Images\\timg.jpg")).size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(BASE_PATH + "/watermark.png ")), 0.25f)
                .outputQuality(0.8f).toFile("E:\\Images\\timg_wm.jpg");
    }

    /**
     * 生成随机文件名, 年月日时分秒+五位随机数
     * @return
     */
    private static String getRandomFileName() {
        // generate 5 random number
        int rannum = random.nextInt(89999) + 10000;
        String nowTimeStr = dateFormat.format(new Date());
        return nowTimeStr + rannum;
    }
}
