package com.example.dell.m3_weiduxiangmu;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.m3_weiduxiangmu.bean.ZcBean;
import com.example.dell.m3_weiduxiangmu.login.presenter.LoginPresenter;
import com.example.dell.m3_weiduxiangmu.login.view.IloginView;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZcActivity extends AutoLayoutActivity implements IloginView, View.OnClickListener {

    @BindView(R.id.zc_phone)
    EditText zcPhone;
    @BindView(R.id.zc_pwd)
    EditText zcPwd;
    @BindView(R.id.zc)
    Button zc;
    @BindView(R.id.zc_yz)
    EditText zcYz;
    @BindView(R.id.login_zc)
    TextView loginZc;
    private LoginPresenter loginPresenter;
    private String name;
    private String pwd;
    private String yz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zc);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
        zc.setOnClickListener(this);
        loginZc.setOnClickListener(this);


    }


    @Override
    public void getzvdata(Object obj) {
        ZcBean zcBean = (ZcBean) obj;
        if (zcBean.getMessage().equals("注册成功")) {
            Toast.makeText(ZcActivity.this, zcBean.getMessage(), Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ZcActivity.this, MainActivity.class));
            finish();
        }


    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.zc:
                //获取输入框内容
                name = zcPhone.getText().toString();
                pwd = zcPwd.getText().toString();
                yz = zcYz.getText().toString();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)|| TextUtils.isEmpty(yz)) {
                    Toast.makeText(ZcActivity.this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    loginPresenter.getzpdata(name, pwd);
                }
                break;
            //已有账户立即登录
            case R.id.login_zc:
                break;
        }

    }

    @Override
    public void getvdata(Object obj) {

    }


}
