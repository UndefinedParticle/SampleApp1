package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements Example_Dialog.ExampleDialogListener {
    private WebView web1,web2,web3;
    ImageView setting;
    TextView homeUrl,aboutUrl,updateUrl;
    int keyPassword;
    Intent intent1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Calendar now = Calendar.getInstance();
        int keyValue=now.get(Calendar.DATE)*(now.get(Calendar.MONTH) + 1)*now.get(Calendar.YEAR);
        //System.out.println("Current Year is : " + now.get(Calendar.YEAR));
        // month start from 0 to 11
        //System.out.println("Current Month is : " + (now.get(Calendar.MONTH) + 1));
        //System.out.println("Current Date is : " + now.get(Calendar.DATE));


        homeUrl=findViewById(R.id.home);
        homeUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data1="https://krishworks.com/";
                intent1=new Intent(MainActivity.this,MainActivity.class);
                intent1.putExtra("url1",data1);
                startActivity(intent1);
            }
        });


        aboutUrl=findViewById(R.id.aboutus);
        aboutUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data2="https://krishworks.com/about/";
                intent1=new Intent(MainActivity.this,MainActivity.class);
                intent1.putExtra("url2",data2);
                startActivity(intent1);
            }
        });


        updateUrl=findViewById(R.id.updates);
        updateUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data3="https://krishworks.com/updates/";
                intent1=new Intent(MainActivity.this,MainActivity.class);
                intent1.putExtra("url3",data3);
                startActivity(intent1);
            }
        });



        web1=(WebView) findViewById(R.id.myWeb);
        WebSettings webSettings1=web1.getSettings();
        webSettings1.setJavaScriptEnabled(true);
        Intent webInt1=getIntent();
        String webData1=webInt1.getStringExtra("url1");
        web1.loadUrl(webData1);

        web2=(WebView) findViewById(R.id.myWeb);
        WebSettings webSettings2=web2.getSettings();
        webSettings2.setJavaScriptEnabled(true);
        Intent webInt2=getIntent();
        String webData2=webInt2.getStringExtra("url2");
        web2.loadUrl(webData2);

        web3=(WebView) findViewById(R.id.myWeb);
        WebSettings webSettings3=web3.getSettings();
        webSettings3.setJavaScriptEnabled(true);
        Intent webInt3=getIntent();
        String webData3=webInt3.getStringExtra("url3");
        web3.loadUrl(webData3);


        setting=findViewById(R.id.ourSettings);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent newIntent=new Intent(MainActivity.this,MainActivity2.class);
                openDialog();
                /*if(keyValue==keyPassword){
                Intent newIntent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(newIntent);
                }*/

            }
        });



    }
    public void openDialog(){
        Example_Dialog example_dialog=new Example_Dialog();
        example_dialog.show(getSupportFragmentManager(),"Password");
        Calendar now = Calendar.getInstance();
        int keyValue=now.get(Calendar.DATE)*(now.get(Calendar.MONTH) + 1)*now.get(Calendar.YEAR);
        if(keyValue==keyPassword){
            Intent newIntent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(newIntent);
            }
    }

    @Override
    public void applyTexts(String password) {
        String pass=password;
        keyPassword=Integer.parseInt(pass);
    }
}