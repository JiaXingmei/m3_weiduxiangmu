package com.example.dell.m3_weiduxiangmu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.bean.SouBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class SouAdapter extends RecyclerView.Adapter<SouAdapter.ViewHolder>
{
    private Context context;
    private List<SouBean.ResultBean> slist;

    public SouAdapter(Context context, List<SouBean.ResultBean> slist) {
        this.context = context;
        this.slist = slist;
    }

    private View view;
    @NonNull
    @Override
    public SouAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.s33_layout, null);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SouAdapter.ViewHolder holder, int position)
    {
        holder.text_name.setText(slist.get(position).getCommodityName());
        holder.sim_view.setImageURI(slist.get(position).getMasterPic());
        holder.text_price.setText("¥"+slist.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return slist.size();
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
