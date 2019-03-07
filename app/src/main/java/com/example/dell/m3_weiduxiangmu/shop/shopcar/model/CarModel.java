package com.example.dell.m3_weiduxiangmu.shop.shopcar.model;

import com.example.dell.m3_weiduxiangmu.api.UserApi;
import com.example.dell.m3_weiduxiangmu.bean.ShopBean;
import com.example.dell.m3_weiduxiangmu.net.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class CarModel implements IcarModel
{
    @Override
    public void getCarmdata(HashMap<String, Object> hashMap, final ShopCarCallBack shopCarCallBack) {
        UserApi userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.getCar(hashMap)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableObserver<ShopBean>() {
                    @Override
                    public void onNext(ShopBean value) {
                        shopCarCallBack.Onsuccess(value);
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
