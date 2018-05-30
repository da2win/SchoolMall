package com.da2win.scmall.util;

/**
 *
 * @author Darwin
 * @date 2018/5/30
 */
public class PageCalculator {

    public static int calculateRowIndex(int pageIndex, int pageSize) {
        return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
    }
}
