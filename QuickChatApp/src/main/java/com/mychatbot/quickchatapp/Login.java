package com.mychatbot.quickchatapp;

public class Login {
    private String storedUsername;
    private String storedPassword;

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
    
    public String registerUser(String username, String password) {

    if (!checkUserName(username)) {
        return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
    }

    if (!checkPasswordComplexity(password)) {
        return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }

    // STORE credentials after successful validation
    storedUsername = username;
    storedPassword = password;

    return "User successfully registered.";
    }
    
    public boolean loginUser(String username, String password) {
    return username.equals(storedUsername) && password.equals(storedPassword);
    }
    
    public String returnLoginStatus(boolean isLoggedIn, String username) {

    if (isLoggedIn) {
        return "Welcome " + username + ", it is great to see you again.";
    } else {
        return "Username or password incorrect, please try again.";
    }
    }
}