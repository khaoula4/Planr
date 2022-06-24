package com.example.planr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Userprofile extends AppCompatActivity {


    TextInputLayout fullName,email,password;
    TextView fullNameLabel,usernameLabel;

    String _PASSWORD,_NAME,_USERNAME,_EMAIL;

    FirebaseDatabase  database = FirebaseDatabase.getInstance();
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_userprofile);

        fullName = findViewById(R.id.full_name_profile);
        email = findViewById(R.id.email_profile);
        password = findViewById(R.id.password_profile);

        fullNameLabel = findViewById(R.id.fullname_field);
        usernameLabel = findViewById(R.id.username_field);

        showAllUserData();

        reference = FirebaseDatabase.getInstance().getReference("users");
    }

    private void showAllUserData() {
        Intent intent = getIntent();
        String user_username = intent.getStringExtra("username");
        String user_name = intent.getStringExtra("name");
        String user_email = intent.getStringExtra("email");
        String user_password = intent.getStringExtra("password");

        fullNameLabel.setText(user_name);
        usernameLabel.setText(user_username);
        fullName.getEditText().setText(user_name);
        email.getEditText().setText(user_email);
        password.getEditText().setText(user_password);



    }

    public void update(View view){
        if(!isNameChanged() | !isPasswordChanged() | !isEmailChanged() ){
            Toast.makeText(this,"Data updated succesfully",Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(this,"No update",Toast.LENGTH_LONG).show();
        }


    }
    public void todo(View view){
        Intent intent=new Intent(Userprofile.this,ToDo.class);

        startActivity(intent);



    }

    public void calender(View view){

        Intent intent=new Intent(Userprofile.this,Calendar.class);

        startActivity(intent);



    }

    private boolean isPasswordChanged(){
        if(!_PASSWORD.equals(password.getEditText().getText().toString()))
        {
            reference.child(_USERNAME).child("password").setValue(password.getEditText().getText().toString());
            _PASSWORD=password.getEditText().getText().toString();
            return true;
        }else{
            return false;
        }
    }
    private boolean isNameChanged(){
        if(!_NAME.equals(fullName.getEditText().getText().toString())){
            reference.child(_USERNAME).child("name").setValue(fullName.getEditText().getText().toString());
            _NAME=fullName.getEditText().getText().toString();
            return true;
        }else{
            return false;
        }

    }

    private boolean isEmailChanged(){
        if(!_EMAIL.equals(email.getEditText().getText().toString())){
            reference.child(_USERNAME).child("email").setValue(email.getEditText().getText().toString());
            _EMAIL=email.getEditText().getText().toString();
            return true;
        }else{
            return false;
        }

    }




}