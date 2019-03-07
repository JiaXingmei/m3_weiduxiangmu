package com.example.dell.m3_weiduxiangmu.login.model;

public interface IloginModel
{
    //登录
    void getmdata(String phone,String pwd,LoginCallBack loginCallBack);
    //注册
    void getzdata(String phone,String pwd,LoginCallBack loginCallBack);
    interface LoginCallBack
    {
        void OnSuccess(Object object);

    }
}
