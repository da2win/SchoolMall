package com.da2win.scmall.service;

import com.da2win.scmall.dto.ShopExecution;
import com.da2win.scmall.entity.Shop;
import com.da2win.scmall.exception.ShopOperationException;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 *
 * @author Darwin
 * @date 2018/5/24
 */
public interface ShopService {

    ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

    /**
     * 添加商户
     * @param shop
     * @return
     */
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName);

    /**
     * Get merchant
     */
    Shop getShopId(long shopId);

    ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;

}
