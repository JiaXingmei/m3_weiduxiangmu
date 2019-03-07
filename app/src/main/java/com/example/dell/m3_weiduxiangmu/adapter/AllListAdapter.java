package com.example.dell.m3_weiduxiangmu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.bean.OrderListByStatusBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class AllListAdapter extends RecyclerView.Adapter<AllListAdapter.MyViewHolder> {
    private Context context;
    private List<OrderListByStatusBean.OrderListBean.DetailListBean> list;

    public AllListAdapter(Context context, List<OrderListByStatusBean.OrderListBean.DetailListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.list_layout, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.alllist_img.setImageURI(list.get(position).getCommodityPic());
        holder.alllist_price.setText("¥"+list.get(position).getCommodityPrice()+"");
        holder.alllist_title.setText(list.get(position).getCommodityName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView alllist_title;
        private final TextView alllist_price;
        private final SimpleDraweeView alllist_img;

        public MyViewHolder(View itemView) {
            super(itemView);
            alllist_title = itemView.findViewById(R.id.alllist_title);
            alllist_price = itemView.findViewById(R.id.alllist_price);
            alllist_img = itemView.findViewById(R.id.alllist_img);


        }
    }
}
