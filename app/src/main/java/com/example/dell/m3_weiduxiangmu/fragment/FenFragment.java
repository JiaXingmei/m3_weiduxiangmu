package com.example.dell.m3_weiduxiangmu.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.adapter.QuanAdapter;
import com.example.dell.m3_weiduxiangmu.bean.QuanBean;
import com.example.dell.m3_weiduxiangmu.quan.presenter.QuanPresenter;
import com.example.dell.m3_weiduxiangmu.quan.view.IqView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.Logger;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FenFragment extends Fragment implements IqView {
    @BindView(R.id.xrecy_view)
    XRecyclerView xrecyView;
    Unbinder unbinder;
    private QuanPresenter quanPresenter;
    int page=1;
    int count=10;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quan, container, false);
        unbinder = ButterKnife.bind(this, view);
        quanPresenter = new QuanPresenter(this);
        quanPresenter.getqPdata(page,count);
        xrecyView.setPullRefreshEnabled(true);
        xrecyView.setLoadingMoreEnabled(true);
        xrecyView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        page=1;
                        quanPresenter.getqPdata(page,count);
                        xrecyView.refreshComplete();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        page++;
                        quanPresenter.getqPdata(page,count);
                        xrecyView.loadMoreComplete();
                    }
                },2000);

            }
        });
        return view;
    }

    @Override
    public void getqVdata(Object object)
    {
        QuanBean quanBean= (QuanBean) object;
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        xrecyView.setLayoutManager(manager);
        List<QuanBean.ResultBean> list = quanBean.getResult();
        QuanAdapter adapter=new QuanAdapter(getActivity(),list);
        xrecyView.setAdapter(adapter);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
