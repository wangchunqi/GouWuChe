package com.example.myapplication.presenter;

import com.example.myapplication.api.CHSB;
import com.example.myapplication.bean.TianJian;
import com.example.myapplication.bean.XQBean;
import com.example.myapplication.model.XQModel;
import com.example.myapplication.view.Iview;

/**
 * Created by Administrator on 2018/1/6/006.
 */

public class XQPersenter {
    private final XQModel xqModel;
    private Iview iview;
    public XQPersenter(Iview iview) {
        xqModel = new XQModel();
        this.iview=iview;
    }
    public void getXQ(){
        xqModel.getXQ(12, "android", new CHSB<XQBean>() {
            @Override
            public void chengGong(XQBean xqBean) {
                iview.showBean(xqBean);
            }
        });
    }
    public void getTJ(){
        xqModel.getTJ(3043, 12, "android", new CHSB<TianJian>() {
            @Override
            public void chengGong(TianJian tianjia) {
                iview.showStr(tianjia.getMsg());
            }
        });
    }
}
