package com.example.dell.m3_weiduxiangmu.quan.presenter;

import com.example.dell.m3_weiduxiangmu.fragment.FenFragment;
import com.example.dell.m3_weiduxiangmu.quan.model.IqModel;
import com.example.dell.m3_weiduxiangmu.quan.model.QuanModel;

public class QuanPresenter implements IqPresenter
{
    FenFragment fenFragment;
    private final QuanModel quanModel;

    public QuanPresenter(FenFragment fenFragment) {
        this.fenFragment = fenFragment;
        quanModel = new QuanModel();
    }

    @Override
    public void getqPdata(int page, int count)
    {
        quanModel.getqmdata(page, count, new IqModel.QuanCallBack() {
            @Override
            public void Onsuccess(Object object) {
                fenFragment.getqVdata(object);
            }
        });

    }
}
