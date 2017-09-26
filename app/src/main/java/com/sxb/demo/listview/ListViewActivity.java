package com.sxb.demo.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.sxb.demo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListViewActivity extends AppCompatActivity {
    List<Integer> dataList = new ArrayList<>();
    @BindView(R.id.demo_listview)
    ListView demoListview;
    ListvIewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);
        getData();
        initList();

    }

    private void getData() {
        for (int i = 0; i < 30; i++) {
            if (i % 6 == 1) {
                dataList.add(2);
            } else {
                dataList.add(1);
            }
        }
    }

    private void initList() {
        adapter = new ListvIewAdapter(dataList, this);
        demoListview.setAdapter(adapter);
    }
}
