package com.da2win.scmall.dao;

import com.da2win.scmall.entity.Area;

import java.util.List;

/**
 *
 * @author Darwin
 * @date 2018/5/23
 */
public interface AreaDao {

    /**
     * 列出区域列表
     * @return
     */
    List<Area> queryArea();
}
