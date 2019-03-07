package com.example.dell.m3_weiduxiangmu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.m3_weiduxiangmu.AddBar;
import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.bean.ShopBean;


import java.util.ArrayList;
import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder>
{
    private Context context;
    private List<ShopBean.ResultBean> slist;
    private ItemCheckOnClickListner itemCheckOnClickListner;

    public ShopAdapter(Context context, List<ShopBean.ResultBean> slist) {
        this.context = context;
        this.slist = slist;
    }

    @NonNull
    @Override
    public ShopAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.sp_layout, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ShopAdapter.MyViewHolder holder, final int position)
    {
        ShopBean.ResultBean resultBean = slist.get(position);
        final int commodityId = resultBean.getCommodityId();
        boolean ischeck = resultBean.isIscheck();
        if (ischeck)
        {
            holder.sp_check.setChecked(true);
        }
        else{
            holder.sp_check.setChecked(false);
        }
        holder.shop_title.setText(slist.get(position).getCommodityName());
        holder.shop_price.setText("¥"+slist.get(position).getPrice()+"");
        Glide.with(context).load(slist.get(position).getPic()).into(holder.shop_img);
        //给输入框赋值
        holder.add_bar.setData(this,slist,position);
        holder.add_bar.setOnCallBack(new AddBar.CarCallBack() {
            @Override
            public void callBack() {
                if (shopCallBack!=null)
                {
                    shopCallBack.callBack();
                }

            }
        });

       holder.sp_check.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               boolean checked = holder.sp_check.isChecked();
               itemCheckOnClickListner.click(commodityId,checked);
           }
       });



    }

    @Override
    public int getItemCount() {
        return slist.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView shop_img;
        private final TextView shop_price;
        private final TextView shop_title;
        private final CheckBox sp_check;
        private final AddBar add_bar;


        public MyViewHolder(View itemView) {
            super(itemView);
            shop_img = itemView.findViewById(R.id.shop_img);
            shop_price = itemView.findViewById(R.id.shop_price);
            shop_title = itemView.findViewById(R.id.shop_title);
            sp_check = itemView.findViewById(R.id.sp_check);
            add_bar = itemView.findViewById(R.id.add_bar);

        }
    }

    private ShopCallBack shopCallBack;
    public void setListener(ShopCallBack shopCallBack) {
        this.shopCallBack = shopCallBack;
    }
    //定义接口
    public interface ShopCallBack
    {
        void callBack();
    }


    public void setItemCheckOnClickListner(ItemCheckOnClickListner itemCheckOnClickListner1){
        this.itemCheckOnClickListner=itemCheckOnClickListner1;
    }
    public interface ItemCheckOnClickListner{
        void click(int commodityId, boolean isChecked);
    }




}
