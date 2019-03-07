package com.example.dell.m3_weiduxiangmu.my.selecthuo;

import java.util.HashMap;

public interface Iselectmodel
{
    void gethmdata(HashMap<String, Object> hashMap,HuoCallBack huoCallBack);
    void getnmdata(HashMap<String, Object> hashMap,String name,HuoCallBack huoCallBack);
    void getqmdata(HashMap<String, Object> hashMap,int page,int count,HuoCallBack huoCallBack);
    void getzmdata(HashMap<String, Object> hashMap,int page,int count,HuoCallBack huoCallBack);
    interface HuoCallBack
    {
        void Onsuccess(Object object);
    }
}
