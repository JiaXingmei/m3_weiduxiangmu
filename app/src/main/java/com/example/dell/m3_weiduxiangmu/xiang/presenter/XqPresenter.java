package com.example.dell.m3_weiduxiangmu.xiang.presenter;

import com.example.dell.m3_weiduxiangmu.XiangActivity;
import com.example.dell.m3_weiduxiangmu.xiang.model.IxModel;
import com.example.dell.m3_weiduxiangmu.xiang.model.XqModel;

public class XqPresenter implements IxPresenter
{

    XiangActivity xview;
    private final XqModel xqModel;

    public XqPresenter(XiangActivity xview) {
        this.xview = xview;
        xqModel = new XqModel();
    }

    @Override
    public void getxpdata(String cid)
    {
        xqModel.getxmdata(cid, new IxModel.XqCallBack() {
            @Override
            public void getSuccess(Object object) {
                xview.getxvdata(object);
            }
        });

    }
}
