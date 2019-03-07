package com.example.dell.m3_weiduxiangmu.shop.model;

import com.example.dell.m3_weiduxiangmu.api.UserApi;
import com.example.dell.m3_weiduxiangmu.bean.SyncBean;
import com.example.dell.m3_weiduxiangmu.net.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ShopModel implements IshopModel
{

    @Override
    public void getsmdata(HashMap<String, Object> hashMap, String data, final ShopCallBack shopCallBack) {
        UserApi userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.getSync(hashMap,data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<SyncBean>() {
                    @Override
                    public void onNext(SyncBean value) {
                        shopCallBack.Onsuccess(value);
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
