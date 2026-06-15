package com.mychatbot.quickchatapp;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MessageManager {

    // Arrays required for Part 3
    private ArrayList<Message> sentMessages = new ArrayList<>();
    private ArrayList<Message> disregardedMessages = new ArrayList<>();
    private ArrayList<Message> storedMessages = new ArrayList<>();

    private ArrayList<String> messageHashes = new ArrayList<>();
    private ArrayList<String> messageIDs = new ArrayList<>();

    // =========================
    // ADD MESSAGE
    // =========================
    public void addMessage(Message msg, String flag) {

        messageHashes.add(msg.getMessageHash());
        messageIDs.add(msg.getMessageID());

        switch (flag.toUpperCase()) {

            case "SENT":
                sentMessages.add(msg);
                break;

            case "STORED":
                storedMessages.add(msg);
                break;

            case "DISREGARD":
                disregardedMessages.add(msg);
                break;
        }
    }

    // =========================
    // GETTERS
    // =========================
    public ArrayList<Message> getSentMessages() {
        return sentMessages;
    }

    public ArrayList<Message> getStoredMessages() {
        return storedMessages;
    }

    public ArrayList<Message> getDisregardedMessages() {
        return disregardedMessages;
    }

    public ArrayList<String> getMessageHashes() {
        return messageHashes;
    }

    public ArrayList<String> getMessageIDs() {
        return messageIDs;
    }

    // =========================
    // DISPLAY SENDER & RECIPIENT
    // =========================
    public String displaySenderRecipient() {

        StringBuilder result = new StringBuilder();

        for (Message msg : storedMessages) {

            result.append("Sender: ")
                    .append(msg.getSender())
                    .append("\nRecipient: ")
                    .append(msg.getRecipient())
                    .append("\n\n");
        }

        return result.toString();
    }

    // =========================
    // LONGEST STORED MESSAGE
    // =========================
    public String getLongestStoredMessage() {

        if (storedMessages.isEmpty()) {
            return "No stored messages.";
        }

        Message longest = storedMessages.get(0);

        for (Message msg : storedMessages) {

            if (msg.getMessageText().length()
                    > longest.getMessageText().length()) {

                longest = msg;
            }
        }

        return longest.getMessageText();
    }

    // =========================
    // SEARCH BY MESSAGE ID
    // =========================
    public String searchMessageByID(String id) {

        for (Message msg : sentMessages) {

            if (msg.getMessageID().equals(id)) {

                return "Recipient: "
                        + msg.getRecipient()
                        + "\nMessage: "
                        + msg.getMessageText();
            }
        }

        for (Message msg : storedMessages) {

            if (msg.getMessageID().equals(id)) {

                return "Recipient: "
                        + msg.getRecipient()
                        + "\nMessage: "
                        + msg.getMessageText();
            }
        }

        return "Message not found.";
    }

    // =========================
    // SEARCH BY RECIPIENT
    // =========================
    public String searchRecipient(String recipient) {

        StringBuilder result = new StringBuilder();

        for (Message msg : sentMessages) {

            if (msg.getRecipient().equals(recipient)) {

                result.append(msg.getMessageText())
                        .append("\n");
            }
        }

        for (Message msg : storedMessages) {

            if (msg.getRecipient().equals(recipient)) {

                result.append(msg.getMessageText())
                        .append("\n");
            }
        }

        if (result.length() == 0) {
            return "No messages found.";
        }

        return result.toString();
    }

    // =========================
    // DELETE USING HASH
    // =========================
    public String deleteMessageByHash(String hash) {

        for (int i = 0; i < storedMessages.size(); i++) {

            if (storedMessages.get(i)
                    .getMessageHash()
                    .equals(hash)) {

                String deleted =
                        storedMessages.get(i)
                                .getMessageText();

                storedMessages.remove(i);

                return "Message: \""
                        + deleted
                        + "\" successfully deleted.";
            }
        }

        return "Message not found.";
    }

    // =========================
    // DISPLAY REPORT
    // =========================
    public String displayReport() {

    if (storedMessages.isEmpty()) {
        return "No stored messages.";
    }

    StringBuilder report = new StringBuilder();

    for (Message msg : storedMessages) {

        report.append("Message Hash: ")
              .append(msg.getMessageHash())
              .append("\nRecipient: ")
              .append(msg.getRecipient())
              .append("\nMessage: ")
              .append(msg.getMessageText())
              .append("\n\n");
    }

    return report.toString();
}

    // =========================
    // DISPLAY SENT MESSAGES
    // =========================
    public String displaySentMessages() {

        StringBuilder report = new StringBuilder();

        for (Message msg : sentMessages) {

            report.append("Message Hash: ")
                    .append(msg.getMessageHash())
                    .append("\nRecipient: ")
                    .append(msg.getRecipient())
                    .append("\nMessage: ")
                    .append(msg.getMessageText())
                    .append("\n\n");
        }

        return report.toString();
    }

    // =========================
    // READ JSON FILE INTO ARRAY
    // =========================
    public ArrayList<String> readStoredMessagesFile() {

        ArrayList<String> messages = new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("storedMessages.json"));

            String line;

            while ((line = reader.readLine()) != null) {

                messages.add(line);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Error reading file.");
        }

        return messages;
    }
}