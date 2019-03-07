package com.example.dell.m3_weiduxiangmu.fragment.radio;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.adapter.StatusAdapter;
import com.example.dell.m3_weiduxiangmu.bean.OrderListByStatusBean;
import com.example.dell.m3_weiduxiangmu.dingdan.presenter.DingPresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

public class AllFragment extends Fragment {

    @BindView(R.id.srecy_view)
    RecyclerView srecyView;
    Unbinder unbinder;
    private HashMap<String, Object> map;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        unbinder = ButterKnife.bind(this, view);
        DingPresenter dingPresenter = new DingPresenter(this);
        SharedPreferences login = getActivity().getSharedPreferences("config", MODE_PRIVATE);
        int userId = login.getInt("userId", 0);
        String sessionId = login.getString("sessionId", "");
        map = new HashMap<>();
        map.put("userId", userId);
        map.put("sessionId", sessionId);
        dingPresenter.getallpdata(map, 0, 1, 5);
        return view;
    }

    public void getallvdata(Object object) {
        OrderListByStatusBean statusBean = (OrderListByStatusBean) object;
        List<OrderListByStatusBean.OrderListBean> orderList = statusBean.getOrderList();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        srecyView.setLayoutManager(manager);
        StatusAdapter adapter=new StatusAdapter(getActivity(),statusBean);
        srecyView.setAdapter(adapter);



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
