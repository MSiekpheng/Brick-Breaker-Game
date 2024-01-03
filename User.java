import javax.swing.JOptionPane;

// Base class for User
public class User {
    // Attributes
    protected String username;
    protected String password;
    protected int lives;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.lives = 3;
    }

    // Method to get user information
    public String getUserInfo() {
        return username + ":" + password;
    }

     // Overloaded method for getUserInfo
    public String getUserInfo(boolean onlyUsername) {
        if (onlyUsername) {
            return username;
        } else {
            return getUserInfo();
        }
    }

    // Method to authenticate user
    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    // Method to decrement life
    public void loseLife() {
        lives--;
    }

    // Method to check if the user is alive
    public boolean isAlive() {
        return lives > 0;
    }

    // Method to reset lives (if needed in the game logic)
    public int resetLives() {
        return lives = 3;
    }

    // Method to get lives
    public int getLives() {
        return lives;
    }

    // Method to perform special action (overridden in Admin class)
    public void performSpecialAction() {
        JOptionPane.showMessageDialog(null, "Normal User have login. " + getUserInfo(true));
    }
}