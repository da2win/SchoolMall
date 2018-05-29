package com.da2win.scmall.dao;

import com.da2win.scmall.BaseTest;
import com.da2win.scmall.entity.Area;
import com.da2win.scmall.entity.PersonInfo;
import com.da2win.scmall.entity.Shop;
import com.da2win.scmall.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Darwin on 2018/5/24.
 */
public class ShopDaoTest extends BaseTest{

    @Autowired
    private ShopDao shopDao;

    @Test
    public void queryByShopId() throws Exception {
        long shopId = 1;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println("area name: " + shop.getArea().getAreaName());
        System.out.println("area id: " + shop.getArea().getAreaId());
    }

    @Test
    public void insertShop() throws Exception {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(1);
        shopCategory.setShopCategoryId(1L);

        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");

        int rs = shopDao.insertShop(shop);
        assertEquals(1, rs);
    }

    @Test
    public void updateShop() throws Exception {
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopDesc("测试描述");
        shop.setShopAddr("测试地址");
        shop.setLastEditTime(new Date());

        int expectedNum = shopDao.updateShop(shop);
        assertEquals(1, expectedNum);
    }
}
