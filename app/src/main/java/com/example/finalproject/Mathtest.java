package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class Mathtest extends Activity {

    int Score = 0;
    EditText ans1,ans2,ans3,ans4,ans5 ;
    int Result_1 = 0;
    int Result_2 = 0;
    int Result_3 = 0;
    int Result_4 = 0;
    int Result_5 = 0;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathtest);

        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        ans4 = findViewById(R.id.ans4);
        ans5 = findViewById(R.id.ans5);




        final TextView q1 = findViewById(R.id.Q1);
        int Random_1 = new Random().nextInt(98)+1;
        int Random_2 = new Random().nextInt(98)+1;
        int Random_3 = new Random().nextInt(3)+1;


        Result_1 = Random_1 + Random_2;

        q1.setText("1. "+""+Random_1+" + "+ Random_2);

        final TextView q2 = findViewById(R.id.Q2);
        Random_1 = new Random().nextInt(98)+1;
        Random_2 = new Random().nextInt(98)+1;
        Result_2 = Random_1 + Random_2;
        q2.setText("2. "+""+Random_1+" + "+ Random_2);

        final TextView q3 = findViewById(R.id.Q3);
        Random_1 = new Random().nextInt(98)+1;
        Random_2 = new Random().nextInt(98)+1;
        Result_3 = Random_1 + Random_2;
        q3.setText("3. "+""+Random_1+" + "+ Random_2);

        final TextView q4 = findViewById(R.id.Q4);
        Random_1 = new Random().nextInt(98)+1;
        Random_2 = new Random().nextInt(98)+1;
        Result_4 = Random_1 + Random_2;
        q4.setText("4. "+""+Random_1+" + "+ Random_2);


        final TextView q5 = findViewById(R.id.Q5);
        Random_1 = new Random().nextInt(98)+1;
        Random_2 = new Random().nextInt(98)+1;
        Result_5 = Random_1 + Random_2;
        q5.setText("5. "+""+Random_1+" + "+ Random_2);



        final Button result = findViewById(R.id.result2);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(ans1.getText().toString());
                int b = Integer.parseInt(ans2.getText().toString());
                int c = Integer.parseInt(ans3.getText().toString());
                int d = Integer.parseInt(ans4.getText().toString());
                int e = Integer.parseInt(ans5.getText().toString());

                if (a == Result_1 ) {
                    Score++;
                }
                if (b == Result_2){
                    Score++;
                }
                if (c == Result_3){
                    Score++;
                }
                if (d == Result_4){
                    Score++;
                }
                if (e == Result_5){
                    Score++;
                }

                intent =new Intent(getApplicationContext(), Mathresult.class);

                intent.putExtra("Q1", q1.getText().toString());
                intent.putExtra("Q2", q2.getText().toString());
                intent.putExtra("Q3", q3.getText().toString());
                intent.putExtra("Q4", q4.getText().toString());
                intent.putExtra("Q5", q5.getText().toString());
                intent.putExtra("Result", Score);
                intent.putExtra("Ans1",Result_1);
                intent.putExtra("Ans2",Result_2);
                intent.putExtra("Ans3",Result_3);
                intent.putExtra("Ans4",Result_4);
                intent.putExtra("Ans5",Result_5);
                intent.putExtra("RA1",a);
                intent.putExtra("RA2",b);
                intent.putExtra("RA3",c);
                intent.putExtra("RA4",d);
                intent.putExtra("RA5",e);
                startActivity(intent);
            }
        });

    }

}
