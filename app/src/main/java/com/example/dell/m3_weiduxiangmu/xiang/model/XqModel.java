package com.example.dell.m3_weiduxiangmu.xiang.model;

import com.example.dell.m3_weiduxiangmu.api.UserApi;
import com.example.dell.m3_weiduxiangmu.bean.XiangBean;
import com.example.dell.m3_weiduxiangmu.net.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class XqModel implements IxModel
{

    private UserApi userApi;

    @Override
    public void getxmdata(String cid, final XqCallBack xqCallBack) {
        userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.getXq(cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<XiangBean>() {
                    @Override
                    public void onNext(XiangBean value) {
                        xqCallBack.getSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
