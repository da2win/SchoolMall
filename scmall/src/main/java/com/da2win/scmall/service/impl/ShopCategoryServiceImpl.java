package com.da2win.scmall.service.impl;

import com.da2win.scmall.dao.ShopCategoryDao;
import com.da2win.scmall.entity.ShopCategory;
import com.da2win.scmall.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Darwin
 * @date 2018/5/25
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }
}
