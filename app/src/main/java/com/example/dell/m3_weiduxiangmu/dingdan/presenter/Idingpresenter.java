package com.example.dell.m3_weiduxiangmu.dingdan.presenter;

import com.example.dell.m3_weiduxiangmu.dingdan.model.Idingmodel;

import java.util.HashMap;

public interface Idingpresenter
{
    void getdpdata(HashMap<String,Object> hashMap, int addressId, double totalPrice, HashMap<String,Object> ordermap);
    void getallpdata(HashMap<String,Object> hashMap, int status, int page, int count);

}
