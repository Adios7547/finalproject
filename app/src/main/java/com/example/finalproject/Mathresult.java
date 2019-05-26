package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Mathresult extends Activity {
    TextView Question1,Question2, Question3, Question4, Question5, ans1, ans2, ans3, ans4, ans5, Score ;
    String Q1,Q2,Q3,Q4,Q5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathresult);
        Intent inIntent = getIntent();
        Button return2 = (Button) findViewById(R.id.return3);

        Question1 = findViewById(R.id.Ques1);
        Question2 = findViewById(R.id.Ques2);
        Question3 = findViewById(R.id.Ques3);
        Question4 = findViewById(R.id.Ques4);
        Question5 = findViewById(R.id.Ques5);

        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        ans4 = findViewById(R.id.ans4);
        ans5 = findViewById(R.id.ans5);
        Score = findViewById(R.id.MathResult1);


        Q1 = getIntent().getExtras().getString("Q1");
        Q2 = getIntent().getExtras().getString("Q2");
        Q3 = getIntent().getExtras().getString("Q3");
        Q4 = getIntent().getExtras().getString("Q4");
        Q5 = getIntent().getExtras().getString("Q5");


        Score.setText("맞은 개수 : "+getIntent().getExtras().getInt("Result"));
        Question1.setText(Q1+" = "+getIntent().getExtras().getInt("Ans1"));
        Question2.setText(Q2+" = "+getIntent().getExtras().getInt("Ans2"));
        Question3.setText(Q3+" = "+getIntent().getExtras().getInt("Ans3"));
        Question4.setText(Q4+" = "+getIntent().getExtras().getInt("Ans4"));
        Question5.setText(Q5+" = "+getIntent().getExtras().getInt("Ans5"));
        ans1.setText("당신의 답 : "+getIntent().getExtras().getInt("RA1"));
        ans2.setText("당신의 답 : "+getIntent().getExtras().getInt("RA2"));
        ans3.setText("당신의 답 : "+getIntent().getExtras().getInt("RA3"));
        ans4.setText("당신의 답 : "+getIntent().getExtras().getInt("RA4"));
        ans5.setText("당신의 답 : "+getIntent().getExtras().getInt("RA5"));


        return2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

    }
}