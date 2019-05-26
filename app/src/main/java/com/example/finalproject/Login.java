package com.example.finalproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Join {
    EditText edtId, edtpw;
    Button btnJoin, btnLogin;
    //입력한 아이디 패스워드와 데이터베이스의 아이디와 패스워드가 일치:1, 불일치:0
    int IDflag;
    int PWflag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnJoin = (Button)findViewById(R.id.btnJoin);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        edtId = (EditText)findViewById(R.id.edtid);
        edtpw = (EditText)findViewById(R.id.edtpPw);

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Join.class);
                startActivity(intent);
            }
        });

        //로그인버튼을 누르면 입력한 EditText와 레코드 값 비교
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SELECT문으로 Cursor에 2차원 배열로 저장 -> 읽기 전용 열기
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;   //Cursor에 저장하기 위한 객체
                cursor = sqlDB.rawQuery("SELECT * FROM Joininfo", null);   //select문은 rawQuery로 수행
                String edt1 = null;   //로그인 화면에서 EditTex에 입력한 값 임시저장변수
                String pass1 = null;  //로그인 화면에서 EditTex에 입력한 값 임시저장
                String edt2 = null;   //DB의 레코드에서 가져온 값 임시저장변수
                String pass2 = null;  //DB에서 가져온 비번 값 임시저장
                //cursor에서 2차원에서 각각의 행비교를 해서 해당 아이디와 비번이 있는지 확인

                while(cursor.moveToNext()) {   //다음 행이 있으면 레코드가 있다면 이동
                    //DB데이터 확인 첫번째 행(레코드 확인)
                    edt2 = cursor.getString(0);    //DB 레코드ㅡ이 첫번째 행의 ID를 임시저장
                    pass2 = cursor.getString(1);   //DB 레코드 첫번째 행의 PW를 임시저장

                    edt1 = edtId.getText().toString();    //로그인화면에 EditText에 로그인하려고 입력한 ID 값 임시저장
                    pass1 = edtpw.getText().toString();

                    //로그인하려고 화면에 입력한 ID가 DB의 첫번째 레코드 ID와 일치하는지 비교
                    //비밀번호도 화면입력과 DB 비번이 일치하는지 확인해야함

                    if (edt2.equals(edt1)) {
                        IDflag = 1;   //일치는 1

                        if (pass2.equals(pass1)) {   //아이디,비번 다 일치 => 정상회원 => 허가메뉴이동

                            //허가된 메뉴화면으로 이동 메뉴화면이 없어서 다시한번 MainActivity startActivity()
                            Intent intent = new Intent(getApplicationContext(), Board.class);
                            startActivity(intent);
                            PWflag = 1;    //패스워드도 일치 1
                            break;
                        }
                        else {  //아이디는 일치지만 비번 오류 메세지 띄워줌 =>안내
                            Toast.makeText(getApplicationContext(), "화원이지만 비밀번호가 틀립니다", Toast.LENGTH_LONG).show();
                            break;   //회원 ID확인 되었으니, moveToText 할 필요 없다.
                        }
                    }
                    else{   //아이디 불일치 moveToNext() 이동할 때마다 불일치 메세지 띄우면 안됨
                    }
                }//while문
                if (IDflag == 0 && PWflag == 0)  {   //while문으로 모든 레코드를 비교했으나 ID가 없음
                    Toast.makeText(getApplicationContext(),"아이디가 틀립니다",Toast.LENGTH_LONG).show();
                }
                cursor.close();
                sqlDB.close();
            } //onClick
        });  //로그인버튼 누름
    }
}