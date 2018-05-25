package com.da2win.scmall.dao;

import com.da2win.scmall.BaseTest;
import com.da2win.scmall.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Darwin on 2018/5/25.
 */
public class ShopCategoryDaoTest extends BaseTest{
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void queryShopCategory() throws Exception {
        List<ShopCategory> shopCategories = shopCategoryDao.queryShopCategory(new ShopCategory());
        ShopCategory category = new ShopCategory();
        ShopCategory parent = new ShopCategory();
        parent.setShopCategoryId(1L);
        category.setParent(parent);
        shopCategories = shopCategoryDao.queryShopCategory(category);


        assertEquals(1, shopCategories.size());
    }

}