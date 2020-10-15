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
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.example.library.Data.Entity.UserModel;
import com.example.library.Data.RespositoriesAPI.viewModel.LoginActivityViewModel;
import com.example.library.UI.BookScreen.BookDetailActivity;
import com.example.library.UI.LoginServiceScreen.RegisterActivity;
import com.example.library.Common.ConmonInterface.IActivity;
import com.example.library.UI.UserScreen.USMainActivity;

/**
 * Login Activity for Login UI Screen
 */
public class LoginActivity extends Activity implements IActivity {
    private EditText txtUserName;
    private EditText txtPassword;
    private Button btnLogin;
    private TextView txtError;
    private TextView lbRegister;
    private boolean flag = false;
    private LoginActivityViewModel loginActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupUI();
        setupAction();
    }

    @Override
    public void setupUI() {
        txtUserName = findViewById(R.id.txtUserName);
        txtPassword = findViewById(R.id.txtPassword);
        txtUserName.setText("muoidiem");
        txtPassword.setText("123456");
        btnLogin = findViewById(R.id.btnLogin);
        txtError = findViewById(R.id.txtError);
        lbRegister = findViewById(R.id.txtRegister);
        //check database
       // loginActivityViewModel = (new ViewModelProvider((ViewModelStoreOwner) this))
       //        .get(LoginActivityViewModel.class);
    }

    private String getTxtUserName() {
        return txtUserName.getText().toString().trim();
    }

    private String getTxtPassword() {
        return txtPassword.getText().toString().trim();
    }

    private void login(){
        loginActivityViewModel.login(getTxtUserName(),getTxtPassword());
        loginActivityViewModel.getUser().observe((LifecycleOwner) this,
                new Observer<UserModel>() {
                    @Override
                    public void onChanged(UserModel user) {
                        //To-do
                        //luu sqlite
                        Intent intent = new Intent(LoginActivity.this, USMainActivity.class);
                        LoginActivity.this.startActivity(intent);
                    }
                }
        );
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
//                if(!flag){
//                    txtError.setText(getResources().getString(R.string.invalidUsername));
//                    txtUserName.requestFocus();
//                }else if(txtPassword.getText().length() < 3){
//                    txtError.setText(getResources().getString(R.string.invalidPassword));
//                    txtPassword.requestFocus();
//                }else{
//                    //Call API check username and password
//                   LoginActivity.this.login();
//                }
                Intent intent = new Intent(LoginActivity.this, BookDetailActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
        lbRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
    }
}