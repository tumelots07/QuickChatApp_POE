package com.mychatbot.quickchatapp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Message {

    private String messageID;
    private int messageNumber;
    private String sender;
    private String recipient;
    private String messageText;
    private String messageHash;

    private static int totalMessagesSent = 0;
    private static ArrayList<String> sentMessages = new ArrayList<>();

    // =========================
    // DEFAULT CONSTRUCTOR
    // =========================
    public Message() {
    }

    // =========================
    // NORMAL CONSTRUCTOR
    // =========================
    public Message(int messageNumber,
                   String recipient,
                   String messageText) {

        this.messageID = generateMessageID();
        this.messageNumber = messageNumber;
        this.sender = "Developer";
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }

    // =========================
    // CONSTRUCTOR FOR TESTS
    // =========================
    public Message(String messageID,
                   int messageNumber,
                   String recipient,
                   String messageText) {

        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.sender = "Developer";
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }

    // =========================
    // GENERATE MESSAGE ID
    // =========================
    public String generateMessageID() {

        Random rand = new Random();
        StringBuilder id = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            id.append(rand.nextInt(10));
        }

        return id.toString();
    }

    // =========================
    // CHECK MESSAGE ID
    // =========================
    public boolean checkMessageID() {

        return messageID != null
                && messageID.length() == 10;
    }

    // =========================
    // CHECK RECIPIENT
    // =========================
    public String checkRecipientCell(String cellNumber) {

        if (cellNumber.matches("^\\+27[0-9]{9}$")) {

            return "Cell phone number successfully captured.";
        }

        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    // =========================
    // CHECK MESSAGE LENGTH
    // =========================
    public String checkMessageLength(String message) {

        if (message.length() <= 250) {

            return "Message ready to send.";
        }

        int extraCharacters = message.length() - 250;

        return "Message exceeds 250 characters by "
                + extraCharacters
                + "; please reduce the size.";
    }

    // =========================
    // CREATE HASH
    // =========================
    public String createMessageHash() {

        String[] words = messageText.trim().split("\\s+");

        String firstWord =
                words[0].replaceAll("[^a-zA-Z0-9]", "");

        String lastWord =
                words[words.length - 1]
                        .replaceAll("[^a-zA-Z0-9]", "");

        return (messageID.substring(0, 2)
                + ":"
                + messageNumber
                + ":"
                + firstWord
                + lastWord).toUpperCase();
    }

    // =========================
    // SEND / DISREGARD / STORE
    // =========================
    public String SentMessage(int option) {

        switch (option) {

            case 1:

                totalMessagesSent++;
                sentMessages.add(messageText);

                return "Message successfully sent.";

            case 2:

    return "Press 0 to delete the message.";

            case 3:

                storeMessage();

                return "Message successfully stored.";

            default:

                return "Invalid option selected.";
        }
    }

    // =========================
    // PRINT ONE MESSAGE
    // =========================
    public String printSingleMessage() {

        return "Message ID: "
                + messageID
                + "\nMessage Hash: "
                + messageHash
                + "\nSender: "
                + sender
                + "\nRecipient: "
                + recipient
                + "\nMessage: "
                + messageText;
    }

    // =========================
    // PRINT ALL SENT MESSAGES
    // =========================
    public String printMessages() {

        StringBuilder output = new StringBuilder();

        for (String msg : sentMessages) {

            output.append(msg)
                    .append("\n");
        }

        return output.toString();
    }

    // =========================
    // TOTAL SENT MESSAGES
    // =========================
    public int returnTotalMessages() {

        return totalMessagesSent;
    }

    // =========================
    // STORE MESSAGE TO JSON
    // =========================
    public void storeMessage() {

        try {

            FileWriter writer =
                    new FileWriter("storedMessages.json", true);

            writer.write("{\n");
            writer.write("\"messageID\":\"" + messageID + "\",\n");
            writer.write("\"messageHash\":\"" + messageHash + "\",\n");
            writer.write("\"sender\":\"" + sender + "\",\n");
            writer.write("\"recipient\":\"" + recipient + "\",\n");
            writer.write("\"message\":\"" + messageText + "\"\n");
            writer.write("}\n");

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error storing message: "
                            + e.getMessage());
        }
    }

    // =========================
    // GETTERS
    // =========================
    public String getMessageID() {

        return messageID;
    }

    public String getMessageHash() {

        return messageHash;
    }

    public String getSender() {

        return sender;
    }

    public String getRecipient() {

        return recipient;
    }

    public String getMessageText() {

        return messageText;
    }

    public int getMessageNumber() {

        return messageNumber;
    }
}