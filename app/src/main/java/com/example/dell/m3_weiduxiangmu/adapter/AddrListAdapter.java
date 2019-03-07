package com.example.dell.m3_weiduxiangmu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.bean.ShouListBean;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;

public class AddrListAdapter extends RecyclerView.Adapter<AddrListAdapter.MyViewHolder> {

    private Context context;
    private List<ShouListBean.ResultBean> list;

    public AddrListAdapter(Context context, List<ShouListBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.addrlist_layout, null);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.addr_name.setText(list.get(position).getRealName());
        holder.addr_phone.setText(list.get(position).getPhone());
        holder.addr_addr.setText(list.get(position).getAddress());
        //holder.moren.setText(list.get(position).getWhetherDefault());
        holder.addr_name.setText(list.get(position).getRealName());
        holder.orderid.setText(list.get(position).getZipCode());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView addr_name;
        private final TextView addr_phone;
        private final TextView addr_addr;
        private final TextView addr_delete;
        private final TextView addr_update;
        private final CheckBox moren;
        private final TextView orderid;

        public MyViewHolder(View itemView) {
            super(itemView);
            addr_name = itemView.findViewById(R.id.addr_name);
            addr_phone = itemView.findViewById(R.id.addr_phone);
            addr_addr = itemView.findViewById(R.id.addr_addr);
            addr_delete = itemView.findViewById(R.id.addr_delete);
            addr_update = itemView.findViewById(R.id.addr_update);
            moren = itemView.findViewById(R.id.moren);
            orderid = itemView.findViewById(R.id.orderid);


        }
    }
}
