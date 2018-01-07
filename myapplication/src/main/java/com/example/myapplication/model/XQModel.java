package com.example.myapplication.model;

import com.example.myapplication.api.CHSB;
import com.example.myapplication.bean.TianJian;
import com.example.myapplication.bean.XQBean;
import com.example.myapplication.retrofit.RetrofitHepler;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/6/006.
 */

public class XQModel implements XQjieKou {
    @Override
    public  void getXQ(int pid, String str, final CHSB<XQBean> cgsb) {
        Flowable<XQBean> flowable = RetrofitHepler.getSerViceAPI().getXQ(pid,str);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<XQBean>() {
                    @Override
                    public void accept(XQBean xqBean) throws Exception {
                        cgsb.chengGong(xqBean);
                    }
                });
    }
    public void getTJ(int uid, int pid, String str, final CHSB<TianJian> cgsb){
        Flowable<TianJian> flowable = RetrofitHepler.getSerViceAPI().getMsg(uid, pid, str);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<TianJian>() {
                    @Override
                    public void accept(TianJian tianjia) throws Exception {
                        cgsb.chengGong(tianjia);
                    }
                });
    }}
