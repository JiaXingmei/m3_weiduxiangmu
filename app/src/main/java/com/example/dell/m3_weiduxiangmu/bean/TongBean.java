package com.example.dell.m3_weiduxiangmu.bean;

public class TongBean
{
    public TongBean(int commodityId, String count) {
        this.commodityId = commodityId;
        this.count = count;
    }

    /**
     * commodityId : 5
     * count : 3
     */

    private int commodityId;
    private String count;

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
