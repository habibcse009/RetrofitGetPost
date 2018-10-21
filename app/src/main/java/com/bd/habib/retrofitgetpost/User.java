package com.bd.habib.retrofitgetpost;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("user_id")
    private String username;

    @SerializedName("password")
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
