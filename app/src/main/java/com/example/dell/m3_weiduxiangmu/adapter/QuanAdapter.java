package com.example.dell.m3_weiduxiangmu.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.bean.QuanBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class QuanAdapter extends XRecyclerView.Adapter<QuanAdapter.ViewHolder> {
    private Context context;
    private List<QuanBean.ResultBean> mlist;

    public QuanAdapter(Context context, List<QuanBean.ResultBean> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.quan_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.text_data.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(mlist.get(position).getCreateTime())));
        holder.text_nicheng.setText(mlist.get(position).getNickName());
        holder.text_title.setText(mlist.get(position).getContent());
        holder.text_zan.setText(mlist.get(position).getGreatNum()+"");
        Glide.with(context).load(mlist.get(position).getHeadPic()).into(holder.img_tou);
       // Glide.with(context).load(mlist.get(position).getImage()).into(holder.img_one);
        String image = mlist.get(position).getImage();
        if (image==null)
        {
            holder.img_one.setImageURI(Uri.parse("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=49764040,3750999451&fm=27&gp=0.jpg"));

        }
        else{
           /* String[] split = image.split(",");
            holder.img_one.setImageURI(Uri.parse(split[0]));*/
            Glide.with(context).load(mlist.get(position).getImage()).into(holder.img_one);
        }


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private final ImageView img_tou;
        private final ImageView img_one;
        private final TextView text_data;
        private final TextView text_title;
        private final TextView text_nicheng;
        private final TextView text_zan;

        public ViewHolder(View itemView) {
            super(itemView);
            img_tou = itemView.findViewById(R.id.img_tou);
            img_one = itemView.findViewById(R.id.img_one);
            text_data = itemView.findViewById(R.id.text_data);
            text_title = itemView.findViewById(R.id.text_title);
            text_nicheng = itemView.findViewById(R.id.text_nicheng);
            text_zan = itemView.findViewById(R.id.text_zan);

        }
    }
}
