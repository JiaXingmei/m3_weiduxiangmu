package com.example.dell.m3_weiduxiangmu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.bean.OrderListByStatusBean;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.MyViewHolder> {
    private Context context;
    private OrderListByStatusBean sbean;

    public StatusAdapter(Context context, OrderListByStatusBean sbean) {
        this.context = context;
        this.sbean = sbean;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.status_layout, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.orderId.setText(sbean.getOrderList().get(position).getOrderId());
        List<OrderListByStatusBean.OrderListBean.DetailListBean> detailList = sbean.getOrderList().get(position).getDetailList();
        holder.allordersCount.setText(detailList.get(0).getCommodityCount()+"");
        holder.allordersPrice.setText(detailList.get(0).getCommodityPrice()+"");
        //holder.allordersDate.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(mlist.get(position).getCreateTime())));
        LinearLayoutManager manager = new LinearLayoutManager(context);
        holder.all_recycle.setLayoutManager(manager);
        //创建适配器
        AllListAdapter listAdapter = new AllListAdapter(context,detailList);
        holder.all_recycle.setAdapter(listAdapter);


    }

    @Override
    public int getItemCount() {
        return sbean.getOrderList().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView orderId;
        private final TextView allordersCount;
        private final TextView allordersPrice;
        private final RecyclerView all_recycle;
        private final TextView allordersDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            orderId = itemView.findViewById(R.id.orderId);
            allordersCount = itemView.findViewById(R.id.allordersCount);
            allordersPrice = itemView.findViewById(R.id.allordersPrice);
            all_recycle = itemView.findViewById(R.id.all_recycle);
            allordersDate = itemView.findViewById(R.id.allordersDate);


        }
    }
}
