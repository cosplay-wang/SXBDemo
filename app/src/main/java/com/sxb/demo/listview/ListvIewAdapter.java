package com.sxb.demo.listview;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sxb.demo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhiwei.wang on 2017/9/26.
 */

public class ListvIewAdapter extends BaseAdapter {
    List<Integer> dataList;
    Context context;
    final int VIEW_TYPE = 2;
    final int TYPE_1 = 0;
    final int TYPE_2 = 1;

    public ListvIewAdapter(List<Integer> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 6 != 1) {
            return TYPE_1;
        } else {
            return TYPE_2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE;
    }

    @Override
    public int getCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        int type = getItemViewType(i);
        if (view == null) {
            switch (type){
                case TYPE_1:
                    view = LayoutInflater.from(context).inflate(R.layout.listview_item1_layout,viewGroup,false);
                    holder1 = new ViewHolder1(view);
                    view.setTag(holder1);
                    break;
                case TYPE_2:
                    view = LayoutInflater.from(context).inflate(R.layout.listview_item2_layout,viewGroup,false);
                    holder2 = new ViewHolder2(view);
                    view.setTag(holder2);
                    break;
            }

        }else{
            switch (type){
                case TYPE_1:
                    holder1 = (ViewHolder1) view.getTag();
                    break;
                case TYPE_2:
                    holder2 = (ViewHolder2) view.getTag();
                    break;
            }
        }
        switch (type){
            case TYPE_1:
                holder1.textViewTitle.setText("TITLE："+i);
                holder1.textViewContent.setText("CONTENT:"+i);
                Glide.with(context).load(R.mipmap.ic_launcher).into(holder1.imageView);
                break;
            case TYPE_2:

                holder2.textView.setText("TITLE:"+i);
                Glide.with(context).load(R.mipmap.ic_launcher).into(holder2.imageView);
                break;
        }

        return view;
    }

    class ViewHolder2 {
        @BindView(R.id.item2)
        LinearLayout linearLayout;
        @BindView(R.id.item2_title)
        TextView textView;
        @BindView(R.id.item2_image)
        ImageView imageView;

        public ViewHolder2(View view) {
            ButterKnife.bind(this, view);
        }
    }

    class ViewHolder1 {
        @BindView(R.id.item1)
        LinearLayout linearLayout;
        @BindView(R.id.item1_linear)
        LinearLayout linearLayoutIn;
        @BindView(R.id.item1_linear_title)
        TextView textViewTitle;
        @BindView(R.id.item1_linear_content)
        TextView textViewContent;
        @BindView(R.id.item1_image)
        ImageView imageView;

        public ViewHolder1(View view) {
            ButterKnife.bind(this, view);
        }
    }
    public static int getDeviceWidth(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        return width;
    }
}
