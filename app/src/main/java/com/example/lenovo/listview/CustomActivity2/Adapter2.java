package com.example.lenovo.listview.CustomActivity2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class Adapter2 extends BaseAdapter {

    ArrayList<Data2> data2;

    //1. customActivity 데이터를 불러온다.
    //1-1. 인자값으로 의존성 주입을 통해 ArrayList<Data2> data2를 가져온다.
    public Adapter2(ArrayList<Data2> data2){
        this.data2 = data2;

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View listView2, ViewGroup parent) {

        if(listView2 == null){


        }

        return null;
    }
}
