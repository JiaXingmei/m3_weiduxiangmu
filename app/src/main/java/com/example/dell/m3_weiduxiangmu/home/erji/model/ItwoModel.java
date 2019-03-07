package com.example.dell.m3_weiduxiangmu.home.erji.model;


public interface ItwoModel
{
    void gettwomdata(String fid,TwoCallBack twoCallBack);
    interface TwoCallBack
    {
        void Onsuccess(Object object);
    }
}
