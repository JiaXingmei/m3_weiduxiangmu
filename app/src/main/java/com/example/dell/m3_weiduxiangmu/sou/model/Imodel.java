package com.example.dell.m3_weiduxiangmu.sou.model;

public interface Imodel
{
    void getmdata(String keyword, String page, String count, ZsCallBack zsCallBack);
    interface ZsCallBack
    {
        void OnSuccess(Object object);
        void OnFaie(Throwable e);
    }
}
