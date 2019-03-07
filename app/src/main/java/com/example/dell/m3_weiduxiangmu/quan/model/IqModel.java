package com.example.dell.m3_weiduxiangmu.quan.model;

public interface IqModel
{
    void getqmdata(int page,int count,QuanCallBack quanCallBack);
    interface QuanCallBack
    {
        void Onsuccess(Object object);
    }

}
