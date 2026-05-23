package com.mychatbot.quickchatapp;

import java.util.Scanner;

public class QuickChatApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        System.out.println("===== QUICKCHAT APP =====");

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

        if (!registerResult.equals("User successfully registered.")) {
            System.out.println("Cannot proceed to login.");
            return;
        }

        System.out.println("\n=== LOGIN ===");

        System.out.print("Enter username: ");
        String loginUser = input.nextLine();

        System.out.print("Enter password: ");
        String loginPass = input.nextLine();

        boolean loggedIn = login.loginUser(loginUser, loginPass);

        System.out.println(login.returnLoginStatus());

        if (loggedIn) {
            System.out.println("\nWelcome to QuickChat.");

            System.out.print("How many messages would you like to send? ");
            int maxMessages = Integer.parseInt(input.nextLine());

            int messageCounter = 0;
            int option = 0;

            while (option != 3) {
                System.out.println("\nSelect an option:");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");
                System.out.print("Choice: ");

                option = Integer.parseInt(input.nextLine());

                switch (option) {
                    case 1:
                        if (messageCounter >= maxMessages) {
                            System.out.println("You have reached the message limit.");
                            break;
                        }

                        System.out.print("Enter recipient cell number: ");
                        String recipient = input.nextLine();

                        System.out.print("Enter message: ");
                        String messageText = input.nextLine();

                        Message message = new Message(messageCounter, recipient, messageText);

                        String recipientResult = message.checkRecipientCell(recipient);
                        String messageLengthResult = message.checkMessageLength(messageText);

                        System.out.println(recipientResult);
                        System.out.println(messageLengthResult);

                        if (!recipientResult.equals("Cell phone number successfully captured.")
                                || !messageLengthResult.equals("Message ready to send.")) {
                            break;
                        }

                        System.out.println("Choose message action:");
                        System.out.println("1) Send Message");
                        System.out.println("2) Disregard Message");
                        System.out.println("3) Store Message");
                        System.out.print("Choice: ");

                        int sendChoice = Integer.parseInt(input.nextLine());

                        System.out.println(message.SentMessage(sendChoice));
                        System.out.println(message.printSingleMessage());

                        messageCounter++;
                        break;

                    case 2:
                        System.out.println("Coming Soon.");
                        break;

                    case 3:
                        System.out.println("Total messages entered: " + messageCounter);
                        System.out.println("Goodbye.");
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }
}