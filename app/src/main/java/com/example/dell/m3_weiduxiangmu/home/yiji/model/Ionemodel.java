package com.example.dell.m3_weiduxiangmu.home.yiji.model;

public interface Ionemodel
{
    void getonemdata(OneCallBack oneCallBack);
    interface OneCallBack
    {
        void Onsuccess(Object object);
    }
}
