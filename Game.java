import java.util.InputMismatchException;
import java.util.Scanner;

// Main Game class
public class Game {
    public static void main(String[] args) {
        AuthenticationSystem authSystem = new AuthenticationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("1. Register\n2. Login\n3. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        registerUser(authSystem, scanner);
                        break;
                    case 2:
                        loginUser(authSystem, scanner);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    // Method to register users
    private static void registerUser(AuthenticationSystem authSystem, Scanner scanner) {
        try {
            System.out.println("Select role for registration:");
            System.out.println("1. User");
            System.out.println("2. Admin");
            System.out.print("Enter your choice: ");

            int roleChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter new username: ");
            String username = scanner.nextLine();

            System.out.print("Enter new password: ");
            String password = scanner.nextLine();
            authSystem.register(roleChoice, username, password);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    // Method to login users
    private static void loginUser(AuthenticationSystem authSystem, Scanner scanner) {
        try {
            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();

            int loginStatus = authSystem.login(loginUsername, loginPassword);
            if (loginStatus == 0 || loginStatus == 1) {
                Gameplay.initializeGame(loginStatus, loginUsername, loginPassword);
            }
        } catch (Exception e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }
}
