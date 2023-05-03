package com.ritick.attendancenfsu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etuserName,etPassword;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton = findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etuserName = findViewById(R.id.edittext1);
                etPassword = findViewById(R.id.edittext2);

                String username = etuserName.getText().toString();
                String password = etPassword.getText().toString();
                if(username.equals("admin")&&password.equals("admin")){
                    Intent i = new Intent(MainActivity.this,SelectionActivity.class);
                    startActivity(i);
                    System.out.println("Login Successfully with username: "+username);
                }
                else {
                    System.out.println("Login failed");
                    etuserName.setText("Invalid");
                    etPassword.setText("Invalid");
                }

            }
        });

    }
}