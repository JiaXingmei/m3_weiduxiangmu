package com.example.dell.m3_weiduxiangmu.home.presenter;

import com.example.dell.m3_weiduxiangmu.fragment.ShouFragment;
import com.example.dell.m3_weiduxiangmu.home.model.Imodel;
import com.example.dell.m3_weiduxiangmu.home.model.ListModel;


public class ListPresenter implements Ipresenter
{
    ShouFragment shouFragment;
    private final ListModel listModel;

    public ListPresenter(ShouFragment shouFragment) {
        this.shouFragment = shouFragment;
        listModel = new ListModel();
    }

    @Override
    public void getPdata()
    {
       listModel.getMdata(new Imodel.ListCallBack() {
           @Override
           public void getSuccess(Object object) {
               shouFragment.getVdata(object);
           }
       });

    }

    @Override
    public void getpdata()
    {
        listModel.getmdata(new Imodel.ZsCallBack() {
            @Override
            public void OnSuccess(Object object) {
                shouFragment.getvdata(object);
            }

            @Override
            public void OnFaie(Throwable e) {

            }
        });


    }
}
