package com.example.lenovo.listview.CustomActivity2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.lenovo.listview.R;

import java.util.ArrayList;

public class CustomActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom2);

        //1, listView를 가져온다.
        ListView listView = findViewById(R.id.customView2);

        //2. 데이터를 만들어본다.
        //2-1. 데이터를 담을 그릇을 만든다.
        ArrayList<Data2> data2 = new ArrayList<>();
        //2-2. 데이터를 불러와서 묶어준다.(500개)
        for (int i = 0; i < 500; i++) {
            //2-3. 데이터를 그릇에 더해준다(Data2 인스턴스를 new로 생성한다.)
            data2.add(new Data2());

        }

        //3. 어댑터를 만든다.






    }
}
