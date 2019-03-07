package com.example.dell.m3_weiduxiangmu.my.shouhuo;

import com.example.dell.m3_weiduxiangmu.ZengActivity;

import java.util.HashMap;

public class HuoPresenter implements Ihuopresenter{
    ZengActivity zview;
    private final HuoModel huoModel;

    public HuoPresenter(ZengActivity zview) {
        this.zview = zview;
        huoModel = new HuoModel();
    }

    @Override
    public void gethpdata(HashMap<String, Object> hashMap, String name, String phone, String addr, String code) {
      huoModel.gethmdata(hashMap, name, phone, addr, code, new Ihuomodel.HuoCallBack() {
          @Override
          public void Onsuccess(Object object) {
              zview.gethvdata(object);
          }
      });
    }
}
