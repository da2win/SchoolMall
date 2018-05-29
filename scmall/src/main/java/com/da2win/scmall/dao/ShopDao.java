package com.da2win.scmall.dao;

import com.da2win.scmall.entity.Shop;

/**
 *
 * @author Darwin
 * @date 2018/5/24
 */
public interface ShopDao {

    /**
     *
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);
    /**
     * add shop.
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * update shop.
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
