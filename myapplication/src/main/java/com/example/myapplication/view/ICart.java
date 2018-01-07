package com.example.myapplication.view;

import com.example.myapplication.bean.CartBean;

import java.util.List;

/**
 * Created by Administrator on 2018/1/6/006.
 */

public interface ICart {
    void showlist(List<CartBean.DataBean> grouplist, List<List<CartBean.DataBean.ListBean>>childlist);
}
