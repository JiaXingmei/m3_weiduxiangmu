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

public class ItemAdapter2 extends RecyclerView.Adapter<ItemAdapter2.ViewHolder>
{
    private Context context;
    private List<ShowBean.ResultBean.MlssBean.CommodityListBeanXX> list;
    private View view;

    public ItemAdapter2(Context context, List<ShowBean.ResultBean.MlssBean.CommodityListBeanXX> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ItemAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.s22_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter2.ViewHolder holder, final int position)
    {
        holder.text_name2.setText(list.get(position).getCommodityName());
        holder.sim_view2.setImageURI(list.get(position).getMasterPic());
        holder.text_price2.setText("¥"+list.get(position).getPrice());
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

         private final TextView text_name2;
         private final TextView text_price2;
         private final SimpleDraweeView sim_view2;

         public ViewHolder(View itemView) {
             super(itemView);
             text_name2 = itemView.findViewById(R.id.text_name2);
             text_price2 = itemView.findViewById(R.id.text_price2);
             sim_view2 = itemView.findViewById(R.id.sim_view2);
         }
     }
}
