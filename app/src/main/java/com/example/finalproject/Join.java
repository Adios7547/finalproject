package com.example.finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Join extends Activity {

    //위젯변수
    myDBHelper myHelper;  //객체선언, 객체 생성해서 사용
    EditText jId, jPw;
    Button btnRegistration;
    SQLiteDatabase sqlDB;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //join.xml 을 화면에 셋팅
        setContentView(R.layout.join);  //R.java에 등록됨
        //위젯변수 사용할 수 있게 대입, 객체 생성
        jId = (EditText) findViewById(R.id.jId);
        jPw = (EditText) findViewById(R.id.jPw);
        btnRegistration = (Button) findViewById(R.id.j_Registration);
        myHelper = new myDBHelper(this);  //생성자

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO Joininfo VALUES ('" + jId.getText().toString() + "','" + jPw.getText().toString() + "');");
                sqlDB.close();   //사용자에게 정상회원가입 메세지 ==> 토스트 메세지
                Toast.makeText(getApplicationContext(), "가입됨", Toast.LENGTH_LONG).show();
                //회원을 가입하면 로그인을 해봐야하므로 메인화면으로 이동하기 intent
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);   //그다음 AndroidManifest에 추가
            }
        });
    }  //onCreate()

    //onCreate() 밖 / 회원가입하려면 DB 생성해야하고 테이블 생성 ==>객체생성 SQLiteOpenHelper
    public class myDBHelper extends SQLiteOpenHelper {  //생성자가 DB 생성
        public myDBHelper(Context context) {  //클래스 추가
            super(context, "LoginDB", null, 1);  //생성자가 DB 생성 ,DB명은 LoginDB
        } //필수 메소드가 onCreate, onUpgrade 작성은 [code-override]
        //커서를 네부클래스에 두고 onCreate

        @Override
        public void onCreate(SQLiteDatabase db) {   //테이블 생성하는 메소드
            db.execSQL("CREATE TABLE Joininfo(uId TEXT,uPassword TEXT);");   //쿼리문으로 테이블 생성
        }
        //onUpgrade

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS Joininfo");
            onCreate(db);   //테이블 다시 생성은 onCreate() 메소드 호출
        }
    }
}   //MainActivity





