package com.example.creationgallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {
    ImageView img;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        img = findViewById(R.id.GoBackIcon);
        btn=findViewById(R.id.id_login);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(loginActivity.this,homepage.class);
                startActivity(intent);
            }
        });
    }


    }
