package com.example.dell.m3_weiduxiangmu;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.m3_weiduxiangmu.bean.UpdataNikeBean;
import com.example.dell.m3_weiduxiangmu.my.selecthuo.SelectPresenter;
import com.example.dell.m3_weiduxiangmu.app.MyEvent;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhy.autolayout.AutoLayoutActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UpdataNikeActivity extends AutoLayoutActivity {
    private static final String TAG = "UpdataNikeActivity";

    @BindView(R.id.btn_tou)
    SimpleDraweeView btnTou;
    @BindView(R.id.my_name)
    EditText myName;
    @BindView(R.id.my_pwd)
    EditText myPwd;
    @BindView(R.id.btn_save)
    Button btnSave;
    private SelectPresenter selectPresenter;
    private HashMap<String, Object> map;
    private String name;
    private SharedPreferences.Editor edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_nike);
        ButterKnife.bind(this);
        selectPresenter = new SelectPresenter(this);
        SharedPreferences login = getSharedPreferences("config", MODE_PRIVATE);
        int userId = login.getInt("userId", 0);
        String sessionId = login.getString("sessionId", "");
        map = new HashMap<>();
        map.put("userId", userId);
        map.put("sessionId", sessionId);
        getData();

    }

    private void getData()
    {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = myName.getText().toString();
                if (TextUtils.isEmpty(name))
                {
                    Toast.makeText(UpdataNikeActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                }
                else
                 {
                    selectPresenter.getnpdata(map, name);
                  }
            }
        });
    }

    public void getnvdata(Object object) {
        UpdataNikeBean bean = (UpdataNikeBean) object;
        if (bean.getStatus().equals("0000")) {
            Toast.makeText(UpdataNikeActivity.this, bean.getMessage(), Toast.LENGTH_SHORT).show();
            SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
            edit = sp.edit();
            edit.putString("name", name);
            edit.commit();
            EventBus.getDefault().post(new MyEvent());
            finish();
        }

    }


}
