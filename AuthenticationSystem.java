import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AuthenticationSystem {
    private static final String USER_FILE_PATH = "users.txt";
    private Map<String, User> loginInfo;
    private String username;
    String password;
    private User loggedInUser;

    public AuthenticationSystem() {
        loginInfo = new HashMap<>();
        loadUsers();
    }

    private void loadUsers() {
        Path filePath = Paths.get(USER_FILE_PATH);

        try (Scanner fileScanner = new Scanner(filePath.toFile())) {
            while (fileScanner.hasNextLine()) {
                String[] userInfo = fileScanner.nextLine().split(":");
                if (userInfo.length == 2) {
                    User user = new User(userInfo[0], userInfo[1]);
                    loginInfo.put(userInfo[0], user);
                } else if (userInfo.length == 3 && userInfo[2].equals("admin")) {
                    Admin admin = new Admin(userInfo[0], userInfo[1]);
                    loginInfo.put(userInfo[0], admin);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading users from file: " + e.getMessage());
        }
    }

    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE_PATH))) {
            for (User user : loginInfo.values()) {
                if (user instanceof Admin) {
                    writer.write(user.getUserInfo() + ":admin");
                } else {
                    writer.write(user.getUserInfo());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving users to file: " + e.getMessage());
        }
    }

    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select role for registration:");
        System.out.println("1. User");
        System.out.println("2. Admin");
        System.out.print("Enter your choice: ");

        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (roleChoice != 1 && roleChoice != 2) {
            System.err.println("Invalid input!");
            return;
        }

        System.out.print("Enter new username: ");
        username = scanner.nextLine();

        System.out.print("Enter new password: ");
        password = scanner.nextLine();

        // Check if username or password is empty
        if (username.isEmpty() || password.isEmpty()) {
            System.err.println("Error: Empty username or password. Registration failed.");
            return;
        }

        if (loginInfo.containsKey(username)) {
            System.err.println("Error: Username already exists. Registration failed.");
            return; // Username already exists
        }

        User newUser;
        if (roleChoice == 2) {
            newUser = new Admin(username, password);
        } else {
            newUser = new User(username, password);
        }

        loginInfo.put(username, newUser);

        saveUsers();
        System.out.println("Registration successful for username: " + username);
        return; // Registration successful
    }

    public boolean authenticate(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    public boolean login(String username, String password) {
        User authenticatedUser = loginInfo.get(username);

        if (authenticatedUser != null && authenticatedUser.authenticate(username, password)) {
            loggedInUser = authenticatedUser; // Store authenticated user as loggedInUser
            if (authenticatedUser instanceof Admin) {
                System.out.println("Admin logged in!");
                return true;
            } else {
                System.out.println("Regular user logged in!");
                return true;
            }
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
            return false;
        }
    }

    public String getLoggedInUsername() {
        return (loggedInUser != null) ? loggedInUser.getUsername() : null;
    }

}
