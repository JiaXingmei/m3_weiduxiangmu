package com.example.dell.m3_weiduxiangmu.home.erji.presenter;

import com.example.dell.m3_weiduxiangmu.fragment.ShouFragment;
import com.example.dell.m3_weiduxiangmu.home.erji.model.ItwoModel;
import com.example.dell.m3_weiduxiangmu.home.erji.model.PopTwoModel;

public class PopTwoPresenter implements ItwoPresenter {
    ShouFragment shouFragment;
    private final PopTwoModel popTwoModel;

    public PopTwoPresenter(ShouFragment shouFragment) {
        this.shouFragment = shouFragment;
        popTwoModel = new PopTwoModel();
    }

    @Override
    public void gettwopdata(String fid)
    {
        popTwoModel.gettwomdata(fid, new ItwoModel.TwoCallBack() {
            @Override
            public void Onsuccess(Object object) {
                shouFragment.getTwovdata(object);
            }
        });


    }
}
