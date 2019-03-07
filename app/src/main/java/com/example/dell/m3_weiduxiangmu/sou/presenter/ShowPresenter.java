package com.example.dell.m3_weiduxiangmu.sou.presenter;

import com.example.dell.m3_weiduxiangmu.fragment.ShouFragment;
import com.example.dell.m3_weiduxiangmu.sou.model.Imodel;
import com.example.dell.m3_weiduxiangmu.sou.model.ShowModel;

public class ShowPresenter implements Isoupresenter
{
    ShouFragment shouFragment;
    private final ShowModel showModel;

    public ShowPresenter(ShouFragment shouFragment) {
        this.shouFragment = shouFragment;
        showModel = new ShowModel();
    }

    @Override
    public void getspdata(String keyword, String page, String count)
    {
        showModel.getmdata(keyword, page, count, new Imodel.ZsCallBack() {
            @Override
            public void OnSuccess(Object object) {
                shouFragment.getsvdata(object);
            }

            @Override
            public void OnFaie(Throwable e) {

            }
        });

    }
}
