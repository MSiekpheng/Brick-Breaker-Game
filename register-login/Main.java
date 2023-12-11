import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AuthenticationSystem authSystem = new AuthenticationSystem("users.txt");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String regUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String regPassword = scanner.nextLine();
                    boolean regStatus = authSystem.register(regUsername, regPassword);
                    if (regStatus) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Username already exists. Try a different username.");
                    }
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    boolean loginStatus = authSystem.login(loginUsername, loginPassword);
                    if (loginStatus) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
