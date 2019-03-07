package com.example.dell.m3_weiduxiangmu;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.m3_weiduxiangmu.bean.DlBean;
import com.example.dell.m3_weiduxiangmu.login.presenter.LoginPresenter;
import com.example.dell.m3_weiduxiangmu.login.view.IloginView;
import com.example.dell.m3_weiduxiangmu.net.NetWorkUtils;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AutoLayoutActivity implements IloginView {

    @BindView(R.id.login_name)
    EditText loginName;
    @BindView(R.id.login_pswd)
    EditText loginPswd;
    @BindView(R.id.chec_box)
    CheckBox checBox;
    @BindView(R.id.login_zc)
    TextView btn_zc;
    @BindView(R.id.login_lgbt)
    Button btn_dl;
    @BindView(R.id.img_pro)
    ImageView imgPro;
    private LoginPresenter loginPresenter;
    private String name;
    private String pwd;
    private SharedPreferences sp;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
        sp = getSharedPreferences("config", MODE_PRIVATE);
        boolean flag = sp.getBoolean("flag", false);
        checBox.setChecked(flag);
        if (flag) {
            String phone = sp.getString("phone", "");
            String pwd = sp.getString("pwd", "");
            loginName.setText(phone);
            loginPswd.setText(pwd);
        }
        btn_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入框内容
                name = loginName.getText().toString();
                pwd = loginPswd.getText().toString();
                getNetUtils(MainActivity.this);


            }
        });

        //跳转到注册页面
        btn_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ZcActivity.class));
                finish();
            }
        });




    }


    @Override
    public void getvdata(Object obj) {
        DlBean dlBean = (DlBean) obj;
        //Log.i("hh", "getvdata" + dlBean);
        if (dlBean.getMessage().equals("登录成功")) {
            //获取userId,sessionId
            int userId = dlBean.getResult().getUserId();
            String sessionId = dlBean.getResult().getSessionId();
            Toast.makeText(MainActivity.this, dlBean.getMessage(), Toast.LENGTH_SHORT).show();
            SharedPreferences config = getSharedPreferences("config", MODE_PRIVATE);
            SharedPreferences.Editor edit = config.edit();
            edit.putInt("userId",userId);
            edit.putString("sessionId",sessionId);
            if (checBox.isChecked()) {
                edit.putString("phone", name);
                edit.putString("pwd", pwd);
                edit.putBoolean("flag", true);
            } else {
                edit.putBoolean("flag", false);
            }
            edit.commit();
            startActivity(new Intent(MainActivity.this, ShowActivity.class));

        }
    }


    //网络判断
    public void getNetUtils(Context context) {
        if (!NetWorkUtils.isNetworkConnected(context)) {
            Toast.makeText(MainActivity.this, "您已断开网络", Toast.LENGTH_SHORT).show();
            imgPro.setVisibility(View.VISIBLE);
            ObjectAnimator rotation = ObjectAnimator.ofFloat(imgPro, "rotation", 0f, 1080f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(3000);
            animatorSet.playTogether(rotation);
            animatorSet.start();

        }
        else {
            Toast.makeText(MainActivity.this, "您已连接网络", Toast.LENGTH_SHORT).show();
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
                Toast.makeText(MainActivity.this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
            } else {
                    loginPresenter.getpdata(name, pwd);
                }

        }
    }

    @Override
    public void getzvdata(Object obj) {

    }
}
