import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserFile {

    public static List<String> getUsernames(String filePath) {
        List<String> usernames = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split(":");
                if (userInfo.length >= 2) {
                    usernames.add(userInfo[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usernames;
    }

    public static void printUsernames(List<String> usernames) {
        if (usernames.isEmpty()) {
            System.out.println("No usernames found!");
        } else {
            System.out.println("Usernames in the file:");
            for (String username : usernames) {
                System.out.println(username);
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "users.txt";
        List<String> usernames = getUsernames(filePath);
        printUsernames(usernames);
    }
}
