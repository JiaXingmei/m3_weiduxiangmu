package com.example.dell.m3_weiduxiangmu;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.dell.m3_weiduxiangmu.adapter.ItemAdapter3;
import com.example.dell.m3_weiduxiangmu.adapter.ZuAdapter;
import com.example.dell.m3_weiduxiangmu.bean.ZujiBean;
import com.example.dell.m3_weiduxiangmu.my.selecthuo.SelectPresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZuActivity extends AppCompatActivity {


    @BindView(R.id.lrevy_view)
    RecyclerView lrevyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zu);
        ButterKnife.bind(this);
        SelectPresenter selectPresenter = new SelectPresenter(this);
        SharedPreferences login = getSharedPreferences("config", MODE_PRIVATE);
        int userId = login.getInt("userId", 0);
        String sessionId = login.getString("sessionId", "");
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("sessionId", sessionId);
        selectPresenter.getzpdata(map, 1, 5);

    }

    public void getzvdata(Object object) {
        ZujiBean zujiBean = (ZujiBean) object;
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        lrevyView.setLayoutManager(manager);
        List<ZujiBean.ResultBean> list = zujiBean.getResult();
        ZuAdapter zuAdapter = new ZuAdapter(ZuActivity.this, list);
        lrevyView.setAdapter(zuAdapter);


    }
}
