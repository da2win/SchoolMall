package com.da2win.scmall.util;

/**
 * @author Darwin
 * @date 2018/5/24
 */
public class PathUtil {

    private static String seperator = System.getProperty("file.separator");

    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basepath = "";
        if (os.toLowerCase().startsWith("win")) {
            basepath = "E:/Images/scmall/";
        } else {
            basepath = "/home/da2win/image";
        }
        basepath = basepath.replace("/", seperator);
        return basepath;
    }

    public static String getShopImagePath(long shopId) {
        String imagepath = "/upload/item/shop/" + shopId + "/";
        return imagepath.replace("/", seperator) ;
    }
}
