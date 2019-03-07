package com.example.dell.m3_weiduxiangmu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.bean.PopOneBean;

import java.util.List;

public class PopOneAdapter extends RecyclerView.Adapter<PopOneAdapter.MyViewHolder> {
    private Context context;
    private PopOneBean popOneBean;

    public PopOneAdapter(Context context, PopOneBean popOneBean) {
        this.context = context;
        this.popOneBean = popOneBean;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.popone_layout, null);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position)
    {
        holder.text_one.setText(popOneBean.getResult().get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.setonclicklisener(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return popOneBean.getResult().size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {

         private final TextView text_one;

         public MyViewHolder(View itemView) {
             super(itemView);
             text_one = itemView.findViewById(R.id.text_one);
         }
     }
    private Cicklistener listener;

    public void result(Cicklistener listener) {
        this.listener = listener;
    }
    public interface Cicklistener {
        void setonclicklisener(int position);
    }
}
