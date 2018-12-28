package com.example.lenovo.listview.CustomActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.lenovo.listview.R;

import java.util.ArrayList;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        //1.xml 작성하기 1) ListView 그룹 작성 2) itemView작성
        ListView custumList = findViewById(R.id.customList);

        //2-1. ArrayList로 담을 그릇을 만든다.
        ArrayList<Data> data = new ArrayList();

        //2.데이터 받아오기
        for(int i = 0; i < 500 ; i++){
            //2-2. new로 데이터를 불러온다.
            Data customData = new Data();

            //2-3 데이터를 넣어준다.
            //나중에 쿼리를 해줄 것이기 때문에 지금은 더미데이터로 해도 괜찮다.
            customData.setName("asdasd");
            customData.setNumber("12341234");
            customData.setImage(R.drawable.ic_launcher_foreground);

            //2-4. ArrayList에 넣어준다.
            data.add(customData);
        }

        //3.어댑터 세팅하기 -> CustomAdapter를 만들기 시작한다.
        CustomAdapter adapter = new CustomAdapter(data);

        //4.Listview 연결하기
        custumList.setAdapter(adapter);

        //5.리스너 설정하기
    }
}
