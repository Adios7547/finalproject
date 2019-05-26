package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result1 extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result1);

        Button return1 = (Button)findViewById(R.id.return1);

        TextView tv = findViewById(R.id.TextResult1);
        //int a = getIntent().getIntExtra("total",1);
        tv.setText("개수 : "+getIntent().getIntExtra("total",0));


        return1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
