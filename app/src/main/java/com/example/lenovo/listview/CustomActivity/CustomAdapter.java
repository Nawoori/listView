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

    //Adapter의 역할
    //1. 데이터를 받아온다
    //2. listView의 itemView(phonebook.xml) 받아온다
    //3. 데이터와 리스트뷰를 연결



    //1.데이터를 넘겨받음
    //1-1. 생성자
    //1-2. set함수로 데이터를 주입 받음
    ArrayList<Data> datas;

    //2 생성자 의존성 주입을 사용
    //2-1. 데이터를 CustomActivity에서 넘겨받기 위해
    //     강제로 생성자 타입으로 데이터를 지정

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
    //getView : system에서 호출해주는 함수 -> itemView값을 넘겨줌
    //View itemView : 아이템뷰 값을 받아온다
    //position : 몇번째 위치에 뷰인지 알려줌
    //ViewGroup parent : 무시
    @Override
    public View getView(int position, View itemView, ViewGroup parent) {
        /**
         * 뷰 받아오기
         */
        //Context는 system에 접근하는 리소스 - 시스템을 통해 LayoutInflater를 가져온다.
        //xml을 자바로 바꿔주기 위한 과정
        final Context context = parent.getContext();

        // 뷰홀더는 findViewById를 통해 찾은 뷰들을 재활용하기 위해 3-4개 뷰를 주머니에 담아둔 것
        ViewHolder viewHolder;

        //7-2.처음 넘어왔을 때 itemView값이 null값이기 때문에 inflation할 수 있도록 함
        if(itemView == null){
            //xml을 자바로 가져오는 과정을 inflation이라고 한다.
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.itemview_phonebook, parent, false);

            // findviewbyid를 통해 찾아온 뷰들을 재활용하기 위해 컨테이너를 만들어 준다
            viewHolder = new ViewHolder(itemView);
            // 시스템에서 계속 호출해서 넘겨주는 itemView에 태그로 연결해준다(setTag는 Object를 넘겨줄 수 있도록 설계되었는데,
            // 개발자들이 임의로 홀더 객체를 저장하는데 사용함)
            itemView.setTag(viewHolder);
        } else {
            // 한 번 null값을 거친 itemView는 이제 setTag를 통해 viewHolder를 가지고 있기 때문에 getTag를 통해 가져오고
            // 다만 Object를 리턴해주기 때문에 타입을 변형해준다
            viewHolder = (ViewHolder) itemView.getTag();
        }



        //2.xml에 있는 그림을 불러옴 -> 왜 호출할 때마다 해줘야 하지? -> ViewHolder 컨테이너를 만들어 사용
//        ImageView imgView = itemView.findViewById(R.id.imgView);
//        TextView txtView1 = itemView.findViewById(R.id.txtView1);
//        TextView txtView2 = itemView.findViewById(R.id.txtView2);

        /**
         * 데이터와 뷰 연결해주기
         */

        //3.데이터를 piosition으로 받아와서 위치에 맞게 연결해줌
        Data data = datas.get(position);
        viewHolder.imgView.setImageResource(data.getImage());
        viewHolder.txtView1.setText(data.getName());
        viewHolder.txtView2.setText(data.getNumber());

        return itemView;
    }

}
