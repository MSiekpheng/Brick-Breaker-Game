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

- Objects are instances of these classes. For example, an instance of the `Game` class is created in the main method.

### Inheritance

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

#### Code Example

```java
// Inheritance
public class Admin extends User {
// ...
}

public class OperationManager extends Operation {...}

```
### Polymorphism

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

# File I/O

**Files Used:**

- **users.txt:**
    - **Purpose:** Stores user data, including usernames, passwords, and admin status.
    - **Format:** Each line represents a user with the format: `username:password:adminStatus`.
    - **Benefits:**
        - *Simplifies user data management by consolidating information into a single file.*
        - *Facilitates easy access and modification of user data.*
### Lambda Expression

## Lambda Expressions

**Purpose:**

- Enhance code readability and functionality by providing a concise way to define functions.

**Examples:**

**Filter Operation:**

- Used to select specific elements from a collection based on a condition.

```java
List<User> adminUsers = userList.stream()
        .filter(user -> user instanceof Admin)
        .collect(Collectors.toList());
```

## Static Methods

**Purpose:**

- Provide functionality that can be accessed without creating objects of a class.

**Examples:**

**AuthenticationSystem Class:**

- **`authenticateUser` method:**
    - Checks user credentials to authenticate them.
    - Accessible without creating an instance of the class.

```java
public static int authenticateUser(String username, String password)