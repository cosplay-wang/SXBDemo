package com.sxb.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sxb.demo.listview.ListViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.send_broad)
    TextView sendBroad;
    @OnClick({R.id.send_broad,R.id.listview})
    public void OnClick(View view){
        switch (view.getId())
        {
            case R.id.send_broad:
            {
                setSendBroad();
                break;
            }
            case R.id.listview:
            {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
                break;
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
    private void setSendBroad(){
        Intent intent = new Intent();
        intent.setAction("a.b.c");
        intent.putExtra("a.b.c","初次跳转，请多关照");
        sendBroadcast(intent);
    }
}
