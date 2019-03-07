package com.example.dell.m3_weiduxiangmu.my.shouhuo;

import java.util.HashMap;

public interface Ihuomodel
{
    void gethmdata(HashMap<String,Object> hashMap,String name,String phone,String addr,String code,HuoCallBack huoCallBack);
    interface HuoCallBack
    {
        void Onsuccess(Object object);
    }
}
