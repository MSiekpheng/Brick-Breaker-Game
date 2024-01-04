# Brick Breaker Game

## Introduction

This repository showcases a Java implementation of a Brick Breaker Game. The game involves breaking bricks with a bouncing ball controlled by a paddle. It incorporates user registration, login, and authentication functionalities to access the game.

## Overview

The Brick Breaker Game is a Java-based project featuring key components such as user authentication, dynamic gameplay mechanics, and a customizable map generator. With the inheritance of user roles, robust exception handling, and an engaging user interface, this project encapsulates the essence of a classic arcade game while integrating modern programming concepts.

## Table of Contents
  - [Introduction](#introduction)
  - [Overview](#overview)
  - [Table of Contents](#table-of-contents)
  - [Features](#features)
    - [Authentication System](#authentication-system)
    - [Dynamic Gameplay](#dynamic-gameplay)
    - [Map Generator](#map-generator)
    - [User Roles](#user-roles)
  - [Classes \& Objects](#classes--objects)
    - [Classes](#classes)
    - [Objects](#objects)
  - [Inheritance:](#inheritance)
    - [Superclass \& Subclass:](#superclass--subclass)
  - [Constructor](#constructor)
  - [Overloading Method](#overloading-method)
    - [getUserInfo() Method (User Class)](#getuserinfo-method-user-class)
  - [Overriding Method](#overriding-method)
  - [Polymorphism](#polymorphism)
  - [Encapsulation](#encapsulation)
    - [Private \& Protected](#private--protected)
  - [Abstraction](#abstraction)
  - [Exception Handling](#exception-handling)
    - [Exception Handling Usage](#exception-handling-usage)
  - [File I/O](#file-io)
    - [File I/O Implementation](#file-io-implementation)
  - [Functional Interface/Lambda Expression](#functional-interfacelambda-expression)
  - [Static Method](#static-method)

---

## Features

### Authentication System

- Manage user registration, login, and secure authentication.

### Dynamic Gameplay

- Experience interactive gameplay with a bouncing ball, a paddle, and an array of breakable bricks.

### Map Generator

- Generate diverse brick layouts, adding variety and challenge to the gameplay.

### User Roles

- Introduce user roles with Admin functionalities, extending the gaming experience.


## Classes & Objects

### Classes

1. **Game.java**
   - Manages user registration, login, and gameplay initiation.

2. **Gameplay.java**
   - Represents the gameplay screen and controls game mechanics.

3. **AuthenticationSystem**
   - Handles user authentication, registration, and data storage.

4. **MapGenerator**
   - Generates the game's brick layouts and renders them on the screen.

5. **User & Admin**
   - Base and specialized classes for managing user information and roles.

### Objects

- Creating an AuthenticationSystem object to handle user authentication and data management 
    - `AuthenticationSystem authSystem = new AuthenticationSystem();`
- The gameplay object lies in initiating the gameplay session for a user who has successfully logged in.    
    - `Gameplay gamePlay = new Gameplay(loginStatus, loginUsername, loginPassword);`
- Creates a User instance by initializing it with a provided username and password, used for representing and managing user-related information in the game.
    - `User user = new User(userInfo[0], userInfo[1]);`

---

## Inheritance:

### Superclass & Subclass:

- **Superclass:** `User`
   - In our project we have one superclass, the `User` is the superclass and the the `Admin` class is a subclass that inherits from the User superclass.
   - Superclass: User is the base class, defining common properties and behaviors for all users. 
   - Subclass: Admin extends User, inheriting its attributes and methods while adding specific features for admin users.

## Constructor

Constructors are present in classes like AuthenticationSystem, Gameplay, and others, initializing necessary components during object creation

**Gameplay Class Constructor:**
   - Parameters: `int isAdmin, String username, String password`
   - Purpose: Initializes a Gameplay object.

**User Class Constructor:**
   - Parameters: `String username, String password`
   - Purpose: Initializes a User object.

**Admin Class Constructor:**
   - Parameters: `String username, String password`
   - Purpose: Initializes an Admin object.

---
    
## Overloading Method

### getUserInfo() Method (User Class)

- Overloads:
  - `String getUserInfo()`
  - `String getUserInfo(boolean onlyUsername)`
  - The first getUserInfo() method returns the concatenated string of username and password.
  - The second getUserInfo(boolean onlyUsername) method returns only the username.


---

## Overriding Method

- In this case, the ‘performSpecialAction()’ method in the Admin class overrides the method with the same signature in the User class. The @Override annotation indicates that this method is intentionally overriding the superclass's method.

Method in User class:

- `public void performSpecialAction() {
    JOptionPane.showMessageDialog(null, "Normal User have login. " + getUserInfo(true));
}`

Method in Admin class (overrides performSpecialAction() from User class):

@Override
- `public void performSpecialAction() {
    JOptionPane.showMessageDialog(null, "Admin User have special privileges. " + getUserInfo(true));
}`

---

## Polymorphism
- Explanation: When you have a reference to the superclass (User class) that points to an object of the subclass (Admin class) and you call the performSpecialAction() method through this reference, the method in the Admin class will be executed instead of the one in the User class.
- Purpose: This feature allows different behavior to be exhibited based on the actual type of the object, showing different behaviors for User and Admin instances while using a common method name.

## Encapsulation

### Private & Protected

- `private String username;` Field like username is marked as private. This ensures that these details are only manipulated within the respective classes.
- When to Use: Use private for fields and methods that should only be accessed within the same class. It provides the highest level of encapsulation, restricting direct access from external classes.
- Can be found in Admin.java, AuthenticationSystem.java, Gameplay.java and MapGenerator.java 

- `protected int lives;` The protected modifier is used for the lives field in the User class. This allows subclasses like Admin to access and manipulate the lives field.
- When to Use: Use protected for fields and methods that should be accessible within the same package and by subclasses (including those in different packages). It allows a controlled level of access for subclasses, promoting inheritance.
- Can be found in User.java

---

## Abstraction

In the `MapGenerator.java` file, we declared a MapDrawable interface contains two abstract methods:
- `void draw(Graphics2D g)` - This method is used to draw on the map. It takes a Graphics2D object as a parameter and defines the behavior to draw on the map using the Graphics2D API.

- `void setBrickValue(int value, int row, int col)` - This method is responsible for setting the value of a brick on the map. It takes three parameters: value (the value to set for the brick), row (the row number where the brick is located), and col (the column number where the brick is located).

---

## Exception Handling

### Exception Handling Usage

- Exception Handling: It is the process of handling runtime errors or exceptional situations that might occur during program execution.
- Exception handling is implemented using try-catch blocks, for instance, in the ‘Game’ class when handling InputMismatchException or general exceptions when user input invalid choices.

---

## File I/O

### File I/O Implementation

- We have implemented ‘users.txt’ file I/O to save the user’s information during the authentication. The file is also being used during the authentication process to check user login information. 

---

## Functional Interface/Lambda Expression

- The AuthenticationInterface is a functional interface since it has only one abstract method ‘saveAndLoadUsers()’.
- Lambda expressions are used to provide implementations for loading and saving users to/from a file. 
- `AuthenticationInterface loadUsers =()->{};` and `AuthenticationInterface saveUsers =()->{};` 

---
## Static Method

initializeGame()

- Static Method: It belongs to the class and not to the instances (objects) of the class. They can be called without creating an instance of the class.
- ‘initializeGame()’ is declared as a static method. Static methods belong to the class rather than to any specific instance of the class. They can be called using the class name itself ‘(Gameplay.initializeGame())’, without needing to create an object of the class.

registerUser():

- Signature: private static void registerUser(AuthenticationSystem authSystem, Scanner scanner)
- Purpose: This method handles the registration of new users within the Brick Breaker Game.

loginUser():

Signature: private static void loginUser(AuthenticationSystem authSystem, Scanner scanner)
Purpose: This method handles the login process for users within the Brick Breaker Game.

---
