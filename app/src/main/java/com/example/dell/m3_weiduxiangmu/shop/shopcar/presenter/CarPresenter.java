package com.example.dell.m3_weiduxiangmu.shop.shopcar.presenter;

import com.example.dell.m3_weiduxiangmu.XiangActivity;
import com.example.dell.m3_weiduxiangmu.fragment.ShopFragment;
import com.example.dell.m3_weiduxiangmu.shop.shopcar.model.CarModel;
import com.example.dell.m3_weiduxiangmu.shop.shopcar.model.IcarModel;

import java.util.HashMap;

public class CarPresenter implements IcarPresenter
{
    ShopFragment shopFragment;
    XiangActivity xiangActivity;
    private final CarModel carModel;

    public CarPresenter(XiangActivity xiangActivity) {
        this.xiangActivity = xiangActivity;
        carModel = new CarModel();
    }



    public CarPresenter(ShopFragment shopFragment) {
        this.shopFragment = shopFragment;
        carModel = new CarModel();
    }

    @Override
    public void getCarpdata(HashMap<String, Object> hashMap)
    {
        carModel.getCarmdata(hashMap,new IcarModel.ShopCarCallBack() {
            @Override
            public void Onsuccess(Object object) {
                shopFragment.getCarvdata(object);
            }
        });

    }

    //查询
    @Override
    public void getChapdata(HashMap<String, Object> hashMap)
    {
        carModel.getCarmdata(hashMap, new IcarModel.ShopCarCallBack() {
            @Override
            public void Onsuccess(Object object) {
                xiangActivity.getChaVdata(object);
            }
        });

    }
}
