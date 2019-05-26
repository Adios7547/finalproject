package com.example.finalproject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public class Diary extends Activity {
    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary);


        dp = (DatePicker) findViewById(R.id.DatePicker);
        edtDiary = (EditText) findViewById(R.id.EditDiary);
        btnWrite = (Button) findViewById(R.id.BtnWrite);
        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                fileName = Integer.toString(year) + "_" + Integer.toString(monthOfYear + 1) +
                        "_" + Integer.toString(dayOfMonth) + ".txt";
                String str = readDiary(fileName);

                edtDiary.setText(str);
                btnWrite.setEnabled(true);

            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = edtDiary.getText().toString();

                    outFs.write(str.getBytes());
                    outFs.close();

                    Toast.makeText(getApplicationContext(), fileName + " 이 저장됨", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {

                }

            }
        });


    }

    String readDiary(String fName) {
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();

            diaryStr = (new String(txt)).trim();

            btnWrite.setText("수정하기");
        } catch (Exception e) {
            btnWrite.setText("새로저장");

            edtDiary.setHint("메모가 없으니 새로 작성하세요");
        }
        return diaryStr;

    }

}
