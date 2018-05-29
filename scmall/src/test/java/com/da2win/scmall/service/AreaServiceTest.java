package com.da2win.scmall.service;

import com.da2win.scmall.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Darwin on 2018/5/24.
 */
public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;

    @Test
    public void getAreaList() throws Exception {
        Assert.assertEquals("广州", areaService.getAreaList().get(0).getAreaName());
    }


}