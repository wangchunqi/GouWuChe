package com.example.myapplication.api;

import com.example.myapplication.bean.CartBean;
import com.example.myapplication.bean.TianJian;
import com.example.myapplication.bean.XQBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/1/6/006.
 */

public interface MyService {
    @GET("getProductDetail")
    Flowable<XQBean> getXQ(@Query("pid")int pid, @Query("source")String str);
    @GET("addCart")
    Flowable<TianJian> getMsg(@Query("uid")int uid, @Query("pid")int pid, @Query("source")String str);
    @GET("getCarts")
    Flowable<CartBean> getCart(@Query("uid")int uid, @Query("source")String str);
}
