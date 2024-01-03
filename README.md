# Project Name

## Table of Contents

- [Classes & Objects](#classes--objects)
- [Inheritance](#inheritance)
- [Constructor](#constructor)
- [Overloading Method](#overloading-method)
- [Overriding Method](#overriding-method)
- [Polymorphism](#polymorphism)
- [Encapsulation](#encapsulation)
- [Abstraction](#abstraction)
- [Exception Handling](#exception-handling)
- [File I/O](#file-io)
- [Functional Interface/Lambda Expression](#functional-interfacelambda-expression)
- [Static Method](#static-method)

---

## Classes & Objects

### Classes

1. **Game.java:**
    - Contains the main method to run the game.
    - Manages user registration, login, and initiation of gameplay.

2. **Gameplay.java:**
    - Represents the gameplay screen.
    - Handles game control.

3. **AuthenticationSystem:**
    - Manages user authentication, registration, and user data storage.
    - Utilizes lambda expressions for loading and saving user data from/to a file.

4. **MapGenerator:**
    - Generates the game's map with bricks.
    - Renders the map on the gameplay screen.

5. **User:**
    - Base class for users in the game.
    - Contains basic user information and methods for user authentication and game interaction.
    - Implements method overriding to demonstrate polymorphism.

6. **Admin:**
    - Subclass of User representing administrators.
    - Inherits properties and methods from the User class.
    - Overrides certain methods to exhibit specialized behavior.

### Objects

- `AuthenticationSystem authSystem = new AuthenticationSystem();`
    - Handles user authentication and data management.

- `Gameplay gamePlay = new Gameplay(loginStatus, loginUsername, loginPassword);`
    - Initiates the gameplay session for a logged-in user.

- `User user = new User(userInfo[0], userInfo[1]);`
    - Manages user-related information in the game.

---

## Inheritance: Superclass & Subclass

- **Superclass:** `User`
    - Defines common properties and behaviors for all users.

- **Subclass:** `Admin`
    - Extends `User` and adds specific features for admin users.

---

## Constructor

### Constructor Examples

- **Gameplay Class Constructor:**
    - Parameters: `int isAdmin, String username, String password`
    - Purpose: Initializes a `Gameplay` object.

- **User Class Constructor:**
    - Parameters: `String username, String password`
    - Purpose: Initializes a `User` object.

- **Admin Class Constructor:**
    - Parameters: `String username, String password`
    - Purpose: Initializes an `Admin` object.

---
