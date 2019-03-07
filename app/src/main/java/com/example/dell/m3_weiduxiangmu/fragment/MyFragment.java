package com.example.dell.m3_weiduxiangmu.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.m3_weiduxiangmu.AddrActivity;
import com.example.dell.m3_weiduxiangmu.MoneyActivity;
import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.UpdataNikeActivity;
import com.example.dell.m3_weiduxiangmu.ZuActivity;
import com.example.dell.m3_weiduxiangmu.app.MyEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MyFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.text_ge)
    TextView textGe;
    @BindView(R.id.text_quan)
    TextView textQuan;
    @BindView(R.id.text_zuji)
    TextView textZuji;
    @BindView(R.id.text_money)
    TextView textMoney;
    @BindView(R.id.text_address)
    TextView textAddress;
    @BindView(R.id.my_myname)
    TextView myMyname;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        initData();
        return view;
    }

    private void initData() {
        SharedPreferences sp = getActivity().getSharedPreferences("config", Context.MODE_PRIVATE);
        String nikename = sp.getString("name", "");
        myMyname.setText(nikename);
    }


    @Subscribe
    public void onRefresh(MyEvent myEvent)
    {
        initData();
    }



    @OnClick({R.id.text_ge, R.id.text_quan, R.id.text_zuji, R.id.text_money, R.id.text_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_ge:
                startActivity(new Intent(getActivity(), UpdataNikeActivity.class));
                break;
            case R.id.text_quan:
                break;
            case R.id.text_zuji:
                startActivity(new Intent(getActivity(), ZuActivity.class));
                break;
            case R.id.text_money:
                startActivity(new Intent(getActivity(), MoneyActivity.class));
                break;
            case R.id.text_address:
                startActivity(new Intent(getActivity(), AddrActivity.class));
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
