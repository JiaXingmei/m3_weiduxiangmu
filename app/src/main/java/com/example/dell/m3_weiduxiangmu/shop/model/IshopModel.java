package com.example.dell.m3_weiduxiangmu.shop.model;

import java.util.HashMap;

public interface IshopModel
{
    void getsmdata(HashMap<String,Object> hashMap,String data,ShopCallBack shopCallBack);
    interface ShopCallBack
    {
        void Onsuccess(Object object);
    }
}
