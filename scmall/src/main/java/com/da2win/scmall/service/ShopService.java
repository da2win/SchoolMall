package com.da2win.scmall.service;

import com.da2win.scmall.dto.ShopExecution;
import com.da2win.scmall.entity.Shop;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 *
 * @author Darwin
 * @date 2018/5/24
 */
public interface ShopService {

    /**
     * 添加商户
     * @param shop
     * @return
     */
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName);
}
