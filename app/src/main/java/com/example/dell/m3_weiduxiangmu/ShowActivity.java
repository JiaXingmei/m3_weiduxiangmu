package com.example.dell.m3_weiduxiangmu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.dell.m3_weiduxiangmu.fragment.FenFragment;
import com.example.dell.m3_weiduxiangmu.fragment.FindFragment;
import com.example.dell.m3_weiduxiangmu.fragment.MyFragment;
import com.example.dell.m3_weiduxiangmu.fragment.ShopFragment;
import com.example.dell.m3_weiduxiangmu.fragment.ShouFragment;
import com.hjm.bottomtabbar.BottomTabBar;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AutoLayoutActivity {

    @BindView(R.id.bottom_bar)
    BottomTabBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);
        bottomBar.init(getSupportFragmentManager())
                .setImgSize(80, 80)
                .setFontSize(8)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem(" ", R.mipmap.fang, ShouFragment.class)
                .addTabItem("  ", R.mipmap.ufo, FenFragment.class)
                .addTabItem("   ", R.drawable.shop, ShopFragment.class)
                .addTabItem("    ",R.mipmap.bens , FindFragment.class)
                .addTabItem("     ", R.mipmap.mys, MyFragment.class)
                .isShowDivider(false);



    }



}
