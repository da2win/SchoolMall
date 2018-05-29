package com.da2win.scmall.service.impl;

import com.da2win.scmall.dao.ShopDao;
import com.da2win.scmall.dto.ShopExecution;
import com.da2win.scmall.entity.Shop;
import com.da2win.scmall.enums.ShopStateEnum;
import com.da2win.scmall.exception.ShopOperationException;
import com.da2win.scmall.service.ShopService;
import com.da2win.scmall.util.ImageUtil;
import com.da2win.scmall.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;

import static com.da2win.scmall.enums.ShopStateEnum.*;

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

    @Override
    public Shop getShopId(long shopId) {
        return shopDao.queryByShopId(shopId);
    }

    @Override
    public ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException {
        if (shop == null || shop.getShopId() == null) {
            return new ShopExecution(NULL_SHOP);
        }
        try {
            // 判断是否需要处理图片
            if (shopImgInputStream != null && fileName != null && !"".equals(fileName)) {
                Shop tempShop = shopDao.queryByShopId(shop.getShopId());
                if (tempShop.getShopImg() != null) {
                    ImageUtil.deleteFileOrPath(tempShop.getShopImg());
                }
                addShopImg(shop, shopImgInputStream, fileName);
            }
            // 更新店铺信息
            shop.setLastEditTime(new Date());
            int effectedNum = shopDao.updateShop(shop);
            if (effectedNum <= 0) {
                return new ShopExecution(INNER_ERROR);
            }
            shop = shopDao.queryByShopId(shop.getShopId());
            return new ShopExecution(SUCCESS, shop);
        } catch (Exception e) {
            throw new ShopOperationException("modify shop error:" +e.getMessage());
        }
    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
        // 获取shop图片目录的相对路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream, fileName, dest);
        shop.setShopImg(shopImgAddr);
    }
}
