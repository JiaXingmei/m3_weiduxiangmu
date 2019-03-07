package com.example.dell.m3_weiduxiangmu.xiang.model;

public interface IxModel
{
    void getxmdata(String cid,XqCallBack xqCallBack);
    interface XqCallBack
    {
        void getSuccess(Object object);
    }

}
