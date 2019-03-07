package com.example.dell.m3_weiduxiangmu.quan.model;

import com.example.dell.m3_weiduxiangmu.api.UserApi;
import com.example.dell.m3_weiduxiangmu.bean.QuanBean;
import com.example.dell.m3_weiduxiangmu.net.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class QuanModel implements IqModel
{

    private UserApi userApi;

    @Override
    public void getqmdata(int page, int count, final QuanCallBack quanCallBack) {
        userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.getQz(page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<QuanBean>() {
                    @Override
                    public void onNext(QuanBean value) {
                        quanCallBack.Onsuccess(value);
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
