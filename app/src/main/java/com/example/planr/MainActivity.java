package com.example.planr;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static int SPLASH_SCREEN=4000;
    private ImageView image;
    private TextView logo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();


        setContentView(R.layout.activity_main);


        image = findViewById(R.id.image1);
        logo = findViewById(R.id.logo);
        //Animations
        Animation topAnim = AnimationUtils.loadAnimation(this, R.anim.up);
        Animation bottomAnim = AnimationUtils.loadAnimation(this, R.anim.down);

        //Set animation to elements
        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                //Call next screen
                Intent intent=new Intent(MainActivity.this,ToDo.class);

                startActivity(intent);



            }
        },SPLASH_SCREEN);

    }



}