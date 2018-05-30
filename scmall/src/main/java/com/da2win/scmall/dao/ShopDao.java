package com.da2win.scmall.dao;

import com.da2win.scmall.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author Darwin
 * @date 2018/5/24
 */
public interface ShopDao {

    /**
     * 分页查询店铺, 可输入的条件: 店铺名(模糊), 店铺状态, 店铺类别, 区域id
     */
    List<Shop> queryShopList(@Param("shopCondition")Shop shopCondition,
                             @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    /**
     * 返回queryList 总数
     * @param shopCondition
     * @return
     */
    int queryShopCount(@Param("shopCondition") Shop shopCondition);
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
