package com.da2win.scmall.service.impl;

import com.da2win.scmall.dao.ShopDao;
import com.da2win.scmall.dto.ShopExecution;
import com.da2win.scmall.entity.Shop;
import com.da2win.scmall.exception.ShopOperationException;
import com.da2win.scmall.service.ShopService;
import com.da2win.scmall.util.ImageUtil;
import com.da2win.scmall.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;

import static com.da2win.scmall.enums.ShopStateEnum.CHECK;
import static com.da2win.scmall.enums.ShopStateEnum.NULL_SHOP;

/**
 * @author Darwin
 * @date 2018/5/24
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
        // NULL CHECK
        if (shop == null) {
            return new ShopExecution(NULL_SHOP);
        }
        try {
            // INITIAL VALUE
            shop.setEnableStatus(0);
            shop.setLastEditTime(new Date());
            int expectedNum = shopDao.insertShop(shop);
            if (expectedNum <= 0) {
                throw new ShopOperationException("店铺创建失败");
            } else {
                if (shopImgInputStream != null) {
                    // store image
                    try {
                        addShopImg(shop, shopImgInputStream, fileName);
                    } catch (Exception e) {
                        throw new ShopOperationException("add shop image error!");
                    }
                    // update shop's image path.
                    expectedNum = shopDao.updateShop(shop);
                    if (expectedNum <= 0) {
                        throw new ShopOperationException("Update image path ");
                    }
                }
            }
        } catch (Exception e) {
            throw new ShopOperationException("Add shop error:" + e.getMessage());
        }
        return new ShopExecution(CHECK, shop);
    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
        // 获取shop图片目录的相对路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream, fileName, dest);
        shop.setShopImg(shopImgAddr);
    }
}
