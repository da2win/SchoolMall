package com.da2win.scmall.service;

import com.da2win.scmall.entity.ShopCategory;

import java.util.List;

/**
 *
 * @author Darwin
 * @date 2018/5/25
 */
public interface ShopCategoryService {

    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
