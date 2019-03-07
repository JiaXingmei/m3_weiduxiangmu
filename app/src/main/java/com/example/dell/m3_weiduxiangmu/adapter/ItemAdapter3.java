package com.example.dell.m3_weiduxiangmu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.bean.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class ItemAdapter3 extends RecyclerView.Adapter<ItemAdapter3.ViewHolder>
{
    private Context context;
    private List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> list;
    private View view;

    public ItemAdapter3(Context context, List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ItemAdapter3.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.s33_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter3.ViewHolder holder, final int position)
    {
        holder.text_name.setText(list.get(position).getCommodityName());
        holder.sim_view.setImageURI(list.get(position).getMasterPic());
        holder.text_price.setText("¥"+list.get(position).getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(list.get(position).getCommodityId()+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {

         private final TextView text_name;
         private final TextView text_price;
         private final SimpleDraweeView sim_view;

         public ViewHolder(View itemView) {
             super(itemView);
             text_name = itemView.findViewById(R.id.text_name);
             text_price = itemView.findViewById(R.id.text_price);
             sim_view = itemView.findViewById(R.id.sim_view);
         }
     }
}
