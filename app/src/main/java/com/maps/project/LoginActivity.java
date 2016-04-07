package com.maps.project;

import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by ridwan-p on 4/3/16.
 */
public class LoginActivity extends FragmentActivity {


//    public static final int REQUEST_CODE_NEWUSER = 100;

    private Button daftar;
    private Button login;

    private String username_;
    private String password_;

    private EditText txtUsername_;
    private EditText txtPassword_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Log.d("Login", "open application");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        username_="admin";
        password_ = "admin";
        txtUsername_ = (EditText) findViewById(R.id.txtUsername);
        txtPassword_ = (EditText) findViewById(R.id.txtPassword);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {
            HashMap<String, String> tmp = (HashMap<String, String>) getIntent().getExtras().get("user");

            username_ = tmp.get("username");
            password_ = tmp.get("password");
        }

//        Log.d("username",username_);
//        Log.d("pass",password_);

    }

    public void btnLoginOnClick(View view)
    {
//        Log.d("username",username_);
//        Log.d("pass",password_);
//        Log.d("username",txtUsername_.getText().toString());
//        Log.d("pass", txtPassword_.getText().toString());

        if(txtUsername_.getText().toString().equals(username_) && txtPassword_.getText().toString().equals(password_))
        {
            Intent intent = new Intent();
            intent.putExtra("login",true);
            setResult(RESULT_OK,intent);
//            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(this, "Login GAGAL!!!", Toast.LENGTH_SHORT).show();
        }

    }
    public void btnCancelOnClick(View view)
    {
        finish();
    }

    public void btnNewUserOnClick(View view)
    {
        Intent intent = new Intent(this, NewUserActivity.class);
        startActivity(intent);
    }
}
