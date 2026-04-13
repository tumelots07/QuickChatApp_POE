package com.mychatbot.quickchatapp;

public class Login {

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        // At least 8 characters
        boolean length = password.length() >= 8;

        // Contains capital letter
        boolean capital = password.matches(".*[A-Z].*");

        // Contains number
        boolean number = password.matches(".*[0-9].*");

        // Contains special character
        boolean special = password.matches(".*[^a-zA-Z0-9].*");

        return length && capital && number && special;
    }
    
    // Regex reference: https://stackoverflow.com/
    public boolean checkCellPhoneNumber(String phoneNumber) {
    // Must start with +27 and be followed by 9 digits
    return phoneNumber.matches("^\\+27[0-9]{9}$");
    }
}