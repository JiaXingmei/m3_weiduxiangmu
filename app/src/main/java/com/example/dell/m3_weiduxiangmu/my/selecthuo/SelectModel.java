package com.example.dell.m3_weiduxiangmu.my.selecthuo;

import com.example.dell.m3_weiduxiangmu.api.UserApi;
import com.example.dell.m3_weiduxiangmu.bean.MyWalletBean;
import com.example.dell.m3_weiduxiangmu.bean.ShouListBean;
import com.example.dell.m3_weiduxiangmu.bean.UpdataNikeBean;
import com.example.dell.m3_weiduxiangmu.bean.ZujiBean;
import com.example.dell.m3_weiduxiangmu.net.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class SelectModel implements Iselectmodel
{
    @Override
    public void gethmdata(final HashMap<String, Object> hashMap, final HuoCallBack huoCallBack)
    {
        UserApi userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.getSelect(hashMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ShouListBean>() {
                    @Override
                    public void onNext(ShouListBean value) {
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

    @Override
    public void getnmdata(final HashMap<String, Object> hashMap, String name, final HuoCallBack huoCallBack) {
        UserApi userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.getName(hashMap,name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<UpdataNikeBean>() {
                    @Override
                    public void onNext(UpdataNikeBean value) {
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

    @Override
    public void getqmdata(HashMap<String, Object> hashMap, int page, int count, final HuoCallBack huoCallBack) {
        UserApi userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.getMoney(hashMap,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<MyWalletBean>() {
                    @Override
                    public void onNext(MyWalletBean value) {
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

    @Override
    public void getzmdata(HashMap<String, Object> hashMap, int page, int count, final HuoCallBack huoCallBack)
    {
        UserApi userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.getZu(hashMap,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ZujiBean>() {
                    @Override
                    public void onNext(ZujiBean value) {
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
