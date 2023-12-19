import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AuthenticationSystem {
    private Map<String, String> loginInfo;
    private File file;

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

    public boolean register(String username, String password) {
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
        return true; // Registration successful
    }

    public boolean authenticate(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    public boolean login(String username, String password) {
        return loginInfo.containsKey(username) && loginInfo.get(username).equals(password);
    }
}