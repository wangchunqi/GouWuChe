
package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.myapplication.adapter.MyExpandableAdapter;
import com.example.myapplication.bean.CartBean;
import com.example.myapplication.bean.CountAndPrice;
import com.example.myapplication.bean.MessgeEvent;
import com.example.myapplication.presenter.CartPersenter;
import com.example.myapplication.view.ICart;

import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

public class MainActivity extends AppCompatActivity implements ICart {
    private ExpandableListView mElv;
    private CheckBox mQuanxuan;
    /**
     * 总价：0.0
     */
    private TextView mZongjia;
    /**
     * 共0件商品
     */
    private TextView mTvCount;
    private MyExpandableAdapter myExpandableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        new CartPersenter(this).getCart();
        EventBus.getDefault().register(this);
        mQuanxuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myExpandableAdapter.qx(mQuanxuan.isChecked());
            }
        });
    }

    @Override
    public void showlist(List<CartBean.DataBean> grouplist, List<List<CartBean.DataBean.ListBean>> childlist) {
        myExpandableAdapter = new MyExpandableAdapter(grouplist, this,childlist);
        mElv.setAdapter(myExpandableAdapter);
        for (int i = 0; i <grouplist.size() ; i++) {
            mElv.expandGroup(i);
        }

    }

    private void initView() {
        mElv = (ExpandableListView) findViewById(R.id.elv);
        mQuanxuan = (CheckBox) findViewById(R.id.quanxuan);
        mZongjia = (TextView) findViewById(R.id.zongjia);
        mTvCount = (TextView) findViewById(R.id.tv_count);
    }
    //接收传过来的值
    @Subscribe
    public void onPriceAndCount(CountAndPrice cp){


        mZongjia.setText("共"+cp.getCount()+"件商品");
        mTvCount.setText("总计："+cp.getPrice());

    }
    //接收传过来的值
    @Subscribe
    public void onPriceAndCount1(MessgeEvent event){
        //改变全选的状态
        mQuanxuan.setChecked(event.isCheck());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
