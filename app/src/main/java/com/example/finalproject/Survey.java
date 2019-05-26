package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Survey extends Activity {
    RadioButton rb, y1, y2, y3, y4, y5, y6, y7, y8, y9, y10, y11, y12, y13, y14, n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14;
    RadioGroup rg1, rg2, rg3, rg4, rg5, rg6, rg7, rg8, rg9, rg10, rg11, rg12, rg13, rg14;
    boolean check = true;
    Intent intent;

    int totall = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey);

        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        y1 = findViewById(R.id.y1);
        y2 = findViewById(R.id.y2);
        y3 = findViewById(R.id.y3);
        y4 = findViewById(R.id.y4);
        y5 = findViewById(R.id.y5);
        y6 = findViewById(R.id.y6);
        y7 = findViewById(R.id.y7);
        y8 = findViewById(R.id.y8);
        y9 = findViewById(R.id.y9);
        y10 = findViewById(R.id.y10);
        y11 = findViewById(R.id.y11);
        y12 = findViewById(R.id.y12);
        y13 = findViewById(R.id.y13);
        y14 = findViewById(R.id.y14);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        n7 = findViewById(R.id.n7);
        n8 = findViewById(R.id.n8);
        n9 = findViewById(R.id.n9);
        n10 = findViewById(R.id.n10);
        n11 = findViewById(R.id.n11);
        n12 = findViewById(R.id.n12);
        n13 = findViewById(R.id.n13);
        n14 = findViewById(R.id.n14);

/*        rg3 = findViewById(R.id.rg3);
        rg4 = findViewById(R.id.rg4);
        rg5 = findViewById(R.id.rg5);
        rg6 = findViewById(R.id.rg6);
        rg7 = findViewById(R.id.rg7);
        rg8 = findViewById(R.id.rg8);
        rg9 = findViewById(R.id.rg9);
        rg10 = findViewById(R.id.rg10);
        rg11 = findViewById(R.id.rg11);
        rg12 = findViewById(R.id.rg12);
        rg13 = findViewById(R.id.rg13);
        rg14 = findViewById(R.id.rg14);*/


        Button result1 = (Button) findViewById(R.id.result1);
        //final TextView TextResult1= (TextView) findViewById(R.id.TextResult1);

        result1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totall = 0;
                check = true;

                if (y1.isChecked() == false && n1.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "1번 문제를 체크하세요", Toast.LENGTH_SHORT).show();
                    check = false;
                }
                if (y1.isChecked()) {
                    totall++;
                }

                if (y2.isChecked() == false && n2.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "2번 문제를 체크하세요", Toast.LENGTH_SHORT).show();
                    check = false;
                }
                if (y2.isChecked()) {
                    totall++;
                }

                if (y3.isChecked() == false && n3.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "3번 문제를 체크하세요", Toast.LENGTH_SHORT).show();
                    check = false;
                }
                if (y3.isChecked()) {
                    totall++;
                }

                if (y4.isChecked() == false && n4.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "4번 문제를 체크하세요", Toast.LENGTH_SHORT).show();
                    check = false;
                }
                if (y4.isChecked()) {
                    totall++;
                }

                if (y5.isChecked() == false && n5.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "5번 문제를 체크하세요", Toast.LENGTH_SHORT).show();
                    check = false;
                }
                if (y5.isChecked()) {
                    totall++;
                }

                if (y6.isChecked() == false && n6.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "6번 문제를 체크하세요", Toast.LENGTH_SHORT).show();
                    check = false;
                }
                if (y6.isChecked()) {
                    totall++;
                }

                if (y7.isChecked() == false && n7.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "7번 문제를 체크하세요", Toast.LENGTH_SHORT).show();
                    check = false;
                }
                if (y7.isChecked()) {
                    totall++;
                }

                if (y8.isChecked() == false && n8.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "8번 문제를 체크하세요", Toast.LENGTH_SHORT).show();
                    check = false;
                }
                if (y8.isChecked()) {
                    totall++;
                }

                if (y9.isChecked() == false && n9.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "9번 문제를 체크하세요", Toast.LENGTH_SHORT).show();
                    check = false;
                }
                if (y9.isChecked()) {
                    totall++;
                }

                if (y10.isChecked() == false && n10.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "10번 문제를 체크하세요", Toast.LENGTH_SHORT).show();
                    check = false;
                }
                if (y10.isChecked()) {
                    totall++;
                }

                if (y11.isChecked() == false && n11.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "11번 문제를 체크하세요", Toast.LENGTH_SHORT).show();
                    check = false;
                }
                if (y11.isChecked()) {
                    totall++;
                }

                if (y12.isChecked() == false && n12.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "12번 문제를 체크하세요", Toast.LENGTH_SHORT).show();
                    check = false;
                }
                if (y12.isChecked()) {
                    totall++;
                }

                if (y13.isChecked() == false && n13.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "13번 문제를 체크하세요", Toast.LENGTH_SHORT).show();
                    check = false;
                }
                if (y13.isChecked()) {
                    totall++;
                }

                if (y14.isChecked() == false && n14.isChecked() == false) {
                    Toast.makeText(getApplicationContext(), "14번 문제를 체크하세요", Toast.LENGTH_SHORT).show();
                    check = false;
                }
                if (y14.isChecked()) {
                    totall++;
                }

                if (check == true) {
                    if (totall > 5) {
                        intent = new Intent(getApplicationContext(), Result1.class);
                    } else {
                        intent = new Intent(getApplicationContext(), Result2.class);
                    }

                    intent.putExtra("total", totall);
                    startActivity(intent);
                }
            }
        });


    }
}


