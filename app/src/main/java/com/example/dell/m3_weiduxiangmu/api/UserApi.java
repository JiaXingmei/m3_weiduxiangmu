package com.example.dell.m3_weiduxiangmu.api;




import com.example.dell.m3_weiduxiangmu.bean.BannerBean;
import com.example.dell.m3_weiduxiangmu.bean.DingDanBean;
import com.example.dell.m3_weiduxiangmu.bean.DlBean;
import com.example.dell.m3_weiduxiangmu.bean.MyWalletBean;
import com.example.dell.m3_weiduxiangmu.bean.OrderListByStatusBean;
import com.example.dell.m3_weiduxiangmu.bean.PopOneBean;
import com.example.dell.m3_weiduxiangmu.bean.PopTwoBean;
import com.example.dell.m3_weiduxiangmu.bean.QuanBean;
import com.example.dell.m3_weiduxiangmu.bean.ShopBean;
import com.example.dell.m3_weiduxiangmu.bean.ShouListBean;
import com.example.dell.m3_weiduxiangmu.bean.ShowBean;
import com.example.dell.m3_weiduxiangmu.bean.SouBean;
import com.example.dell.m3_weiduxiangmu.bean.SyncBean;
import com.example.dell.m3_weiduxiangmu.bean.TianHuoBean;
import com.example.dell.m3_weiduxiangmu.bean.UpdataNikeBean;
import com.example.dell.m3_weiduxiangmu.bean.XiangBean;
import com.example.dell.m3_weiduxiangmu.bean.ZcBean;
import com.example.dell.m3_weiduxiangmu.bean.ZujiBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface UserApi
{
    //注册
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<ZcBean> zc(@Field("phone")String phone, @Field("pwd")String pwd);
    //登录
    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<DlBean> login(@Field("phone") String phone, @Field("pwd")String pwd);
    //列表
    @GET("small/commodity/v1/commodityList")
    //被观察者
    Observable<ShowBean> getcommodity();
    //轮播
    @GET("small/commodity/v1/bannerShow")
    Observable<BannerBean> getBanner();
    //详情
    @GET("small/commodity/v1/findCommodityDetailsById")
    Observable<XiangBean> getXq(@Query("commodityId")String cid);
    //圈子
    @GET("small/circle/v1/findCircleList")
    Observable<QuanBean> getQz(@Query("page")int page, @Query("count")int count);
    //根据关键字查询
    @GET("small/commodity/v1/findCommodityByKeyword")
    Observable<SouBean> getCx(@Query("keyword") String keyword, @Query("page") String page, @Query("count") String count);
    //一级商品类目
    @GET("small/commodity/v1/findFirstCategory")
    Observable<PopOneBean> getOne();
    //二级商品类目
    @GET("small/commodity/v1/findSecondCategory")
    Observable<PopTwoBean> getTwo(@Query("firstCategoryId")String fid);
    //同步购物车
    @PUT("small/order/verify/v1/syncShoppingCart")
    Observable<SyncBean> getSync(@HeaderMap HashMap<String,Object>hashmap, @Query("data")String data);
    //查询购物车
    @GET("small/order/verify/v1/findShoppingCart")
    Observable<ShopBean> getCar(@HeaderMap HashMap<String,Object>hashmap);
    //创建订单
    @POST("small/order/verify/v1/createOrder")
    Observable<DingDanBean> getDingdan(@HeaderMap HashMap<String,Object>hashmap, @Field("addressId")int addressId, @Field("totalPrice")double totalPrice, @FieldMap HashMap<String,Object> ordermap);
    //添加收货地址
    @FormUrlEncoded
    @POST("small/user/verify/v1/addReceiveAddress")
    Observable<TianHuoBean> getshouhuo(@HeaderMap HashMap<String,Object>hashmap, @Field("realName")String name, @Field("phone")String phone, @Field("address")String addr, @Field("zipCode")String code);
    //收货地址列表
    @GET("small/user/verify/v1/receiveAddressList")
    Observable<ShouListBean> getSelect(@HeaderMap HashMap<String,Object>hashmap);

    //全部订单
    @GET("small/order/verify/v1/findOrderListByStatus")
    Observable<OrderListByStatusBean> getStatus(@HeaderMap HashMap<String,Object>hashmap,@Query("status")int status,@Query("page")int page,@Query("count")int count);

    //修改昵称
    @PUT("small/user/verify/v1/modifyUserNick")
    Observable<UpdataNikeBean> getName(@HeaderMap HashMap<String,Object>hashmap, @Query("nickName")String name);
    //我的钱包
    @GET("small/user/verify/v1/findUserWallet")
    Observable<MyWalletBean> getMoney(@HeaderMap HashMap<String,Object>hashmap,@Query("page")int page,@Query("count")int count);
    //我的zuji
    @GET("small/commodity/verify/v1/browseList")
    Observable<ZujiBean> getZu(@HeaderMap HashMap<String,Object>hashmap, @Query("page")int page, @Query("count")int count);


}
