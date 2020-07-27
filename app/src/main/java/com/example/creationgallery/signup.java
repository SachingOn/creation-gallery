package com.example.creationgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class signup extends AppCompatActivity {


    Button btn;
    EditText name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        btn = findViewById(R.id.joinus);
        name=findViewById(R.id.yourname);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(signup.this,loginActivity.class);
                startActivity(intent);
            }
        });
    }
}