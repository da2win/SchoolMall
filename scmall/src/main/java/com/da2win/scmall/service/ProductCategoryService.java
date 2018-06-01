package com.da2win.scmall.service;

import com.da2win.scmall.dto.ProductCategoryExecution;
import com.da2win.scmall.entity.ProductCategory;
import com.da2win.scmall.exception.ProductCategoryOperationException;

import java.util.List;

/**
 *
 * @author Darwin
 * @date 2018/5/31
 */
public interface ProductCategoryService {

    List<ProductCategory> queryProductCategoryList(Long shopId);

    ProductCategoryExecution batchAdddProductCategory(List<ProductCategory> productCategories) throws ProductCategoryOperationException;

    ProductCategoryExecution delteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException;
}
