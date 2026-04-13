package com.mychatbot.quickchatapp;

public class Login {

    public boolean checkUserName(String username) {
        // must contain underscore and be <= 5 characters
        return username.contains("_") && username.length() <= 5;
    }
}