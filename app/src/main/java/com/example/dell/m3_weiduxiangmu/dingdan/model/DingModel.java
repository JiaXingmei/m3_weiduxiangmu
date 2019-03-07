package com.example.dell.m3_weiduxiangmu.dingdan.model;

import com.example.dell.m3_weiduxiangmu.api.UserApi;
import com.example.dell.m3_weiduxiangmu.bean.DingDanBean;
import com.example.dell.m3_weiduxiangmu.bean.OrderListByStatusBean;
import com.example.dell.m3_weiduxiangmu.net.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class DingModel implements Idingmodel
{
    @Override
    public void getdmdata(HashMap<String, Object> hashMap, int addressId, double totalPrice, HashMap<String, Object> ordermap, final DingCallBack dingCallBack) {
        UserApi userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.getDingdan(hashMap,addressId,totalPrice,ordermap)
               //处理io流
                .subscribeOn(Schedulers.io())
                //切换到主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<DingDanBean>() {
                    @Override
                    public void onNext(DingDanBean value) {
                        dingCallBack.Onsuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void getallmdata(HashMap<String, Object> hashMap, int status, int page, int count, final DingCallBack dingCallBack) {
        UserApi userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.getStatus(hashMap,status,page,count)
                //处理io流
                .subscribeOn(Schedulers.io())
                //切换到主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<OrderListByStatusBean>() {
                    @Override
                    public void onNext(OrderListByStatusBean value) {
                        dingCallBack.Onsuccess(value);
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
