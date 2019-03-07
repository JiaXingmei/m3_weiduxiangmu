package com.example.dell.m3_weiduxiangmu;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.example.dell.m3_weiduxiangmu.adapter.ShopAdapter;
import com.example.dell.m3_weiduxiangmu.bean.ShopBean;

import java.util.ArrayList;
import java.util.List;

public class AddBar extends RelativeLayout implements View.OnClickListener {
    private Context context;
    private ShopAdapter shopAdapter;
    private List<ShopBean.ResultBean> list=new ArrayList<>();
    private int position;
    private EditText edit_shop_car;
    private ImageView add_car;
    private ImageView jian_car;
    public AddBar(Context context) {
        super(context);
        init(context);
    }

    public AddBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public AddBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        View view = View.inflate(context, R.layout.add_layout, null);
        add_car = view.findViewById(R.id.add_car);
        jian_car = view.findViewById(R.id.jian_car);
        edit_shop_car = view.findViewById(R.id.edit_shop_car);
        //加加减减的点击事件
        add_car.setOnClickListener(this);
        jian_car.setOnClickListener(this);
        addView(view);
        edit_shop_car.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                num=Integer.parseInt(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

   public void setData(ShopAdapter shopAdapter,List<ShopBean.ResultBean> list,int i)
   {
       this.list=list;
       this.shopAdapter=shopAdapter;
       position = i;
       String count = list.get(i).getCount();
       edit_shop_car.setText(count+"");
   }



    //点击事件
    private int num;
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.add_car:
                num++;
                edit_shop_car.setText(num+"");
                carCallBack.callBack();
                break;
            case R.id.jian_car:
                if (num>1)
                {
                    num--;
                }
                 else {
                    Toast.makeText(context,"111",Toast.LENGTH_SHORT).show();
                }
                edit_shop_car.setText(num+"");
                carCallBack.callBack();
                break;
        }

    }

    private CarCallBack carCallBack;
    public void setOnCallBack(CarCallBack carCallBack) {
        this.carCallBack = carCallBack;
    }
    //定义接口
    public  interface CarCallBack
    {
        void callBack();
    }

}
