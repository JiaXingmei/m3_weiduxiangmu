package com.example.dell.m3_weiduxiangmu.home.erji.model;

import com.example.dell.m3_weiduxiangmu.api.UserApi;
import com.example.dell.m3_weiduxiangmu.bean.PopTwoBean;
import com.example.dell.m3_weiduxiangmu.net.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class PopTwoModel implements ItwoModel {
    @Override
    public void gettwomdata(String fid, final TwoCallBack twoCallBack) {
        UserApi userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.getTwo(fid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<PopTwoBean>() {
                    @Override
                    public void onNext(PopTwoBean value) {
                        twoCallBack.Onsuccess(value);
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
