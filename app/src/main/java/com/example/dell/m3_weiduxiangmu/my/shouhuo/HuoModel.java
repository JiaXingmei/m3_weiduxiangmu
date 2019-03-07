package com.example.dell.m3_weiduxiangmu.my.shouhuo;

import android.content.Context;
import android.widget.Toast;

import com.example.dell.m3_weiduxiangmu.api.UserApi;
import com.example.dell.m3_weiduxiangmu.bean.TianHuoBean;
import com.example.dell.m3_weiduxiangmu.net.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HuoModel implements Ihuomodel {

    @Override
    public void gethmdata(HashMap<String, Object> hashMap, String name, String phone, String addr, String code, final HuoCallBack huoCallBack) {
        UserApi userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.getshouhuo(hashMap,name,phone,addr,code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<TianHuoBean>() {
                    @Override
                    public void onNext(TianHuoBean value) {
                        huoCallBack.Onsuccess(value);
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
