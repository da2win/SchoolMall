package com.da2win.scmall.dao;

import com.da2win.scmall.BaseTest;
import com.da2win.scmall.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Darwin on 2018/5/23.
 */
public class AreaDaoTest extends BaseTest{
    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() throws Exception {
        List<Area> areas = areaDao.queryArea();
        Assert.assertEquals(areas.size(), 2);
    }

}