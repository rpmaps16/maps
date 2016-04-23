package com.maps.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by ridwan-p on 4/3/16.
 */
public class NewUserActivity extends FragmentActivity
{

    private User user_;
    private EditText txtUsername_;
    private EditText txtPass_;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        user_ = new User();
        txtUsername_ = (EditText) findViewById(R.id.txtUsername);
        txtPass_ = (EditText) findViewById(R.id.txtPass);
    }

    public void btnSignUpOnclick(View view)
    {
        Intent intent = new Intent();
        user_.setUsername(txtUsername_.getText().toString());
        user_.setPassword(txtPass_.getText().toString());
//        String data[] = {txtUsername_.getText().toString(),txtPass_.getText().toString()};
//        intent.putExtra("user",data);
        intent.putExtra("user", user_.getData());
        setResult(RESULT_OK, intent);
//        Log.e("user", user_.getUsername());
//        Log.e("pass", user_.getPassword());

        finish();
    }

    public void btnCancelOnClick(View view)
    {
        setResult(RESULT_CANCELED, null);
        finish();
    }
}
