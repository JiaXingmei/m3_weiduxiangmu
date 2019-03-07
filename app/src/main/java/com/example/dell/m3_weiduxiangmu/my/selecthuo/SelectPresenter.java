package com.example.dell.m3_weiduxiangmu.my.selecthuo;

import com.example.dell.m3_weiduxiangmu.AddrActivity;
import com.example.dell.m3_weiduxiangmu.MoneyActivity;
import com.example.dell.m3_weiduxiangmu.UpdataNikeActivity;
import com.example.dell.m3_weiduxiangmu.ZuActivity;

import java.util.HashMap;

public class SelectPresenter implements Iselectpresenter
{

    AddrActivity aview;
    UpdataNikeActivity uview;
    MoneyActivity mview;
    ZuActivity zuActivity;
    private final SelectModel selectModel;

    public SelectPresenter(ZuActivity zuActivity) {
        this.zuActivity = zuActivity;
        selectModel =new SelectModel();
    }



    public SelectPresenter(MoneyActivity mview) {
        this.mview = mview;
        selectModel =new SelectModel();
    }



    public SelectPresenter(UpdataNikeActivity uview) {
        this.uview = uview;
        selectModel =new SelectModel();
    }

    public SelectPresenter(AddrActivity aview) {
        this.aview = aview;
        selectModel =new SelectModel();
    }

    @Override
    public void gethpdata(HashMap<String, Object> hashMap) {
        selectModel.gethmdata(hashMap, new Iselectmodel.HuoCallBack() {
            @Override
            public void Onsuccess(Object object) {
                aview.gethvdata(object);
            }
        });
    }

    @Override
    public void getnpdata(HashMap<String, Object> hashMap, String name) {
        selectModel.getnmdata(hashMap, name, new Iselectmodel.HuoCallBack() {
            @Override
            public void Onsuccess(Object object) {
                uview.getnvdata(object);
            }
        });
    }

    @Override
    public void getqpdata(HashMap<String, Object> hashMap, int page, int count) {
        selectModel.getqmdata(hashMap, page, count, new Iselectmodel.HuoCallBack() {
            @Override
            public void Onsuccess(Object object) {
                mview.getQianData(object);
            }
        });
    }

    @Override
    public void getzpdata(HashMap<String, Object> hashMap, int page, int count) {
        selectModel.getzmdata(hashMap, page, count, new Iselectmodel.HuoCallBack() {
            @Override
            public void Onsuccess(Object object) {
                zuActivity.getzvdata(object);
            }
        });
    }
}
