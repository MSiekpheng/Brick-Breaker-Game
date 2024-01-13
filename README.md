# Brick-Breaker-Game 

## Table of Content
- [Introduction](#introduction)
- [Classes & Objects](#classes--objects)
- [Inheritance](#inheritance)
- [Polymorphism](#polymorphism)
- [Encapsulation](#encapsulation)
- [Abstraction](#abstraction)
- [Exception Handling](#exception-handling)
- [File I/O](#file-io)
- [Lambda Expressions](#lambda-expression)
- [Static Methods](#static-methods)

## Introduction

This repository features a Java implementation of a Brick Breaker Game. The game involves breaking bricks with a bouncing ball controlled by a paddle. We also include registration and authentication where user need to log in in order to access the Brick Breaker Game. Below is a breakdown of the key components and features of the project.

### Authentication

- **AuthenticationSystem** (Manages user authentication, registration, and file I/O)

### Player

- **Game** (Facilitates user interactions and game flow)
- **Gameplay** (Handles gameplay functionality and user actions)
- **MapGenerator** (Generates maps for the gameplay)
- **User** (Represents regular users and handles authentication)

### Admin

- **Admin** (Represents admin users with extended privileges)

## Object-Oriented Programming (OOP) Concepts

### Classes & Objects

#### Classes
Classes define the blueprint for creating objects, encapsulating data and behavior into a single unit.
- Classes, such as `Game`, `AuthenticationSystem`, `Admin`, `User`, etc., define the structure for objects in the system.
- Each class represents a different part or functionality in the brick breaker game system.

#### Class Overview

**Admin Class**

- Represents admin users with extended privileges.

**AuthenticationSystem Class**

- Manages user authentication, registration, and file I/O.

**Game Class**

- Facilitates user interactions and game flow.

**Gameplay Class**

- Handles gameplay functionality and user actions.

**MapGenerator Class**

- Generates maps for the gameplay.

**User Class**

- Represents regular users and handles authentication.

#### Objects
Objects are instances of classes, representing real-world entities and encapsulating their state and behavior.
- Creating an AuthenticationSystem object to handle user authentication and data management 
    - `AuthenticationSystem authSystem = new AuthenticationSystem();`
- The gameplay object lies in initiating the gameplay session for a user who has successfully logged in.    
    - `Gameplay gamePlay = new Gameplay(loginStatus, loginUsername, loginPassword);`
- Creates a User instance by initializing it with a provided username and password, used for representing and managing user-related information in the game.
    - `User user = new User(userInfo[0], userInfo[1]);`

### Inheritance
Inheritance allows a class (subclass) to inherit attributes and methods from another class, facilitating code reuse and creating a hierarchy of related classes.
- Inheritance creates a hierarchy of classes.
- `Admin` and `User` share common attributes and methods defined in the `User` class.
- `OperationManager` and `OperationSeller` inherit common behavior from the `Operation` class.
### Inheritance Structure

**User Class:**

- Base class for regular users and administrators.
- Manages user attributes, authentication, and gameplay-related functionality.

**Admin Class:**

- Inherits from User with specialized methods.
- Overrides performSpecialAction for administrators.

```java
// Inheritance
public class Admin extends User {
// ...
}

public class OperationManager extends Operation {...}

```
### Polymorphism
Polymorphism enables objects to take on multiple forms, allowing them to be treated as instances of their parent class while exhibiting specific behaviors of their own.
#### Casting

- **Demonstration:** Polymorphism is demonstrated through casting, enabling a more specific type to be treated as its base type.
- **Usage:**
    - Casting is employed to handle both regular users and administrators uniformly, treating them as generic users.
    - Instances are cast when dealing with different user types, allowing specific actions based on their actual roles.

```java
// Casting Example in AuthenticationSystem Class
User retrievedUser = loginInfo.get(username);
if (retrievedUser instanceof Admin) {
    Admin adminUser = (Admin) retrievedUser;
    // Perform admin-specific actions
} else {
    // Perform regular user actions
}
```
### Encapsulation
Encapsulation bundles the data (attributes) and methods that operate on the data into a single unit, protecting the internal state of an object and promoting modularity.
**Access Modifiers:**

- **public:**
    - Accessible from any class.
    - Used for methods that need to be accessible externally.
    ```java
    // Public method in User class
    public int getLives() {
        return lives;
    }
    ```
- **private:**
    - Accessible only within the same class.
    - Used for fields and methods that should not be modified externally.
    ```java
    // Private fields and method in User class
    private String username;
    private void performSpecialAction() {
        // Implementation
    }
    ```
- **protected:**
    - Accessible within the same package and by subclasses.
    - Used for methods that are intended for internal use within the package or by subclasses.
    ```java
    // Protected method in Gameplay class
    protected void keyPressed(KeyEvent e) {
        // Implementation
    }
    ```


### Abstraction
Abstraction involves creating abstract classes or interfaces that define a common structure for derived classes, emphasizing essential features while hiding implementation details.
**Abstract Classes:**

- **Purpose:**
    - Define a blueprint for classes with shared functionality.
    - Cannot be instantiated directly, but serve as a base for subclasses.
    ```java
    // Abstract class in AuthenticationSystem.java
    abstract class AuthenticationInterface {
        abstract void saveAndLoadUsers(); // Abstract method
    }
    ```

**Abstract Methods:**

- **Purpose:**
    - Declared in abstract classes without implementation.
    - Enforce implementation in subclasses.

    ```java
    // Abstract method in AuthenticationInterface
    abstract void saveAndLoadUsers();

### Exception Handling
Exception handling deals with runtime errors, providing mechanisms to gracefully handle and recover from unexpected situations, preventing program crashes.
**Types of Exceptions Handled:**

- **File Not Found (IOException):**
    - **Purpose:**
        - Handles situations where the specified file path is incorrect or the file is not found.
        - Prevents the application from crashing and provides an error message.
    - **Example:**
        ```java
        // Exception handling for file not found in AuthenticationSystem.java
        try (Scanner fileScanner = new Scanner(filePath.toFile())) {
            // Read data from the file
        } catch (IOException e) {
            System.err.println("Error loading users from file: " + e.getMessage());
        }
        ```

- **Wrong Input Data Type (NumberFormatException):**
    - **Purpose:**
        - Catches errors when users enter non-numeric data that needs to be converted to a number.
        - Informs users of the mistake, clears input fields, and avoids program crashes.
    - **Example:**
        ```java
        // Exception handling for wrong input data type in Gameplay.java
        try {
            int tmpID = Integer.parseInt(idField.getText());
            // Process user input
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Wrong input data type. Please try again.");
            // Handle the exception by displaying an error message and clearing the input fields
        }
        ```

### File I/O
File I/O in Java involves reading from and writing to files, enabling the interaction between a program and external storage. This concept allows data to be persisted, retrieved, and manipulated, enhancing the functionality and data management capabilities of Java applications.

**Files Used:**

- **users.txt:**
    - **Purpose:** Stores user data, including usernames, passwords, and admin status.
    - **Format:** Each line represents a user with the format: `username:password:adminStatus`.
    - **Benefits:**
        - *Simplifies user data management by consolidating information into a single file.*
        - *Facilitates easy access and modification of user data.*
### Lambda Expression
Lambda expressions introduce a concise way to write anonymous functions, enhancing code readability and supporting functional programming constructs.

**Purpose:**

- Enhance code readability and functionality by providing a concise way to define functions.

**Example:**

**Filter Operation:**

- Used to select specific elements from a collection based on a condition.

```java
List<User> adminUsers = userList.stream()
        .filter(user -> user instanceof Admin)
        .collect(Collectors.toList());
```

### Static Methods
Static methods belong to a class rather than an instance, providing utility functions or operations that don't rely on the state of an object and can be called directly on the class.
**Purpose:**

- Provide functionality that can be accessed without creating objects of a class.

**Example:**

**AuthenticationSystem Class:**

- **`authenticateUser` method:**
    - Checks user credentials to authenticate them.
    - Accessible without creating an instance of the class.

```java
public static int authenticateUser(String username, String password)
