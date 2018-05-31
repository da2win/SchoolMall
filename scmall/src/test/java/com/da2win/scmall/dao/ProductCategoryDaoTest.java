package com.da2win.scmall.dao;

import com.da2win.scmall.BaseTest;
import com.da2win.scmall.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Darwin on 2018/5/31.
 */
public class ProductCategoryDaoTest extends BaseTest{
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void queryProductCategoryList() throws Exception {
        long shopId = 1;
        List<ProductCategory> categoryList = productCategoryDao.queryProductCategoryList(shopId);
        System.out.println("product category count: " + categoryList.size());
    }

}