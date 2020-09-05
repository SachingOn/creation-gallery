package com.example.creationgallery;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {

    private Button btn;
    private EditText username, password;
    private TextView signup;
    private String Email, Password;
    private SharedPreferences mSharedPreferences;
    public static final String PREFERENCE = "preference";
    public static final String PREF_NAME = "name";
    public static final String PREF_PASSWD = "passwd";
    public static final String PREF_SKIP_LOGIN = "skip_login";


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        signup = findViewById(R.id.tv_signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginActivity.this, com.example.creationgallery.signup.class));
                finish();
            }
        });

        mSharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        if (mSharedPreferences.contains(PREF_SKIP_LOGIN)) {
            Intent intent = new Intent(loginActivity.this, homepage.class);
            startActivity(intent);
            finish();
        } else {
            username = findViewById(R.id.et_email);
            password = findViewById(R.id.et_password);
            btn = findViewById(R.id.id_login);

            Intent intent = getIntent();
            String uname = intent.getStringExtra("EXTRA_EMAIL");
            String upass = intent.getStringExtra("EXTRA_PASSWORD");
            username.setText(uname);
            password.setText(upass);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (validUserData()) {
                        if (mSharedPreferences.contains(PREF_NAME) && mSharedPreferences.contains(PREF_PASSWD)) {
                            SharedPreferences.Editor mEditor = mSharedPreferences.edit();
                            mEditor.putString(PREF_SKIP_LOGIN, "skip");
                            mEditor.apply();
                            Intent intent = new Intent(loginActivity.this, homepage.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Unable to Login Plz Register !!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Enter Valid Data !!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private boolean validUserData() {
        Email = username.getText().toString().trim();
        Password = password.getText().toString().trim();
        return !(Email.isEmpty() || Password.isEmpty());
    }

}
