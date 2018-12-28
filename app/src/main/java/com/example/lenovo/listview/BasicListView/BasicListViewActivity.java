package com.example.lenovo.listview.BasicListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lenovo.listview.R;

public class BasicListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_list_view);

        // 리스트뷰 만들기
        //1. xml작성하기, findViewbyid
        ListView listView = findViewById(R.id.listView);

        //2. 데이터 준비하기
        String alpabatData [] =  {"a","b","c","d","e","a","b","c","d","e","a","b","c","d","e","a","b","c","d","e","a","b","c","d","e"};

        //3. 어댑터 만들기
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1, alpabatData);

        //4. listview와 어댑터 연결하기
        listView.setAdapter(adapter);

        //5. 리스너 설정하기

    }

}
