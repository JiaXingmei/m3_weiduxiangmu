package com.example.dell.m3_weiduxiangmu.home.model;

public interface Imodel
{
    void getMdata(ListCallBack listCallback);
    interface ListCallBack
    {
        void getSuccess(Object object);
    }




    void getmdata(ZsCallBack zsCallBack);
    interface ZsCallBack
    {
        void OnSuccess(Object object);
        void OnFaie(Throwable e);
    }
}
