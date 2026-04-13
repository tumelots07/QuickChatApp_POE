package com.mychatbot.quickchatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    Login login = new Login();

    @Test
    public void testValidUsername() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testValidPassword() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testValidCell() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testInvalidCell() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testRegisterSuccess() {
        assertEquals(
            "User successfully registered.",
            login.registerUser("Tumelo", "Mohuba", "tum_7", "SDmalome2$", "+27838968976")
        );
    }

    @Test
    public void testLoginSuccess() {
        login.registerUser("Tumelo", "Mohuba", "tum_7", "SDmalome2$", "+27838968976");
        assertTrue(login.loginUser("tum_7", "SDmalome2$"));
    }
}