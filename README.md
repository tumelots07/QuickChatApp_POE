# QuickChatApp_POE

Console-based Java chat application developed for a Programming POE assignment. The project demonstrates object-oriented programming, arrays, file handling, validation, and automated unit testing using JUnit 5 and GitHub Actions.

---

# 📌 Project Overview

QuickChatApp allows users to register, log in, send messages, store messages, search messages, and generate reports. The application follows OOP principles and uses unit testing to ensure functionality.

---

# 🚀 Features Implemented

## Part 1 – Registration and Login

### User Registration

Users register using:

* First Name
* Last Name
* Username
* Password
* South African Cell Phone Number

### Validation Rules

#### Username

Must:

* Contain an underscore (_)
* Be no more than 5 characters long

#### Password

Must:

* Be at least 8 characters long
* Contain a capital letter
* Contain a number
* Contain a special character

#### Cell Phone Number

Must:

* Include the international code (+27)
* Follow the South African number format

---

## Login System

Users log in using their username and password.

Successful login displays:

> Welcome [First Name], [Last Name], it is great to see you again.

---

# 📨 Part 2 – Sending Messages

## Welcome Menu

After login, users can:

1. Send Messages
2. Show Sent Messages
3. Quit

---

## Message Features

Users can:

* Specify how many messages they want to send.
* Send messages.
* Disregard messages.
* Store messages for later.

---

## Recipient Validation

Recipient numbers must:

* Include +27.
* Follow the correct South African format.

---

## Message Length Validation

Messages may not exceed 250 characters.

If exceeded, the application displays:

> Message exceeds 250 characters by X

---

## Message Hash

The system generates a message hash using:

* First two digits of Message ID
* Message number
* First word of message
* Last word of message

Example:

00:0:HITONIGHT

---

## JSON Storage

Stored messages are saved to:

storedMessages.json

---

# 📬 Part 3 – Message Management

## Arrays

The application maintains arrays for:

* Sent messages
* Stored messages
* Disregarded messages
* Message hashes
* Message IDs

---

## Longest Stored Message

The application searches stored messages and displays the message with the greatest length.

---

## Search Message by ID

Users can search for a message using its Message ID.

The application displays:

* Recipient
* Message contents

---

## Search Messages by Recipient

Users can enter a recipient number and display all messages sent to that recipient.

---

## Delete Message Using Message Hash

Messages can be removed using their unique message hash.

The system confirms successful deletion.

---

## Display Sender and Recipient

The application displays:

* Sender
* Recipient

for all stored messages.

---

## Message Reports

Reports display:

* Message Number
* Message Hash
* Recipient
* Message Text

---

## Read JSON File

Messages stored in:

storedMessages.json

can be read back into an array and displayed to the user.

---

# 🧪 Unit Testing

JUnit 5 tests are included for:

## Login Tests

* Username validation
* Password complexity
* Cell number validation
* Registration
* Login

## Message Tests

* Message ID generation
* Recipient validation
* Message length validation
* Message hash generation
* Send message option
* Store message option
* Disregard message option

## MessageManager Tests

* Sent messages array
* Longest stored message
* Search message by ID
* Search by recipient
* Delete by hash
* Display reports
* Message hash array
* Message ID array

---

# ⚙ Automated Testing

GitHub Actions automatically runs Maven tests using:

TestJava.yml

All tests execute automatically whenever code is pushed to GitHub.

---

# 🛠 Technologies Used

* Java JDK 23
* Apache NetBeans IDE 23
* Maven
* JUnit 5
* Git
* GitHub
* GitHub Actions

---

# 📁 Project Structure

```
src
├── main
│   └── java
│       └── com.mychatbot.quickchatapp
│           ├── Login.java
│           ├── Message.java
│           ├── MessageManager.java
│           └── QuickChatApp.java
│
├── test
│   └── java
│       └── com.mychatbot.quickchatapp
│           ├── LoginTest.java
│           ├── MessageTest.java
│           └── MessageManagerTest.java
```

---

# 👨‍💻 Author

Student Programming POE Assignment

Developed using:

* Object-Oriented Programming
* Arrays
* File Handling
* Validation Logic
* Unit Testing
* Git Branching Workflow
* Continuous Integration with GitHub Actions

---

# ✅ Concepts Demonstrated

* Classes and Objects
* Encapsulation
* Arrays and ArrayLists
* String Manipulation
* File Handling
* Exception Handling
* Loops
* Validation Logic
* JSON Storage
* Unit Testing
* Continuous Integration
* GitHub Workflow
