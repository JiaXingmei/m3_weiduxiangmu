package com.example.dell.m3_weiduxiangmu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dell.m3_weiduxiangmu.bean.TianHuoBean;
import com.example.dell.m3_weiduxiangmu.my.shouhuo.HuoPresenter;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.leefeng.citypicker.CityPicker;
import me.leefeng.citypicker.CityPickerListener;

public class ZengActivity extends AutoLayoutActivity implements CityPickerListener {
    @BindView(R.id.btn_right)
    ImageView btnRight;
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.edit_diqu)
    EditText editDiqu;
    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_deil)
    EditText editDeil;
    @BindView(R.id.edit_code)
    EditText editCode;
    private CityPicker cityPicker;
    private HuoPresenter huoPresenter;
    private HashMap<String, Object> map;
    private TianHuoBean tianHuoBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeng);
        ButterKnife.bind(this);
        huoPresenter = new HuoPresenter(this);
        cityPicker = new CityPicker(ZengActivity.this, this);
        SharedPreferences login = getSharedPreferences("config", MODE_PRIVATE);
        int userId = login.getInt("userId", 0);
        String sessionId = login.getString("sessionId", "");
        map = new HashMap<>();
        map.put("userId", userId);
        map.put("sessionId", sessionId);


    }

    @Override
    public void getCity(String s) {
        editDiqu.setText(s);
    }

    public void gethvdata(Object object) {
        if (object != null) {
            tianHuoBean = (TianHuoBean) object;
        }
        if (tianHuoBean.getMessage().equals("添加成功")) {
            Toast.makeText(ZengActivity.this, tianHuoBean.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    @OnClick({R.id.btn_right, R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_right:
                cityPicker.show();
                break;
            case R.id.btn_save:
                String name = editName.getText().toString();
                String phone = editPhone.getText().toString();
                String deil = editDeil.getText().toString();
                String code = editCode.getText().toString();
                String diqu = editDiqu.getText().toString();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(deil) || TextUtils.isEmpty(code) || TextUtils.isEmpty(diqu)) {
                    Toast.makeText(ZengActivity.this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    huoPresenter.gethpdata(map, name, phone, diqu, code);
                }
                startActivity(new Intent(ZengActivity.this,AddrActivity.class));
                finish();
                break;
        }
    }
}


