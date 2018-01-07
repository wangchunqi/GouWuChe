package com.example.myapplication.model;

import com.example.myapplication.api.CHSB;
import com.example.myapplication.bean.CartBean;
import com.example.myapplication.retrofit.RetrofitHepler;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/6/006.
 */

public class CarModel {
    public void getCart(int uid, String str, final CHSB<CartBean> cgsb){
        Flowable<CartBean> flowable = RetrofitHepler.getSerViceAPI().getCart(uid,str);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<CartBean>() {
                    @Override
                    public void accept(CartBean cartBean) throws Exception {
                        cgsb.chengGong(cartBean);
                    }
                });
    }
}
