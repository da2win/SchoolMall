package com.da2win.scmall.dao;

import com.da2win.scmall.BaseTest;
import com.da2win.scmall.entity.Product;
import com.da2win.scmall.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Darwin on 2018/5/31.
 */
public class ProductCategoryDaoTest extends BaseTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void queryProductCategoryList() throws Exception {
        long shopId = 1;
        List<ProductCategory> categoryList = productCategoryDao.queryProductCategoryList(shopId);
        System.out.println("product category count: " + categoryList.size());
    }

    @Test
    public void batchInsertProductCategory() throws Exception {
        ProductCategory pc1 = new ProductCategory();
        pc1.setProductCategoryName("测试类别1");
        pc1.setPriority(1);
        pc1.setCreateTime(new Date());
        pc1.setShopId(1L);
        ProductCategory pc2 = new ProductCategory();
        pc2.setProductCategoryName("测试类别2");
        pc2.setPriority(2);
        pc2.setCreateTime(new Date());
        pc2.setShopId(1L);
        ProductCategory pc3 = new ProductCategory();
        pc3.setProductCategoryName("测试类别3");
        pc3.setPriority(3);
        pc3.setCreateTime(new Date());
        pc3.setShopId(1L);
        ProductCategory pc4 = new ProductCategory();
        pc4.setProductCategoryName("测试类别4");
        pc4.setPriority(4);
        pc4.setCreateTime(new Date());
        pc4.setShopId(1L);
        List<ProductCategory> categoryList = new ArrayList<>();
        categoryList.add(pc1);
        categoryList.add(pc2);
        categoryList.add(pc3);
        categoryList.add(pc4);
        int effectedNum = productCategoryDao.batchInsertProductCategory(categoryList);
        assertEquals(effectedNum > 0, true);

    }

    @Test
    public void delteProductCategory() throws Exception {
        long shopId = 1;
        productCategoryDao.deleteProductCategory(23, shopId);
        productCategoryDao.deleteProductCategory(24, shopId);
        productCategoryDao.deleteProductCategory(25, shopId);
        productCategoryDao.deleteProductCategory(26, shopId);
    }
}