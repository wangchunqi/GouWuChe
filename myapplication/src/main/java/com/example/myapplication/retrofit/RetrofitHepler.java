package com.example.myapplication.retrofit;

import com.example.myapplication.api.MyApi;
import com.example.myapplication.api.MyService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/1/6/006.
 */

public class RetrofitHepler {
    private static OkHttpClient okHttpClient;
    private static MyService serViceAPI;
    /**
     * 优先执行
     */
    static {
        getOkHttpClient();
    }
    public static OkHttpClient getOkHttpClient(){
        if(okHttpClient==null){
            synchronized (OkHttpClient.class){
                if(okHttpClient==null){
                    okHttpClient=new OkHttpClient();
                }
            }
        }
        return okHttpClient;
    }
    public static MyService getSerViceAPI(){

        if(serViceAPI==null){
            synchronized (OkHttpClient.class){
                if(serViceAPI==null){
                    serViceAPI=onCreate(MyService.class, MyApi.HOST);
                }
            }
        }
        return serViceAPI;
    }
    public static <T> T onCreate(Class<T>tClass,String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(tClass);
    }
}
