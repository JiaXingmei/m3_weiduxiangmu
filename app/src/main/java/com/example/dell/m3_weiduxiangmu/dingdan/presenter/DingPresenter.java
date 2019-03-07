package com.example.dell.m3_weiduxiangmu.dingdan.presenter;

import com.example.dell.m3_weiduxiangmu.dingdan.model.DingModel;
import com.example.dell.m3_weiduxiangmu.dingdan.model.Idingmodel;
import com.example.dell.m3_weiduxiangmu.fragment.FindFragment;
import com.example.dell.m3_weiduxiangmu.fragment.radio.AllFragment;

import java.util.HashMap;

public class DingPresenter implements Idingpresenter
{
    FindFragment findFragment;
    AllFragment allFragment;
    private final DingModel dingModel;

    public DingPresenter(AllFragment allFragment) {
        this.allFragment = allFragment;
        dingModel = new DingModel();
    }



    public DingPresenter(FindFragment findFragment) {
        this.findFragment = findFragment;
        dingModel = new DingModel();
    }

    @Override
    public void getdpdata(HashMap<String, Object> hashMap, int addressId, double totalPrice, HashMap<String, Object> ordermap)
    {
        dingModel.getdmdata(hashMap, addressId, totalPrice, ordermap, new Idingmodel.DingCallBack() {
            @Override
            public void Onsuccess(Object object) {
                findFragment.getdvdata(object);

            }
        });


    }

    @Override
    public void getallpdata(HashMap<String, Object> hashMap, int status, int page, int count)
    {
        dingModel.getallmdata(hashMap, status, page, count, new Idingmodel.DingCallBack() {
            @Override
            public void Onsuccess(Object object) {
                allFragment.getallvdata(object);
            }
        });

    }
}
