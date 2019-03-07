package com.example.dell.m3_weiduxiangmu.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.XiangActivity;
import com.example.dell.m3_weiduxiangmu.adapter.PopOneAdapter;
import com.example.dell.m3_weiduxiangmu.adapter.PopTwoAdapter;
import com.example.dell.m3_weiduxiangmu.adapter.ShowAdapter;
import com.example.dell.m3_weiduxiangmu.adapter.SouAdapter;
import com.example.dell.m3_weiduxiangmu.bean.BannerBean;
import com.example.dell.m3_weiduxiangmu.bean.PopOneBean;
import com.example.dell.m3_weiduxiangmu.bean.PopTwoBean;
import com.example.dell.m3_weiduxiangmu.bean.ShowBean;
import com.example.dell.m3_weiduxiangmu.bean.SouBean;
import com.example.dell.m3_weiduxiangmu.home.erji.presenter.PopTwoPresenter;
import com.example.dell.m3_weiduxiangmu.home.presenter.ListPresenter;
import com.example.dell.m3_weiduxiangmu.home.view.Iview;
import com.example.dell.m3_weiduxiangmu.home.yiji.presenter.PopOnePresenter;
import com.example.dell.m3_weiduxiangmu.net.NetWorkUtils;
import com.example.dell.m3_weiduxiangmu.sou.presenter.ShowPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ShouFragment extends Fragment implements Iview {

    @BindView(R.id.recy_view)
    RecyclerView recyView;
    Unbinder unbinder;
    @BindView(R.id.search_sou)
    EditText searchSou;
    @BindView(R.id.text_sou)
    TextView textSou;
    @BindView(R.id.sou_view)
    RecyclerView souView;
    @BindView(R.id.img_pop)
    ImageView imgPop;
    @BindView(R.id.img_pro1)
    ImageView imgPro1;


    private ListPresenter listPresenter;
    private ShowBean showBean;
    private ShowAdapter adapter;
    private BannerBean bannerBean;
    private ShowPresenter showPresenter;
    private SouBean souBean;
    private PopOnePresenter popOnePresenter;
    private PopOneBean popOneBean;
    private RecyclerView popone_view;
    private RecyclerView poptwo_view;
    private PopTwoPresenter twoPresenter;
    private PopTwoBean popTwoBean;
    private String firstCategoryId;
    private RecyclerView ssou_view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shou, container, false);
        unbinder = ButterKnife.bind(this, view);
        //注册
        EventBus.getDefault().register(this);
        listPresenter = new ListPresenter(this);
        showPresenter = new ShowPresenter(this);
        popOnePresenter = new PopOnePresenter(this);
        twoPresenter = new PopTwoPresenter(this);
        getNetUtils(getActivity());

       /* listPresenter.getPdata();
        listPresenter.getpdata();*/


        //搜索框的点击事件
        textSou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
        //左侧按钮的点击事件
        imgPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPop();
            }
        });
        return view;
    }


    //轮播图
    @Override
    public void getVdata(Object obj) {
        bannerBean = (BannerBean) obj;
        adapter = new ShowAdapter(getActivity(), showBean, bannerBean);
        recyView.setAdapter(adapter);

    }

    //展示列表
    @Override
    public void getvdata(Object obj) {
        if (obj != null) {
            showBean = (ShowBean) obj;
        }
        //Log.i("hh","getvdata"+showBean.getMessage());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyView.setLayoutManager(manager);
        adapter = new ShowAdapter(getActivity(), showBean, bannerBean);
        recyView.setAdapter(adapter);

    }

    public void getData() {
        String keyword = searchSou.getText().toString();
        if (TextUtils.isEmpty(keyword)) {
            Toast.makeText(getContext(), "请输入关键字", Toast.LENGTH_SHORT).show();
        } else {
            showPresenter.getspdata(keyword, "1", "8");
        }

        View view = View.inflate(getActivity(), R.layout.sou_layout, null);
        ssou_view = view.findViewById(R.id.ssou_view);
        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(view, Gravity.CENTER_VERTICAL, 0, -500);
    }

    //搜索框
    public void getsvdata(Object object) {
        if (object != null) {
            souBean = (SouBean) object;
        }
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        ssou_view.setLayoutManager(manager);
        List<SouBean.ResultBean> slist = souBean.getResult();
        SouAdapter adapter3 = new SouAdapter(getActivity(), slist);
        ssou_view.setAdapter(adapter3);
    }

    //左侧按钮的点击事件
    private void getPop() {
        View view = View.inflate(getActivity(), R.layout.pop_layout, null);
        popone_view = view.findViewById(R.id.popone_view);
        poptwo_view = view.findViewById(R.id.poptwo_view);

        //pop
        popOnePresenter.getonepdata();

        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAtLocation(view, Gravity.CENTER_VERTICAL, 0, -700);


    }

    //pop一级列表
    public void getOnevdata(Object object) {
        if (object != null) {
            popOneBean = (PopOneBean) object;
        }
        //创建布局管理器
        popone_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        PopOneAdapter popOneAdapter = new PopOneAdapter(getActivity(), popOneBean);
        popone_view.setAdapter(popOneAdapter);
        popOneAdapter.result(new PopOneAdapter.Cicklistener() {
            @Override
            public void setonclicklisener(int position) {
                String id = popOneBean.getResult().get(position).getId();
                twoPresenter.gettwopdata(id);


            }
        });

    }

    //pop二级列表
    public void getTwovdata(Object object) {
        if (object != null) {
            popTwoBean = (PopTwoBean) object;
        }

        //创建布局管理器
        poptwo_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        List<PopTwoBean.ResultBean> list = popTwoBean.getResult();
        PopTwoAdapter poptwoAdapter = new PopTwoAdapter(getActivity(), list);
        poptwo_view.setAdapter(poptwoAdapter);

    }


    @Subscribe//一定要写
    public void getMsg(String msg) {
        Intent intent = new Intent(getActivity(), XiangActivity.class);
        intent.putExtra("cid", msg);
        startActivity(intent);

    }


    //反注册
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //网络判断
    public void getNetUtils(Context context) {
        if (!NetWorkUtils.isNetworkConnected(context))
        {
            Toast.makeText(getActivity(), "您已断开网络", Toast.LENGTH_SHORT).show();
            imgPro1.setVisibility(View.VISIBLE);
            ObjectAnimator rotation = ObjectAnimator.ofFloat(imgPro1, "rotation", 0f, 1080f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(3000);
            animatorSet.playTogether(rotation);
            animatorSet.start();
        }
        else{
            listPresenter.getPdata();
            listPresenter.getpdata();
        }
    }


    }
