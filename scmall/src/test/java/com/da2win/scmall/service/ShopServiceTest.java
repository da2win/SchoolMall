package com.da2win.scmall.service;

import com.da2win.scmall.BaseTest;
import com.da2win.scmall.dto.ShopExecution;
import com.da2win.scmall.entity.Area;
import com.da2win.scmall.entity.PersonInfo;
import com.da2win.scmall.entity.Shop;
import com.da2win.scmall.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import static com.da2win.scmall.enums.ShopStateEnum.CHECK;
import static org.junit.Assert.assertEquals;

/**
 * Created by Darwin on 2018/5/24.
 */
public class ShopServiceTest extends BaseTest{
    @Autowired
    private ShopService shopService;

    @Test
    public void addShop() throws Exception {
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
        shop.setShopName("测试的店铺3");
        shop.setShopDesc("test1");
        shop.setShopAddr("test1");
        shop.setPhone("test1");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(CHECK.getState());
        shop.setAdvice("审核中");
        File image = new File("C:\\Users\\Darwin\\Pictures\\夜斗.jpg");
        ShopExecution execution = shopService.addShop(shop, new FileInputStream(image), image.getName());
        assertEquals(CHECK.getState(), execution.getState());
    }

}