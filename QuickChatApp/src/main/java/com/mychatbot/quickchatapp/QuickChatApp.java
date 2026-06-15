package com.mychatbot.quickchatapp;

import java.util.Scanner;

public class QuickChatApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();
        MessageManager manager = new MessageManager();

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

        String registerResult =
                login.registerUser(
                        firstName,
                        lastName,
                        username,
                        password,
                        cell);

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

        boolean loggedIn =
                login.loginUser(loginUser, loginPass);

        System.out.println(login.returnLoginStatus());

        if (!loggedIn) {
            return;
        }

        System.out.println("\nWelcome to QuickChat.");

        System.out.print("How many messages would you like to send? ");
        int maxMessages =
                Integer.parseInt(input.nextLine());

        int messageCounter = 0;
        int option = 0;

        while (option != 4) {

            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1) Send Messages");
            System.out.println("2) Stored Messages");
            System.out.println("3) Show Sent Messages");
            System.out.println("4) Quit");
            System.out.print("Choice: ");

            try {

                option = Integer.parseInt(input.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Invalid option.");
                continue;
            }

            switch (option) {

                case 1:

                    if (messageCounter >= maxMessages) {

                        System.out.println(
                                "You have reached the message limit.");
                        break;
                    }

                    System.out.print(
                            "Enter recipient cell number: ");
                    String recipient =
                            input.nextLine();

                    System.out.print(
                            "Enter message: ");
                    String messageText =
                            input.nextLine();

                    Message message =
                            new Message(
                                    messageCounter,
                                    recipient,
                                    messageText);

                    String recipientResult =
                            message.checkRecipientCell(recipient);

                    String messageLengthResult =
                            message.checkMessageLength(messageText);

                    System.out.println(recipientResult);
                    System.out.println(messageLengthResult);

                    if (!recipientResult.equals(
                            "Cell phone number successfully captured.")
                            ||
                            !messageLengthResult.equals(
                                    "Message ready to send.")) {

                        break;
                    }

                    System.out.println("\nChoose action:");
                    System.out.println("1) Send Message");
                    System.out.println("2) Disregard Message");
                    System.out.println("3) Store Message");
                    System.out.print("Choice: ");

                    int sendChoice;

                    while (true) {

                        try {

                            sendChoice =
                                    Integer.parseInt(input.nextLine());

                            if (sendChoice >= 1 && sendChoice <= 3) {
                                break;
                            }

                            System.out.print(
                                    "Enter 1, 2 or 3: ");

                        } catch (NumberFormatException e) {

                            System.out.print(
                                    "Enter 1, 2 or 3: ");
                        }
                    }

                    String result =
                            message.SentMessage(sendChoice);

                    System.out.println(result);

                    if (sendChoice == 1) {

                        manager.addMessage(
                                message,
                                "SENT");
                    }

                    if (sendChoice == 2) {

                        manager.addMessage(
                                message,
                                "DISREGARD");
                    }

                    if (sendChoice == 3) {

                        manager.addMessage(
                                message,
                                "STORED");
                    }

                    System.out.println(
                            message.printSingleMessage());

                    messageCounter++;

                    break;
                    
                case 2:

                    System.out.println(
                            "\n===== STORED MESSAGES =====");

                    System.out.println(
                            "1. Display sender and recipient");

                    System.out.println(
                            "2. Display longest stored message");

                    System.out.println(
                            "3. Search message by ID");

                    System.out.println(
                            "4. Search messages by recipient");

                    System.out.println(
                            "5. Delete message by hash");

                    System.out.println(
                            "6. Display report");

                    System.out.print("Choice: ");

                    int subChoice;

                    try {

                        subChoice =
                                Integer.parseInt(input.nextLine());

                    } catch (NumberFormatException e) {

                        System.out.println(
                                "Invalid choice.");

                        break;
                    }

                    switch (subChoice) {

                        // a. Display sender and recipient
                        case 1:

                            System.out.println(
                                    manager.displaySenderRecipient());

                            break;

                        // b. Display longest stored message
                        case 2:

                            System.out.println(
                                    manager.getLongestStoredMessage());

                            break;

                        // c. Search message by ID
                        case 3:

                            System.out.print(
                                    "Enter Message ID: ");

                            String id =
                                    input.nextLine();

                            System.out.println(
                                    manager.searchMessageByID(id));

                            break;

                        // d. Search by recipient
                        case 4:

                            System.out.print(
                                    "Enter Recipient: ");

                            String recipientSearch =
                                    input.nextLine();

                            System.out.println(
                                    manager.searchRecipient(
                                            recipientSearch));

                            break;

                        // e. Delete message by hash
                        case 5:

                            System.out.print(
                                    "Enter Message Hash: ");

                            String hash =
                                    input.nextLine();

                            System.out.println(
                                    manager.deleteMessageByHash(hash));

                            break;

                        // f. Display report
                        case 6:

    System.out.println(
            manager.displayStoredReport());

    break;

                        default:

                            System.out.println(
                                    "Invalid choice.");
                    }

                    break;

                case 3:

                    System.out.println(
                            "\n===== SENT MESSAGE REPORT =====");

                    System.out.println(
                            manager.displaySentMessages());

                    break;

                case 4:

                    System.out.println(
                            "\nTotal Messages Processed: "
                                    + messageCounter);

                    System.out.println(
                            "Goodbye.");

                    break;

                default:

                    System.out.println(
                            "Invalid option.");
            }
        }

        input.close();
    }
}