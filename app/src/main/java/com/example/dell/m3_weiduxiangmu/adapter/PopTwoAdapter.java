package com.example.dell.m3_weiduxiangmu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.bean.PopOneBean;
import com.example.dell.m3_weiduxiangmu.bean.PopTwoBean;

import java.util.List;

public class PopTwoAdapter extends RecyclerView.Adapter<PopTwoAdapter.MyViewHolder> {
    private Context context;
    private List<PopTwoBean.ResultBean> list;

    public PopTwoAdapter(Context context, List<PopTwoBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.poptwo_layout, null);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
       holder.text_two.setText(list.get(position).getName());
        Log.d("cc","onBindViewHolder"+list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {

         private final TextView text_two;

         public MyViewHolder(View itemView) {
             super(itemView);
             text_two = itemView.findViewById(R.id.text_two);
         }
     }
}
