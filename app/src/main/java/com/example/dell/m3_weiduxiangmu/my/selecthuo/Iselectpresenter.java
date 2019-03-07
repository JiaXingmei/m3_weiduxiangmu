package com.example.dell.m3_weiduxiangmu.my.selecthuo;

import java.util.HashMap;

public interface Iselectpresenter
{
    void gethpdata(HashMap<String, Object> hashMap);
    void getnpdata(HashMap<String, Object> hashMap,String name);
    void getqpdata(HashMap<String, Object> hashMap, int page, int count);
    void getzpdata(HashMap<String, Object> hashMap, int page, int count);

}
