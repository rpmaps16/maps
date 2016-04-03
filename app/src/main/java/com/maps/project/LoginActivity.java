package com.maps.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by ridwan-p on 4/3/16.
 */
public class LoginActivity extends FragmentActivity {

//    public static final int REQUEST_CODE_NEWUSER = 100;

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

    }

    public void btnLoginOnClick(View view)
    {
        if(txtUsername_.toString() == username_ && txtPassword_.toString() == password_)
        {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
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
