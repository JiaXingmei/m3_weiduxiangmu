package com.example.dell.m3_weiduxiangmu;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dell.m3_weiduxiangmu.bean.ShopBean;
import com.example.dell.m3_weiduxiangmu.bean.SyncBean;
import com.example.dell.m3_weiduxiangmu.bean.TongBean;
import com.example.dell.m3_weiduxiangmu.bean.XiangBean;
import com.example.dell.m3_weiduxiangmu.shop.presenter.ShopPresenter;
import com.example.dell.m3_weiduxiangmu.shop.shopcar.presenter.CarPresenter;
import com.example.dell.m3_weiduxiangmu.xiang.presenter.XqPresenter;
import com.example.dell.m3_weiduxiangmu.xiang.view.IxView;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;
import com.zhy.autolayout.AutoLayoutActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiangActivity extends AutoLayoutActivity implements IxView {


    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.xiang_xbanner)
    XBanner xiangXbanner;
    @BindView(R.id.xaing_price)
    TextView xaingPrice;
    @BindView(R.id.xiang_shou)
    TextView xiangShou;
    @BindView(R.id.xiang_title)
    TextView xiangTitle;
    @BindView(R.id.xiang_weight)
    TextView xiangWeight;
    @BindView(R.id.xiang_back)
    ImageView xiangBack;
    @BindView(R.id.btn_add)
    ImageView btnAdd;
    @BindView(R.id.btn_buy)
    ImageView btnBuy;
    private String cid;
    private ShopPresenter shopPresenter;
    private int userId;
    private String sessionId;
    private CarPresenter carPresenter;
    private HashMap<String, Object> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang);
        ButterKnife.bind(this);
        shopPresenter = new ShopPresenter(this);
        carPresenter = new CarPresenter(this);

        cid = getIntent().getStringExtra("cid");
        XqPresenter xqPresenter = new XqPresenter(this);
        xqPresenter.getxpdata(cid);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });

        SharedPreferences login = getSharedPreferences("config", MODE_PRIVATE);
        userId = login.getInt("userId", 0);
        sessionId = login.getString("sessionId", "");
    }

    @Override
    public void getxvdata(Object object) {
        XiangBean xiangBean = (XiangBean) object;
        String details = xiangBean.getResult().getDetails();
        String picture = xiangBean.getResult().getPicture();
        //裁剪图片
        String[] split = picture.split("\\,");
        final List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        xiangXbanner.setData(list, null);
        xiangXbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(XiangActivity.this).load(list.get(position)).into((ImageView) view);
            }
        });
        xiangXbanner.setPageTransformer(Transformer.Default);
        xiangXbanner.setPageChangeDuration(1000);
        webView.loadDataWithBaseURL(null, details, "text / html", "UTF-8", null);
        xaingPrice.setText("¥" + xiangBean.getResult().getPrice() + "");
        xiangShou.setText("已售" + xiangBean.getResult().getSaleNum() + "件");
        xiangWeight.setText("重量:" + xiangBean.getResult().getWeight());
        xiangTitle.setText(xiangBean.getResult().getCommodityName());
    }


    @OnClick({R.id.xiang_back, R.id.btn_add, R.id.btn_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xiang_back:
                finish();
                break;
            case R.id.btn_add:
                try {
                    //相当于中括号
                    JSONArray jsonArray=new JSONArray();
                    //相当于大括号
                    JSONObject jsonObject=null;
                    jsonObject=new JSONObject();
                    jsonObject.put("commodityId",cid);
                    jsonObject.put("count",1);
                    jsonArray.put(jsonObject);
                    map = new HashMap<>();
                    map.put("userId", userId);
                    map.put("sessionId", sessionId);
                    String data=jsonArray.toString();
                    shopPresenter.getspdata(map,data);
                    carPresenter.getChapdata(map);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case R.id.btn_buy:
                break;
        }
    }

    //查询购物车
    public void getChaVdata(Object object)
    {
        ShopBean shopBean= (ShopBean) object;
        List<ShopBean.ResultBean> slist = shopBean.getResult();
        ArrayList<TongBean> list = new ArrayList<>();
        for (ShopBean.ResultBean resultBean : slist)
        {
            list.add(new TongBean(resultBean.getCommodityId(),resultBean.getCount()));
        }
        if (list.size()==0)
        {
            list.add(new TongBean(Integer.parseInt(cid),"1"));
        }
        else{
            for (int i=0;i<list.size();i++)
            {
                if (list.get(i).getCommodityId()==Integer.parseInt(cid))
                {
                    list.get(i).setCount(list.get(i).getCount()+1);
                    break;
                }
                else if (i==list.size()-1)
                {
                    list.add(new TongBean(Integer.parseInt(cid),"1"));
                    break;
                }
            }
        }
        String s = new Gson().toJson(list);
        shopPresenter.getspdata(map,s);

    }

    public void getaddvdata(Object object)
    {
        if (object!=null)
        {
            SyncBean syncBean= (SyncBean) object;
            Toast.makeText(XiangActivity.this,syncBean.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }



}
