package com.example.creationgallery;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class social extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social);
        findViewById(R.id.id_youtube).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked_btn("https://www.youtube.com/channel/UCMC6BK6ZpY1ZkE1jEUyqccA?view_as=subscriber");
            }
        });
        findViewById(R.id.id_instagram).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked_btn("https://www.instagram.com/sachin_g_427");
            }
        });
        findViewById(R.id.id_facebook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked_btn("https://www.facebook.com/profile.php?id=364113334341303");
            }
        });

    }

    public void clicked_btn(String url)
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}