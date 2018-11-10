package com.example.scottstubbs.signup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    EditText Name;
    Button mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       mbutton = (Button)findViewById(R.id.button3);
       mbutton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
                Name = (EditText)findViewById(R.id.editText);
           }
       });


    }
}
