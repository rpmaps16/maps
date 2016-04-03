package com.maps.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * Created by ridwan-p on 4/3/16.
 */
public class NewUserActivity extends FragmentActivity {

    private  User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        user = new User();
    }

    public void btnSignUpOnclick(View view)
    {
        Intent intent = new Intent();

        intent.putExtra("user", user.getData());
        setResult(RESULT_OK, intent);

        finish();
    }
    public void btnCancelOnClick(View view)
    {
        setResult(RESULT_CANCELED,null);
        finish();
    }
}
