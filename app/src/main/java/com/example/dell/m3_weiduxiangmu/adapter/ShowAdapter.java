package com.example.dell.m3_weiduxiangmu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.m3_weiduxiangmu.R;
import com.example.dell.m3_weiduxiangmu.bean.BannerBean;
import com.example.dell.m3_weiduxiangmu.bean.ShowBean;

import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter
{
    private final int BANNER=0;
    private final int RXXP=1;
    private final int MLSS=2;
    private final int PZSH=3;
    private Context context;
    private ShowBean showBean;
    private BannerBean bannerBean;


    private View view;

    public ShowAdapter(Context context, ShowBean showBean,BannerBean bannerBean) {
        this.context = context;
        this.showBean = showBean;
        this.bannerBean = bannerBean;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i)
    {
        if(i==BANNER)
        {
            view = View.inflate(context, R.layout.s0_layout, null);
            return new ItemViewHolder0(view);
        }
        else if(i==RXXP)
        {
            view = View.inflate(context, R.layout.s1_layout, null);
            return new ItemViewHolder1(view);
        }
        else if(i==MLSS)
        {
            view = View.inflate(context, R.layout.s2_layout, null);
            return new ItemViewHolder2(view);
        }
        else
        {
            view = View.inflate(context, R.layout.s3_layout, null);
            return new ItemViewHolder3(view);
        }



    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        if (holder instanceof ItemViewHolder0)
        {
            final List<String> list = new ArrayList<>();
            for (int j = 0; j<bannerBean.getResult().size(); j++){
                list.add(bannerBean.getResult().get(j).getImageUrl());
            }
            ((ItemViewHolder0) holder).xbanner.setData(list,null);
            ((ItemViewHolder0) holder).xbanner.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, View view, int position) {
                    Glide.with(context).load(list.get(position)).into((ImageView) view);
                }
            });
            ((ItemViewHolder0) holder).xbanner.setPageTransformer(Transformer.Default);
            ((ItemViewHolder0) holder).xbanner.setPageChangeDuration(1000);

        }
        if (holder instanceof ItemViewHolder1)
        {
            //获取标题名字
            String name = showBean.getResult().getRxxp().getName();
            ((ItemViewHolder1) holder).rxxp.setText(name);
            //创建布局管理器
            //LinearLayoutManager manager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            GridLayoutManager manager=new GridLayoutManager(context,3);
            ((ItemViewHolder1) holder).rview1.setLayoutManager(manager);
            //创建适配器
            List<ShowBean.ResultBean.RxxpBean.CommodityListBean> rxxps = showBean.getResult().getRxxp().getCommodityList();
            ItemAdapter1 adapter1 = new ItemAdapter1(context,rxxps);
            ((ItemViewHolder1) holder).rview1.setAdapter(adapter1);


        }
        if (holder instanceof ItemViewHolder2)
        {
            String name = showBean.getResult().getMlss().getName();
            ((ItemViewHolder2) holder).mlss.setText(name);

            LinearLayoutManager manager = new LinearLayoutManager(context);
            ((ItemViewHolder2) holder).rview2.setLayoutManager(manager);
            //创建适配器
            List<ShowBean.ResultBean.MlssBean.CommodityListBeanXX> mlss = showBean.getResult().getMlss().getCommodityList();
            ItemAdapter2 adapter2 = new ItemAdapter2(context,mlss);
            ((ItemViewHolder2) holder).rview2.setAdapter(adapter2);

        }
        if (holder instanceof ItemViewHolder3)
        {
            String name = showBean.getResult().getPzsh().getName();
            ((ItemViewHolder3) holder).pzsh.setText(name);

            GridLayoutManager manager=new GridLayoutManager(context,2);
            ((ItemViewHolder3) holder).rview3.setLayoutManager(manager);
            //创建适配器
            List<ShowBean.ResultBean.PzshBean.CommodityListBeanX> pzsh = showBean.getResult().getPzsh().getCommodityList();
            ItemAdapter3 adapter3 = new ItemAdapter3(context,pzsh);
            ((ItemViewHolder3) holder).rview3.setAdapter(adapter3);

        }


    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
       switch (position)
       {
           case 0:
               return BANNER;
           case 1:
               return RXXP;
           case 2:
               return MLSS;
       }
       return PZSH;
    }
    class ItemViewHolder0 extends RecyclerView.ViewHolder {

        private final XBanner xbanner;

        public ItemViewHolder0(View itemView) {
            super(itemView);
            xbanner = itemView.findViewById(R.id.xbanner);

        }
    }
    class ItemViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView rxxp;
        private final RecyclerView rview1;

        public ItemViewHolder1(View itemView) {
            super(itemView);
            rxxp = itemView.findViewById(R.id.text1);
            rview1 = itemView.findViewById(R.id.rview1);
        }
    }
    class ItemViewHolder2 extends RecyclerView.ViewHolder {

        private final TextView mlss;
        private final RecyclerView rview2;

        public ItemViewHolder2(View itemView) {
            super(itemView);
            mlss = itemView.findViewById(R.id.text2);
            rview2 = itemView.findViewById(R.id.rview2);
        }
    }
    class ItemViewHolder3 extends RecyclerView.ViewHolder {

        private final TextView pzsh;
        private final RecyclerView rview3;

        public ItemViewHolder3(View itemView) {
            super(itemView);
            pzsh= itemView.findViewById(R.id.text3);
            rview3 = itemView.findViewById(R.id.rview3);
        }
    }
}
