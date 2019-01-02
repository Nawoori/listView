package com.example.lenovo.listview.CustomActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.listview.R;

/**
 * findViewById를 반복하지 않도록 아이템뷰 콘테이너를 만들어줌. 즉, findViewById가 된 뷰들을 담고 있는 객체
 */
public class ViewHolder {

    ImageView imgView;
    TextView txtView1;
    TextView txtView2;

    public ViewHolder(View itemView) {
        imgView = itemView.findViewById(R.id.imgView);
        txtView1 = itemView.findViewById(R.id.txtView1);
        txtView2 = itemView.findViewById(R.id.txtView2);
    }


}
