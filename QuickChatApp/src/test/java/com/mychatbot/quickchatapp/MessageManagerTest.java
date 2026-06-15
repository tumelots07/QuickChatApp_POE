package com.mychatbot.quickchatapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageManagerTest {

    private MessageManager manager;

    @BeforeEach
    public void setup() {

        manager = new MessageManager();

        // Message 1 - Sent
        Message m1 = new Message(
                "1000000001",
                0,
                "+27834557896",
                "Did you get the cake?"
        );

        // Message 2 - Stored
        Message m2 = new Message(
                "1000000002",
                1,
                "+27838884567",
                "Where are you? You are late! I have asked you to be on time."
        );

        // Message 3 - Disregard
        Message m3 = new Message(
                "1000000003",
                2,
                "+27834484567",
                "Yohoooo, I am at your gate."
        );

        // Message 4 - Sent
        Message m4 = new Message(
                "0838884567",
                3,
                "0838884567",
                "It is dinner time !"
        );

        // Message 5 - Stored
        Message m5 = new Message(
                "1000000005",
                4,
                "+27838884567",
                "Ok, I am leaving without you."
        );

        manager.addMessage(m1, "SENT");
        manager.addMessage(m2, "STORED");
        manager.addMessage(m3, "DISREGARD");
        manager.addMessage(m4, "SENT");
        manager.addMessage(m5, "STORED");
    }

    // =========================
    // SENT MESSAGES ARRAY
    // =========================
    @Test
    public void testSentMessagesArray() {

        assertEquals(
                "Did you get the cake?",
                manager.getSentMessages()
                        .get(0)
                        .getMessageText());

        assertEquals(
                "It is dinner time !",
                manager.getSentMessages()
                        .get(1)
                        .getMessageText());
    }

    // =========================
    // LONGEST STORED MESSAGE
    // =========================
    @Test
    public void testLongestStoredMessage() {

        assertEquals(
                "Where are you? You are late! I have asked you to be on time.",
                manager.getLongestStoredMessage());
    }

    // =========================
    // SEARCH MESSAGE ID
    // =========================
    @Test
    public void testSearchMessageID() {

        assertEquals(
                "Recipient: 0838884567\nMessage: It is dinner time !",
                manager.searchMessageByID("0838884567"));
    }

    // =========================
    // SEARCH RECIPIENT
    // =========================
    @Test
    public void testSearchRecipient() {

        String expected =
                "Where are you? You are late! I have asked you to be on time.\n"
                + "Ok, I am leaving without you.\n";

        assertEquals(
                expected,
                manager.searchRecipient("+27838884567"));
    }

    // =========================
    // DELETE BY HASH
    // =========================
    @Test
    public void testDeleteMessageByHash() {

        String hash =
                manager.getStoredMessages()
                        .get(0)
                        .getMessageHash();

        String result =
                manager.deleteMessageByHash(hash);

        assertTrue(
                result.contains("successfully deleted"));
    }

    // =========================
    // DISPLAY REPORT
    // =========================
    @Test
    public void testDisplayReport() {

        String report = manager.displayReport();

        assertTrue(report.contains("Did you get the cake?"));
        assertTrue(report.contains("It is dinner time !"));
    }

    // =========================
    // MESSAGE HASH ARRAY
    // =========================
    @Test
    public void testMessageHashesArray() {

        assertEquals(
                5,
                manager.getMessageHashes().size());
    }

    // =========================
    // MESSAGE ID ARRAY
    // =========================
    @Test
    public void testMessageIDsArray() {

        assertEquals(
                5,
                manager.getMessageIDs().size());
    }

    // =========================
    // DISREGARDED ARRAY
    // =========================
    @Test
    public void testDisregardedMessagesArray() {

        assertEquals(
                1,
                manager.getDisregardedMessages().size());

        assertEquals(
                "Yohoooo, I am at your gate.",
                manager.getDisregardedMessages()
                        .get(0)
                        .getMessageText());
    }

    // =========================
    // STORED ARRAY
    // =========================
    @Test
    public void testStoredMessagesArray() {

        assertEquals(
                2,
                manager.getStoredMessages().size());
    }
}