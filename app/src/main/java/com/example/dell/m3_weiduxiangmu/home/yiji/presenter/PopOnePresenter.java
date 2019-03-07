package com.example.dell.m3_weiduxiangmu.home.yiji.presenter;

import com.example.dell.m3_weiduxiangmu.fragment.ShouFragment;
import com.example.dell.m3_weiduxiangmu.home.yiji.model.Ionemodel;
import com.example.dell.m3_weiduxiangmu.home.yiji.model.PopOneModel;

public class PopOnePresenter implements Ionepresenter {
    ShouFragment shouFragment;
    private final PopOneModel popOneModel;

    public PopOnePresenter(ShouFragment shouFragment) {
        this.shouFragment = shouFragment;
        popOneModel = new PopOneModel();
    }

    @Override
    public void getonepdata()
    {
        popOneModel.getonemdata(new Ionemodel.OneCallBack() {
            @Override
            public void Onsuccess(Object object) {
                shouFragment.getOnevdata(object);

            }
        });

    }
}
