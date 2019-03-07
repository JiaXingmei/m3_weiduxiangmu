package com.example.dell.m3_weiduxiangmu.sou.model;

import android.util.Log;


import com.example.dell.m3_weiduxiangmu.api.UserApi;
import com.example.dell.m3_weiduxiangmu.bean.SouBean;
import com.example.dell.m3_weiduxiangmu.net.RetrofitUtils;


import io.reactivex.android.schedulers.AndroidSchedulers;

import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ShowModel implements Imodel {

    private UserApi userApi;

    @Override
    public void getmdata(String keyword, String page, String count, final ZsCallBack zsCallBack)
    {
        userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.getCx(keyword,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<SouBean>() {
                    @Override
                    public void onNext(SouBean value) {
                        zsCallBack.OnSuccess(value);

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
