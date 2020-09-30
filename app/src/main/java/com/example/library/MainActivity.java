package com.example.library;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.library.LoginServiceScreen.RegisterActivity;
import com.example.library.UserScreen1.US1MainActivity;
import com.example.library.ConmonInterface.IActivity;

public class MainActivity extends Activity implements IActivity {
    private EditText txtUserName;
    private EditText txtPassword;
    private Button btnLogin;
    private TextView txtError;
    private TextView lbRegister;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        setupAction();
    }

    @Override
    public void setupUI() {
        txtUserName = findViewById(R.id.txtUserName);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtError = findViewById(R.id.txtError);
        lbRegister = findViewById(R.id.txtRegister);
        //check database

    }

    @Override
    public void setupAction() {
        txtUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String temp = txtUserName.getText().toString();
                if (temp != null && temp.length() < 5) {
                    txtError.setText(getResources().getString(R.string.invalidUsername));
                    flag = false;
                } else {
                    txtError.setText("");
                    flag = temp!=null;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        txtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txtError.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag){
                    txtError.setText(getResources().getString(R.string.invalidUsername));
                    txtUserName.requestFocus();
                }else if(txtPassword.getText().length() < 3){
                    txtError.setText(getResources().getString(R.string.invalidPassword));
                    txtPassword.requestFocus();
                }else{
                    //Call API check username and password
                    Intent intent = new Intent(MainActivity.this, US1MainActivity.class);
                    MainActivity.this.startActivity(intent);
                }
            }
        });
        lbRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}