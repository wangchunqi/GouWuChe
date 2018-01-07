package com.example.myapplication.model;

import com.example.myapplication.api.CHSB;
import com.example.myapplication.bean.XQBean;

/**
 * Created by Administrator on 2018/1/6/006.
 */

public interface XQjieKou {
    public  void getXQ(int pid, String str, final CHSB<XQBean> cgsb);
}
