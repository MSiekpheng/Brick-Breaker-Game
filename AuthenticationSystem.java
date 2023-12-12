import java.io.*;
import java.util.*;

public class AuthenticationSystem {
    private Map<String, String> loginInfo;
    private File file;

    public AuthenticationSystem(String fileName) {
        loginInfo = new HashMap<>();
        file = new File(fileName);
        loadUsers();
    }

    private void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    loginInfo.put(parts[0], parts[1]);
                } else {
                    // Handle invalid format or incomplete lines
                    System.out.println("Invalid format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<String, String> entry : loginInfo.entrySet()) {
                String username = entry.getKey();
                String password = entry.getValue();
    
                writer.write(username + "," + password);
                writer.newLine();
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public boolean register(String username, String password) {
        // Check if username or password is empty
        if (username.isEmpty() || password.isEmpty()) {
            System.err.println("Error: Empty username or password. Registration failed.");
            return false;
        }
    
        if (loginInfo.containsKey(username)) {
            System.err.println("Error: Username already exists. Registration failed.");
            return false; // Username already exists
        }
    
        loginInfo.put(username, password);
        saveUsers();
        System.out.println("Registration successful for username: " + username);
        return true; // Registration successful
    }
    

    public boolean login(String username, String password) {
        return loginInfo.containsKey(username) && loginInfo.get(username).equals(password);
    }
}