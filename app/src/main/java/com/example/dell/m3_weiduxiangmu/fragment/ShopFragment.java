package com.example.dell.m3_weiduxiangmu.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.adapter.ShopAdapter;
import com.example.dell.m3_weiduxiangmu.bean.ShopBean;
import com.example.dell.m3_weiduxiangmu.shop.shopcar.presenter.CarPresenter;
import com.example.dell.m3_weiduxiangmu.shop.shopcar.view.IcarView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

public class ShopFragment extends Fragment implements IcarView {
    @BindView(R.id.shop_view)
    XRecyclerView shopView;
    @BindView(R.id.iv_cricle)
    CheckBox ivCricle;
    @BindView(R.id.txt_all)
    TextView txtAll;
    @BindView(R.id.layout_all)
    RelativeLayout layoutAll;
    @BindView(R.id.total_price)
    TextView totalPrice;
    @BindView(R.id.total_num)
    TextView totalNum;
    @BindView(R.id.sum_price)
    RelativeLayout sumPrice;
    @BindView(R.id.layout_buttom)
    RelativeLayout layoutButtom;
    Unbinder unbinder;
    private CarPresenter carPresenter;
    private int userId;
    private String sessionId;
    private ShopBean shopBean;
    private ShopAdapter shopadapter;
    private List<ShopBean.ResultBean> mlist;
    private String count;
    private HashMap<String, Object> map;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        //注册
        EventBus.getDefault().register(this);
        carPresenter = new CarPresenter(this);
        SharedPreferences login = getActivity().getSharedPreferences("config", MODE_PRIVATE);
        userId = login.getInt("userId", 0);
        sessionId = login.getString("sessionId", "");
        map = new HashMap<>();
        map.put("userId", userId);
        map.put("sessionId", sessionId);
        carPresenter.getCarpdata(map);
        shopView.setPullRefreshEnabled(true);
        shopView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        carPresenter.getCarpdata(map);
                        shopView.refreshComplete();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {

            }
        });
        //全选的点击事件
        ivCricle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<ShopBean.ResultBean> result = shopBean.getResult();
                if (result!=null)
                {
                    for (int i = 0; i < result.size(); i++)
                    {
                        if (ivCricle.isChecked())
                        {
                            result.get(i).setIscheck(true);
                        }
                        else
                        {
                            result.get(i).setIscheck(false);
                        }
                    }
                    shopadapter.notifyDataSetChanged();
                    //全选改变总价
                    getTotalPrice();
                }
            }
        });

        return view;
    }

    //判断商品是否全部选中从而选中多选框
    public void isAllChecked()
    {
        int checkSum=0;
        int size=0;
        List<ShopBean.ResultBean> result = shopBean.getResult();
        for (int i = 0; i < result.size(); i++) {
            size++;
            boolean checked = result.get(i).isIscheck();
            if (checked){
                checkSum++;
            }
        }
        //如果集合中条目的数量和选中的数量相等的话 全选框设置
        if (checkSum==size){
            ivCricle.setChecked(true);
        }
        else {
            ivCricle.setChecked(false);
        }
        //并且更新总价
        getTotalPrice();
    }
    //获取总价
    private void getTotalPrice()
    {
        int priceSum = 0;
        int num=0;
        List<ShopBean.ResultBean> result = shopBean.getResult();
        for (int i = 0; i < result.size(); i++)
        {
            if (result.get(i).isIscheck()){
                count = result.get(i).getCount();
                int price = result.get(i).getPrice();
                priceSum+=Integer.parseInt(count)*price;
                num+=Integer.parseInt(result.get(i).getCount());
            }
        }
        totalPrice.setText("合计:"+priceSum);
        totalNum.setText("去结算"+"("+num+")");


    }


    @Override
    public void getCarvdata(Object object)
    {
        shopBean = (ShopBean) object;
        List<ShopBean.ResultBean> slist = shopBean.getResult();
        //创建布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        shopView.setLayoutManager(manager);
        shopadapter = new ShopAdapter(getActivity(),slist);
        shopView.setAdapter(shopadapter);
        shopadapter.notifyDataSetChanged();
        mlist = shopBean.getResult();
        //条目多选框接口回调
        shopadapter.setItemCheckOnClickListner(new ShopAdapter.ItemCheckOnClickListner() {
            @Override
            public void click(int commodityId, boolean isChecked) {
                if (isChecked)
                {
                    List<ShopBean.ResultBean> result = shopBean.getResult();
                    for (int i = 0; i < result.size(); i++) {
                        int commodityId1 = result.get(i).getCommodityId();
                        if (commodityId == commodityId1) {
                            result.get(i).setIscheck(isChecked);
                        }
                    }
                    shopadapter.notifyDataSetChanged();
                    isAllChecked();
                }
                else{
                    List<ShopBean.ResultBean> result = shopBean.getResult();
                    for (int i = 0; i < result.size(); i++) {
                        int commodityId1 = result.get(i).getCommodityId();
                        if (commodityId == commodityId1) {
                            result.get(i).setIscheck(isChecked);
                        }
                    }
                    shopadapter.notifyDataSetChanged();
                    //判断是否已经被动全选和更新价格
                    isAllChecked();
                }
            }
        });


    }

    @Subscribe//一定要写
    public void getMsg(String msg) {
        /*Intent intent = new Intent(getActivity(), DingDanActivity.class);
        intent.putExtra("pid", msg);
        startActivity(intent);*/

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
}
