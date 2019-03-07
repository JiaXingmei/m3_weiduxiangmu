package com.example.dell.m3_weiduxiangmu.home.yiji.model;

import com.example.dell.m3_weiduxiangmu.api.UserApi;
import com.example.dell.m3_weiduxiangmu.bean.PopOneBean;
import com.example.dell.m3_weiduxiangmu.net.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class PopOneModel implements Ionemodel{
    @Override
    public void getonemdata(final OneCallBack oneCallBack)
    {
        UserApi userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.getOne()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<PopOneBean>() {
                    @Override
                    public void onNext(PopOneBean value) {
                        oneCallBack.Onsuccess(value);
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
