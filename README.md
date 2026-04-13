# QuickChatApp_POE
Chat application Part 1 - Registration and Login
## 📌 Project Overview
This project is a console-based Java chat application developed as part of a Programming POE assignment. It demonstrates object-oriented programming, input validation, and unit testing using JUnit 5.

---

## 🚀 Features Implemented

### 1. User Registration
Users are required to register using:
- First Name
- Last Name
- Username
- Password
- South African Cell Phone Number

### Validation Rules:
- Username must contain an underscore (_) and be no more than 5 characters long.
- Password must be at least 8 characters long and include:
  - A capital letter
  - A number
  - A special character
- Cell phone number must include international code (+27) and be correctly formatted.

---

### 2. Login System
- Users can log in using their registered username and password.
- Successful login displays a personalized welcome message:
  "Welcome <First Name>, <Last Name> it is great to see you again."

---

### 3. Unit Testing (JUnit 5)
The project includes automated unit tests for:
- Username validation
- Password complexity
- Cell phone number validation
- Registration process
- Login functionality

---

## 🧪 Technologies Used
- Java (JDK 23)
- Apache NetBeans IDE 23
- Maven
- JUnit 5
- Git & GitHub

---

## 📁 Project Structure

src/
├── main/java/com/mychatbot/quickchatapp
│ ├── QuickChatApp.java
│ ├── Login.java
│
├── test/java/com/mychatbot/quickchatapp
│ ├── LoginTest.java


---

## 👨‍💻 Author
Student Project - POE Assignment  
Developed using Java OOP principles and test-driven development.

---

## 📌 Notes
- This project follows clean code principles.
- All validation logic is separated into reusable methods.
- Unit tests ensure correctness of core functionality.

---
