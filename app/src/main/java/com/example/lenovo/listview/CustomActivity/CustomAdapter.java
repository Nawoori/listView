package com.example.lenovo.listview.CustomActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.listview.R;

import java.util.ArrayList;

//BaseAdapter으로 상속받음
public class CustomAdapter extends BaseAdapter {



    //1.데이터를 넘겨받음
    //1-1. 생성자
    //1-2. set함수로 데이터를 주입 받음
    ArrayList<Data> datas;

    //2 생성자 의존성 주입을 사용
    //2-1. 생성자 타입으로 데이터를 지정
    CustomAdapter(ArrayList<Data> data){
        //2-2. 데이터 동기화
        this.datas = data;
    }

    //4. 넘겨받은 데이터의 개수를 넘겨받음
    @Override
    public int getCount() {
        //4-1. 데이터 크기를 알 수 없기 때문에 동적으로 전체 개수를 넘겨줌
        return datas.size();
    }

    //5. 포지션에 있는 아이템을 꺼내서 넘겨줌
    @Override
    public Object getItem(int position) {
        //5-1.custom이라는 데이터 안에 있는 위치값을 넘겨줌
        return datas.get(position);
    }

    //6. 포지션 그대로 넘겨줌
    @Override
    public long getItemId(int position) {
        return position;
    }

    //7. 시스템으로 부터 View를 넘겨받음
    //7-1. 내가 받아온 데이터와 시스템에서 넘겨준 View와 데이터 세팅을 해줌
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Context는 system에 접근하는 리소스
        final Context context = parent.getContext();

        //7-2.처음 넘어왔을 때 convertView값이 null값이기 때문에 inflation할 수 있도록 함
        if(convertView == null){
            //context에 있는 view를 가져옴
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.itemview_phonebook, parent, false);
        }

        //2.xml에 있는 그림을 불러옴
        ImageView imgView = convertView.findViewById(R.id.imgView);
        TextView txtView1 = convertView.findViewById(R.id.txtView1);
        TextView txtView2 = convertView.findViewById(R.id.txtView2);

        //3.데이터를 piosition으로 받아와서 위치에 맞게 연결해줌
        Data data = datas.get(position);
        imgView.setImageResource(data.getImage());
        txtView1.setText(data.getName());
        txtView2.setText(data.getNumber());

        return convertView;
    }

}
