import java.util.Scanner;
import javax.swing.JFrame;

public class Game {


    public static void main(String[] args) {
        AuthenticationSystem authSystem = new AuthenticationSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Select role for registration:");
                    System.out.println("1. User");
                    System.out.println("2. Admin");
                    System.out.print("Enter your choice: ");

                    int roleChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new username: ");
                    String username = scanner.nextLine();

                    System.out.print("Enter new password: ");
                    String password = scanner.nextLine();
                    authSystem.register(roleChoice, username, password);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();
                    int loginStatus = authSystem.login(loginUsername, loginPassword);
                    if (loginStatus == 0 || loginStatus == 1) {

                    
                        JFrame obj=new JFrame();
                        Gameplay gamePlay = new Gameplay(loginStatus);
                            
                        obj.setBounds(10, 10, 700, 600);
                        obj.setTitle("Breakout Ball");		
                        obj.setResizable(false);
                        obj.setVisible(true);
                        obj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);                            obj.add(gamePlay);
                        obj.setVisible(true);
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
