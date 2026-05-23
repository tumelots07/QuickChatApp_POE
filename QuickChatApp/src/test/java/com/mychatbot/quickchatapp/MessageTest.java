package com.mychatbot.quickchatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testMessageLengthSuccess() {
        Message message = new Message();
        assertEquals("Message ready to send.",
                message.checkMessageLength("Hi Mike, can you join us for dinner tonight?"));
    }

    @Test
    public void testMessageLengthFailure() {
        Message message = new Message();

        String longMessage = "A".repeat(260);

        assertEquals("Message exceeds 250 characters by 10; please reduce the size.",
                message.checkMessageLength(longMessage));
    }

    @Test
    public void testRecipientCellSuccess() {
        Message message = new Message();

        assertEquals("Cell phone number successfully captured.",
                message.checkRecipientCell("+27718693002"));
    }

    @Test
    public void testRecipientCellFailure() {
        Message message = new Message();

        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                message.checkRecipientCell("08575975889"));
    }

    @Test
    public void testMessageHash() {
        Message message = new Message("0012345678", 0, "+27718693002",
                "Hi Mike, can you join us for dinner tonight?");

        assertEquals("00:0:HITONIGHT", message.createMessageHash());
    }

    @Test
    public void testMessageIDCreated() {
        Message message = new Message(0, "+27718693002",
                "Hi Mike, can you join us for dinner tonight?");

        assertTrue(message.checkMessageID());
    }

    @Test
    public void testSendMessageOption() {
        Message message = new Message(0, "+27718693002",
                "Hi Mike, can you join us for dinner tonight?");

        assertEquals("Message successfully sent.", message.SentMessage(1));
    }

    @Test
    public void testDisregardMessageOption() {
        Message message = new Message(1, "08575975889",
                "Hi Keegan, did you receive the payment?");

        assertEquals("Press 0 to delete the message.", message.SentMessage(2));
    }

    @Test
    public void testStoreMessageOption() {
        Message message = new Message(2, "+27718693002",
                "Please store this message.");

        assertEquals("Message successfully stored.", message.SentMessage(3));
    }
}