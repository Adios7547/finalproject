package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Site extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.site);

        Button site=(Button)findViewById(R.id.site);
        Button gps=(Button)findViewById(R.id.gps);
        Button phone=(Button)findViewById(R.id.phone);

        site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.chimae.or.kr/#");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com/maps/search/%ED%95%9C%EA%B5%AD%EC%B9%98%EB%A7%A4%EC%98%88%EB%B0%A9%ED%98%91%ED%9A%8C/@36.4813252,126.8641011,332982m/data=!3m2!1e3!4b1?hl=ko");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:0337341040");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);

            }
        });
    }
}
