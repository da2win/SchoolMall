package com.da2win.scmall.service.impl;

import com.da2win.scmall.dao.ProductCategoryDao;
import com.da2win.scmall.dto.ProductCategoryExecution;
import com.da2win.scmall.entity.ProductCategory;
import com.da2win.scmall.enums.ProductCategoryStateEnum;
import com.da2win.scmall.exception.ProductCategoryOperationException;
import com.da2win.scmall.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
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

    @Override
    @Transactional
    public ProductCategoryExecution batchAdddProductCategory(List<ProductCategory> productCategories) throws ProductCategoryOperationException {
        if (productCategories != null && productCategories.size() > 0) {
            try {
                int effectedNum = productCategoryDao.batchInsertProductCategory(productCategories);
                if (effectedNum <= 0) {
                    throw new ProductCategoryOperationException("店铺类别创建失败");
                }
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            } catch (Exception e) {
                throw new ProductCategoryOperationException("Batch add product category error: " + e.getMessage());
            }
        }
        return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
    }

    @Override
    @Transactional
    public ProductCategoryExecution delteProductCategory(long productCategoryId, long shopId) throws ProductCategoryOperationException {
        // TODO 将此商品ID的商品置为空
        try {
            int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId, shopId);
            if (effectedNum <= 0) {
                throw new ProductCategoryOperationException("商品类别删除失败!");
            }
            return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
        } catch (Exception e) {
            throw new ProductCategoryOperationException("Delete product category error: " + e.getMessage());
        }
    }
}
