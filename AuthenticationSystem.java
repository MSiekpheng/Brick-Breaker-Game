import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AuthenticationSystem {
    private static final String USER_FILE_PATH = "users.txt";
    private Map<String, User> loginInfo;

    public AuthenticationSystem() {
        loginInfo = new HashMap<>();
        loadUsers();
    }

    private void loadUsers() {
        Path filePath = Paths.get(USER_FILE_PATH);
    
        try (Scanner fileScanner = new Scanner(filePath.toFile())) {
            while (fileScanner.hasNextLine()) {
                String[] userInfo = fileScanner.nextLine().split(":");
                if ("0".equals(userInfo[2])) {
                    User user = new User(userInfo[0], userInfo[1]);
                    loginInfo.put(userInfo[0], user);
                } else if ("1".equals(userInfo[2])) {
                    Admin admin = new Admin(userInfo[0], userInfo[1]);
                    loginInfo.put(userInfo[0], admin);
                } else {
                    System.err.println("Invalid role value in the file.");
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
                    writer.write(user.getUserInfo() + ":1");
                } else {
                    writer.write(user.getUserInfo() + ":0");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving users to file: " + e.getMessage());
        }
    }

    public void register(int roleChoice, String username, String password) {
        

        if (roleChoice != 1 && roleChoice != 2) {
            System.err.println("Invalid input!");
            return;
        }

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

    public boolean authenticate(String enteredPassword, String password) {
        return password.equals(enteredPassword);
    }
    

    public int login(String username, String password) {
        User authenticatedUser = loginInfo.get(username);

        if (authenticatedUser != null && authenticatedUser.authenticate(username, password)) {
            if (authenticatedUser instanceof Admin) {
                System.out.println("Admin logged in!");
                return 1;
            } else {
                System.out.println("Regular user logged in!");
                return 0;
            }
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
            return 2;
        }
    }
    
}
