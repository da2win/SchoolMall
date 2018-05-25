package com.da2win.scmall.dao;

import com.da2win.scmall.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author Darwin
 * @date 2018/5/25
 */
public interface ShopCategoryDao {

    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategory);
}
