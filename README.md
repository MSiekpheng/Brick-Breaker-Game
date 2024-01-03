**Brick Breaker Game**
This repository features a Java implementation of a Brick Breaker Game. The game involves breaking bricks with a bouncing ball controlled by a paddle. Below is a breakdown of the key components and features of the game.

**Classes & Objects**:

AuthenticationSystem: Manages user registration, login, and authentication.
Game: Main class that handles the game loop, user interactions, and menu.
Gameplay: Implements the actual gameplay, including the paddle, ball, and brick interactions.
MapGenerator: Generates the layout of bricks for the game.
Inheritance:

The Admin class inherits from the User class, representing an admin user with extended functionalities.
Constructors:

Constructors are present in classes like AuthenticationSystem, Gameplay, and others, initializing necessary components during object creation.
Overloading Method:

getUserInfo method in the User class is overloaded to provide different representations.
Overriding Method:

performSpecialAction method is overridden in both User and Admin classes.
Polymorphism:

Achieved through method overriding and overloading, enabling flexibility in handling users and admins. Casting is done implicitly when checking if a user is an instance of Admin.
Encapsulation:

Access modifiers like private, protected, and public are used to encapsulate the fields of the classes, controlling access to the data.
Abstraction:

Achieved through the MapDrawable interface, providing a blueprint for drawing maps in the game.
Exception Handling:

Exceptions are handled using try-catch blocks in the AuthenticationSystem and Game classes, ensuring smooth error handling during user interactions.
File I/O:

The AuthenticationSystem class uses file I/O to save and load user information from a file.
Lambda Expression:

Lambda expressions are utilized with the AuthenticationInterface interface in the AuthenticationSystem class for concise implementation of file loading and saving operations.
Static Method:

initializeGame method in the Gameplay class is static, allowing for the initialization of the game without creating an instance of the class.
This Brick Breaker Game showcases various fundamental programming concepts and best practices, providing an enjoyable gaming experience. Feel free to explore and contribute to enhance the gaming experience.