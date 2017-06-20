package com.example.kubyhuang.mymacpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.kubyhuang.mymacpro.utils.ToastUtils;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    @ViewInject(R.id.lv_function)
    private ListView lv_function;
    private ArrayList<String> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);

        initData();

    }

    private void initData() {
        listData = new ArrayList<String>();
        listData.add("test1");
        listData.add("svg");
        listData.add("ObjectAnimator");
        listData.add("test4");
        listData.add("test5");
        listData.add("test6");
        listData.add("test7");
        listData.add("test8");
        listData.add("test9");
        listData.add("test10");
        listData.add("test11");
        listData.add("test12");
        listData.add("test13");
        listData.add("test14");

        lv_function.setAdapter(new ArrayAdapter<String>(this, R.layout.item_function_lv, R.id.tv_name, listData));
    }

    @Event(value = {R.id.lv_function},type = AdapterView.OnItemClickListener.class)
    private void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ToastUtils.showT(this, "position" + i);
        String action = listData.get(i);
        switch (action) {
            case "svg":
                startActivity(new Intent(this, SVGActivity.class));
                break;
            case "ObjectAnimator":
                startActivity(new Intent(this, ObjectAnimationActivity.class));
                break;
        }
    }
}
