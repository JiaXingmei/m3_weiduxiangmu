package com.example.dell.m3_weiduxiangmu.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.adapter.Fadapter;
import com.example.dell.m3_weiduxiangmu.bean.DingDanBean;
import com.example.dell.m3_weiduxiangmu.dingdan.presenter.DingPresenter;
import com.example.dell.m3_weiduxiangmu.dingdan.view.Idingview;
import com.example.dell.m3_weiduxiangmu.fragment.radio.AllFragment;
import com.example.dell.m3_weiduxiangmu.fragment.radio.FinishFragment;
import com.example.dell.m3_weiduxiangmu.fragment.radio.HuoFragment;
import com.example.dell.m3_weiduxiangmu.fragment.radio.PayFragment;
import com.example.dell.m3_weiduxiangmu.fragment.radio.PingFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

public class FindFragment extends Fragment implements Idingview {

    @BindView(R.id.rd1)
    RadioButton rd1;
    @BindView(R.id.rd2)
    RadioButton rd2;
    @BindView(R.id.rd3)
    RadioButton rd3;
    @BindView(R.id.rd4)
    RadioButton rd4;
    @BindView(R.id.rd5)
    RadioButton rd5;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.view_page)
    ViewPager viewPage;
    Unbinder unbinder;
    private DingPresenter dingPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay, container, false);
        unbinder = ButterKnife.bind(this, view);
        getRadio();
        return view;
    }

    @Override
    public void getdvdata(Object object) {
        DingDanBean dingDanBean = (DingDanBean) object;


    }
    private void getRadio()
    {
        List<Fragment> flist = new ArrayList<>();
        flist.add(new AllFragment());
        flist.add(new HuoFragment());
        flist.add(new FinishFragment());
        flist.add(new PayFragment());
        flist.add(new PingFragment());
        //创建适配器
        Fadapter fAdapter = new Fadapter(getActivity().getSupportFragmentManager(), flist);
        viewPage.setAdapter(fAdapter);
        viewPage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                radioGroup.check(radioGroup.getChildAt(i).getId());
            }
            @Override
            public void onPageSelected(int i) {

            }
            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rd1:
                        viewPage.setCurrentItem(0, false);
                        break;
                    case R.id.rd2:
                        viewPage.setCurrentItem(1, false);
                        break;
                    case R.id.rd3:
                        viewPage.setCurrentItem(2, false);
                        break;
                    case R.id.rd4:
                        viewPage.setCurrentItem(3, false);
                        break;
                    case R.id.rd5:
                        viewPage.setCurrentItem(4, false);
                        break;
                }
            }
        });
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
