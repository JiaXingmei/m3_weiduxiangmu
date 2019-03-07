package com.example.dell.m3_weiduxiangmu.shop.presenter;

import com.example.dell.m3_weiduxiangmu.XiangActivity;
import com.example.dell.m3_weiduxiangmu.fragment.ShopFragment;
import com.example.dell.m3_weiduxiangmu.shop.model.IshopModel;
import com.example.dell.m3_weiduxiangmu.shop.model.ShopModel;

import java.util.HashMap;

public class ShopPresenter implements IshopPresenter
{
   XiangActivity xiangActivity;
    private final ShopModel shopModel;

    public ShopPresenter(XiangActivity xiangActivity) {
        this.xiangActivity = xiangActivity;
        shopModel = new ShopModel();
    }

    @Override
    public void getspdata(HashMap<String, Object> hashMap, String data)
    {
        shopModel.getsmdata(hashMap, data, new IshopModel.ShopCallBack() {
            @Override
            public void Onsuccess(Object object) {
             xiangActivity.getaddvdata(object);
            }
        });

    }
}
