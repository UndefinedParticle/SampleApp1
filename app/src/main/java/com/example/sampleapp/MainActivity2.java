package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {
    private WebView web1,web2;
    private TextView galleryView,contactView,closeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Objects.requireNonNull(getSupportActionBar()).hide();
        galleryView=findViewById(R.id.gallery);
        contactView=findViewById(R.id.contactus);
        galleryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data1="https://krishworks.com/gallery/";
                Intent intent1=new Intent(MainActivity2.this,MainActivity2.class);
                intent1.putExtra("url1",data1);
                startActivity(intent1);
            }
        });
        contactView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data2="https://krishworks.com/contact/";
                Intent intent2=new Intent(MainActivity2.this,MainActivity2.class);
                intent2.putExtra("url2",data2);
                startActivity(intent2);
            }
        });

        closeView=findViewById(R.id.close);
        closeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent3);
            }
        });


        web1=(WebView) findViewById(R.id.myWeb1);
        WebSettings webSettings1=web1.getSettings();
        webSettings1.setJavaScriptEnabled(true);
        Intent webInt1=getIntent();
        String webData1=webInt1.getStringExtra("url1");
        web1.loadUrl(webData1);

        web2=(WebView) findViewById(R.id.myWeb1);
        WebSettings webSettings2=web2.getSettings();
        webSettings2.setJavaScriptEnabled(true);
        Intent webInt2=getIntent();
        String webData2=webInt2.getStringExtra("url2");
        web2.loadUrl(webData2);
    }
}