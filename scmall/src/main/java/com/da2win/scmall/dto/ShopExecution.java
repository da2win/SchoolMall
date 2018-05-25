package com.da2win.scmall.dto;

import com.da2win.scmall.entity.Shop;
import com.da2win.scmall.enums.ShopStateEnum;

import java.util.List;

/**
 * @author Darwin
 * @date 2018/5/24
 */
public class ShopExecution {
    private int state;
    private String stateInfo;
    private int count;

    /**
     * 操作的shop(增删改时使用)
     */
    private Shop shop;

    /**
     * shop列表, 查询店铺列表使用
     */
    private List<Shop> shopList;

    public ShopExecution() {

    }

    /**
     * 店铺操作失败的构造器
     * @param stateEnum
     */
    public ShopExecution(ShopStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    /**
     * 店铺操作成功的构造器
     * @param stateEnum
     * @param shop
     */
    public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }

    /**
     * 店铺列表
     * @param stateEnum
     * @param shopList
     */
    public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
