package com.example.dell.m3_weiduxiangmu.login.model;

import android.util.Log;

import com.example.dell.m3_weiduxiangmu.api.UserApi;
import com.example.dell.m3_weiduxiangmu.bean.DlBean;
import com.example.dell.m3_weiduxiangmu.bean.ZcBean;
import com.example.dell.m3_weiduxiangmu.net.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginModel implements IloginModel
{

    private UserApi userApi;

    @Override
    public void getmdata(String phone, String pwd, final LoginCallBack loginCallBack) {
        userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.login(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<DlBean>() {
                    @Override
                    public void onNext(DlBean value) {
                        loginCallBack.OnSuccess(value);
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
    public void getzdata(String phone, String pwd, final LoginCallBack loginCallBack)
    {
        userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.zc(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ZcBean>() {
                    @Override
                    public void onNext(ZcBean value) {
                        loginCallBack.OnSuccess(value);
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
