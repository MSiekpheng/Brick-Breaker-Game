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

#### Abstract Class & Method

- Abstract class `Operation` and its abstract method `runOperation()`.

#### Explanation

- The `Operation` class is abstract, preventing direct instantiation.
- The abstract method `runOperation()` enforces implementation in subclasses.

### Exception Handling

#### Handling Exceptions

- Handling `IOException` in file I/O operations.
- Handling `NumberFormatException` for input validation.

#### Explanation

- Exception handling is incorporated to gracefully manage unexpected errors.
- `IOException` is caught when reading/writing to files.
- `NumberFormatException` is caught for input validation.

### File I/O

#### Reading/Writing to Files

- Operations involving files like `Book.txt`, `Customer.txt`.

#### Explanation

- Files are used to store and retrieve specific data related to books, customers, etc.

### Lambda Expression

#### Lambda Expressions

- Loading and saving users using lambda expressions.

#### Explanation

- Lambda expressions are used for concise implementations of functional interfaces.
- In the code, lambda expressions are used to load and save users from/to files.

### Static Method

#### Static Methods

- Methods like `getManager()` and `getSeller()`.

#### Explanation

- Static methods provide functionality without needing an instance of the class.
- Examples like `getManager()` and `getSeller()` offer access without creating an object.
