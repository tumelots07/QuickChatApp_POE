package com.mychatbot.quickchatapp;

import java.util.Scanner;

public class QuickChatApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        System.out.println("===== QUICKCHAT APP =====");

        // REGISTER
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter cell phone number (+27...): ");
        String cell = input.nextLine();

        String registerResult = login.registerUser(firstName, lastName, username, password, cell);
        System.out.println(registerResult);

        // STOP IF REGISTRATION FAILS
        if (!registerResult.equals("User successfully registered.")) {
            System.out.println("Cannot proceed to login.");
            return;
        }

        // LOGIN
        System.out.println("\n=== LOGIN ===");

        System.out.print("Enter username: ");
        String loginUser = input.nextLine();

        System.out.print("Enter password: ");
        String loginPass = input.nextLine();

        boolean loggedIn = login.loginUser(loginUser, loginPass);

        System.out.println(login.returnLoginStatus());
    }
}