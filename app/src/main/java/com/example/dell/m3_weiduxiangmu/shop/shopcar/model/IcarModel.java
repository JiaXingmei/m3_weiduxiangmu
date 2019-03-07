package com.example.dell.m3_weiduxiangmu.shop.shopcar.model;

import java.util.HashMap;

public interface IcarModel
{
    void getCarmdata(HashMap<String,Object> hashMap, ShopCarCallBack shopCarCallBack);
    interface ShopCarCallBack
    {
        void Onsuccess(Object object);
    }

}
