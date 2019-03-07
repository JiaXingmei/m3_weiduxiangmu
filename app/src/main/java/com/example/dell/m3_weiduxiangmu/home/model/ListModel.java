package com.example.dell.m3_weiduxiangmu.home.model;

import com.example.dell.m3_weiduxiangmu.api.UserApi;
import com.example.dell.m3_weiduxiangmu.bean.BannerBean;
import com.example.dell.m3_weiduxiangmu.bean.ShowBean;
import com.example.dell.m3_weiduxiangmu.net.RetrofitUtils;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ListModel implements Imodel
{
    private UserApi userApi;



    @Override
    public void getMdata(final ListCallBack listCallback)
    {
        userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<BannerBean>() {
                    @Override
                    public void onNext(BannerBean value) {
                        listCallback.getSuccess(value);
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
    public void getmdata(final ZsCallBack zsCallBack)
    {
        userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.getcommodity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ShowBean>() {
                    @Override
                    public void onNext(ShowBean value) {
                        zsCallBack.OnSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        zsCallBack.OnFaie(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
