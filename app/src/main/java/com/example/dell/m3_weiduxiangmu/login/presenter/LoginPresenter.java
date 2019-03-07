package com.example.dell.m3_weiduxiangmu.login.presenter;

import com.example.dell.m3_weiduxiangmu.MainActivity;
import com.example.dell.m3_weiduxiangmu.ZcActivity;
import com.example.dell.m3_weiduxiangmu.api.Api;
import com.example.dell.m3_weiduxiangmu.login.model.IloginModel;
import com.example.dell.m3_weiduxiangmu.login.model.LoginModel;

public class LoginPresenter implements IloginPresnter
{
    MainActivity mview;
    private final LoginModel loginModel;

    public LoginPresenter(MainActivity mview) {
        this.mview = mview;
        loginModel = new LoginModel();

    }

    ZcActivity zview;
    public LoginPresenter(ZcActivity zview) {
        this.zview = zview;
        loginModel = new LoginModel();
    }

    @Override
    public void getpdata(String phone, String pwd)
    {
        loginModel.getmdata(phone, pwd, new IloginModel.LoginCallBack() {
            @Override
            public void OnSuccess(Object object) {
                mview.getvdata(object);
            }
        });
    }

    @Override
    public void getzpdata(String phone, String pwd)
    {
        loginModel.getzdata(phone, pwd, new IloginModel.LoginCallBack() {
            @Override
            public void OnSuccess(Object object) {
                zview.getzvdata(object);
            }
        });

    }
}
