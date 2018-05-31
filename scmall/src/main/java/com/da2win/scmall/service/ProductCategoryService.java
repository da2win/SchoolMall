package com.da2win.scmall.service;

import com.da2win.scmall.entity.ProductCategory;

import java.util.List;

/**
 *
 * @author Darwin
 * @date 2018/5/31
 */
public interface ProductCategoryService {

    List<ProductCategory> queryProductCategoryList(Long shopId);
}
