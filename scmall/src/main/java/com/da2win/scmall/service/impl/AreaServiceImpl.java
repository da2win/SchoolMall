package com.da2win.scmall.service.impl;

import com.da2win.scmall.dao.AreaDao;
import com.da2win.scmall.entity.Area;
import com.da2win.scmall.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Darwin
 * @date 2018/5/24
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
