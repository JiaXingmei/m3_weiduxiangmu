package com.example.dell.m3_weiduxiangmu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.m3_weiduxiangmu.adapter.WalletAdapter;
import com.example.dell.m3_weiduxiangmu.bean.MyWalletBean;
import com.example.dell.m3_weiduxiangmu.my.selecthuo.SelectPresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoneyActivity extends AppCompatActivity {

    @BindView(R.id.yue)
    TextView yue;
    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.cancel)
    TextView cancel;
    @BindView(R.id.production)
    TextView production;
    @BindView(R.id.ll_btn)
    LinearLayout llBtn;
    @BindView(R.id.recycle)
    RecyclerView recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
        ButterKnife.bind(this);
        SharedPreferences login =getSharedPreferences("config", MODE_PRIVATE);
        int userId = login.getInt("userId", 0);
        String sessionId = login.getString("sessionId", "");
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("sessionId", sessionId);

        SelectPresenter selectPresenter = new SelectPresenter(this);
        selectPresenter.getqpdata(map,1,1);


    }


    public void getQianData(Object obj) {
        if (obj!=null){
            MyWalletBean walletBean= (MyWalletBean) obj;
            Toast.makeText(MoneyActivity.this,walletBean.getMessage()+"",Toast.LENGTH_SHORT).show();
            money.setText(walletBean.getResult().getBalance()+"");
           LinearLayoutManager manager=new LinearLayoutManager(this);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            recycle.setLayoutManager(manager);
            WalletAdapter adapter = new WalletAdapter(this);
            recycle.setAdapter(adapter);

        }

    }
}
