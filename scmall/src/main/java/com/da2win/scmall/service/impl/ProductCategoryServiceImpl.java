package com.da2win.scmall.service.impl;

import com.da2win.scmall.dao.ProductCategoryDao;
import com.da2win.scmall.entity.ProductCategory;
import com.da2win.scmall.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Darwin
 * @date 2018/5/31
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Override
    public List<ProductCategory> queryProductCategoryList(Long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);
    }
}
