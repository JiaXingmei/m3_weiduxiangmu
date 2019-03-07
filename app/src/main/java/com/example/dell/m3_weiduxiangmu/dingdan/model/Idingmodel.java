package com.example.dell.m3_weiduxiangmu.dingdan.model;

import java.util.HashMap;

public interface Idingmodel
{
    void getdmdata(HashMap<String,Object> hashMap,int addressId,double totalPrice,HashMap<String,Object> ordermap,DingCallBack dingCallBack);
    interface DingCallBack
    {
        void Onsuccess(Object object);
    }

    //全部订单
    void getallmdata(HashMap<String,Object> hashMap,int status,int page,int count,DingCallBack dingCallBack);

}
