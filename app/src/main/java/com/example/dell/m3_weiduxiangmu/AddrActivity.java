package com.example.dell.m3_weiduxiangmu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.dell.m3_weiduxiangmu.adapter.AddrListAdapter;
import com.example.dell.m3_weiduxiangmu.bean.ShouListBean;
import com.example.dell.m3_weiduxiangmu.my.selecthuo.SelectPresenter;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddrActivity extends AutoLayoutActivity {
    @BindView(R.id.btn_zeng)
    Button btnZeng;
    @BindView(R.id.addr_view)
    RecyclerView addrView;
    private HashMap<String, Object> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addr);
        ButterKnife.bind(this);
        SelectPresenter selectPresenter = new SelectPresenter(this);
        SharedPreferences login = getSharedPreferences("config", MODE_PRIVATE);
        int userId = login.getInt("userId", 0);
        String sessionId = login.getString("sessionId", "");
        map=new HashMap<>();
        map.put("userId", userId);
        map.put("sessionId", sessionId);
        selectPresenter.gethpdata(map);
        btnZeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddrActivity.this, ZengActivity.class));
                finish();
            }
        });

    }

    public void gethvdata(Object object)
    {
        ShouListBean shouListBean = (ShouListBean) object;
        LinearLayoutManager manager = new LinearLayoutManager(this);
        addrView.setLayoutManager(manager);
        List<ShouListBean.ResultBean> list = shouListBean.getResult();
        AddrListAdapter adapter=new AddrListAdapter(AddrActivity.this,list);
        addrView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }


}
