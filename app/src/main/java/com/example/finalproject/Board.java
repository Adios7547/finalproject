package com.example.finalproject;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Board extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);
        setTitle("정보게시판");

        final String[]mid = {"하루에 30분 걷기", "이웃과 대화 30분 이상 하기", "견과류 1포 챙겨먹기"};

        ListView list = (ListView)findViewById(R.id.ListView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mid);
        list.setAdapter(adapter);

    }
}

