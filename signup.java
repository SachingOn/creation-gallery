package com.example.creationgallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class signup extends AppCompatActivity {

    private Button btn;
    private EditText name, email, password;
    private ImageView login;
    private String Email, Password;
    public static final String PREFERENCE = "preference";
    public static final String PREF_NAME = "name";
    public static final String PREF_PASSWD = "passwd";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        btn = findViewById(R.id.btn_joinus);
        name = findViewById(R.id.et_name);
        email = findViewById(R.id.et_mail);
        login = findViewById(R.id.iv_login);
        password = findViewById(R.id.et_password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup.this, loginActivity.class));
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (validUserData()) {
                    SharedPreferences mSharedPreference = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
                    SharedPreferences.Editor mEditor = mSharedPreference.edit();
                    mEditor.putString(PREF_NAME, Email);
                    mEditor.putString(PREF_PASSWD, Password);
                    mEditor.apply();
                    Toast.makeText(signup.this, "Welcome to Creation Gallery", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signup.this, loginActivity.class);
                    intent.putExtra("EXTRA_EMAIL", Email);
                    intent.putExtra("EXTRA_PASSWORD", Password);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(signup.this, "Please enter the required data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validUserData() {
        Email = email.getText().toString().trim();
        Password = password.getText().toString().trim();
        return !(Email.isEmpty() || Password.isEmpty());
    }
}