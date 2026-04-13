package com.mychatbot.quickchatapp;

public class Login {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellNumber;

    // =========================
    // USERNAME VALIDATION
    // =========================
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // =========================
    // PASSWORD VALIDATION
    // =========================
    public boolean checkPasswordComplexity(String password) {
        boolean hasLength = password.length() >= 8;
        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()._+=<>?/{}~\\[\\]-].*");

        return hasLength && hasUpper && hasNumber && hasSpecial;
    }

    // =========================
    // CELL PHONE VALIDATION
    // =========================
    public boolean checkCellPhoneNumber(String cell) {
        return cell.matches("^\\+27[0-9]{9}$");
    }

    // =========================
    // REGISTER USER
    // =========================
    public String registerUser(String firstName, String lastName,
                               String username, String password,
                               String cellNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellNumber = cellNumber;

        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        return "User successfully registered.";
    }

    // =========================
    // LOGIN
    // =========================
    public boolean loginUser(String username, String password) {
        return this.username != null &&
               this.username.equals(username) &&
               this.password.equals(password);
    }

    // =========================
    // LOGIN MESSAGE
    // =========================
    public String returnLoginStatus() {
        if (loginUser(username, password)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}