package com.example.dell.m3_weiduxiangmu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.bean.ShowBean;
import com.example.dell.m3_weiduxiangmu.bean.ZujiBean;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class ZuAdapter extends RecyclerView.Adapter<ZuAdapter.ViewHolder>
{
    private Context context;
    private List<ZujiBean.ResultBean> list;

    public ZuAdapter(Context context, List<ZujiBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    private View view;



    @NonNull
    @Override
    public ZuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.zuji_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ZuAdapter.ViewHolder holder, final int position)
    {
        holder.text_name.setText(list.get(position).getCommodityName());
        holder.sim_view.setImageURI(list.get(position).getMasterPic());
        holder.text_price.setText("¥"+list.get(position).getPrice());

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
