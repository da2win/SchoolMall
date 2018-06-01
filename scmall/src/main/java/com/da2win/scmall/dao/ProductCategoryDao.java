package com.da2win.scmall.dao;

import com.da2win.scmall.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author Darwin
 * @date 2018/5/31
 */
public interface ProductCategoryDao {

    List<ProductCategory> queryProductCategoryList(Long shopId);

    /**
     * 批量新增商品类别
     * @param categories
     * @return
     */
    int batchInsertProductCategory(List<ProductCategory> categories);

    /**
     * 删除指定商品的指定商品类型
     * @param productCategoryId
     * @param shopId
     * @return
     */
    int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);
}
