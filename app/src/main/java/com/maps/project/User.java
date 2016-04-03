package com.maps.project;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ridwan-p on 4/3/16.
 */
public class User {
    private String username_;
    private String password_;
    private String email_;
    private String name_;

    public User(String name, String username, String password, String email)
    {
        username_ = username;
        name_ = name;
        password_= password;
        email_ = email;
    }

    public User()
    {
        username_ = password_= email_ = name_ = null;
    }

    public String getUsername_() {
        return username_;
    }

    public void setUsername_(String username_) {
        this.username_ = username_;
    }

    public String getPassword_() {
        return password_;
    }

    public void setPassword_(String password_) {
        this.password_ = password_;
    }

    public String getEmail_() {
        return email_;
    }

    public void setEmail_(String email_) {
        this.email_ = email_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public HashMap<String,String> getData()
    {
        HashMap<String,String> data = new HashMap<String, String>();

        data.put("username",username_);
        data.put("password",password_);
        data.put("email",email_);
        data.put("name",name_);

        return data;

    }
}
