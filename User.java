// Base class for User
public class User {
    protected String username;
    protected String password;
    protected int lives;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.lives = 3;
    }

    public String getUserInfo() {
        return username + ":" + password;
    }

    // overloading function
    public String getUserInfo(boolean onlyUsername) {
        if (onlyUsername) {
            return username;
        } else {
            return getUserInfo();
        }
    }

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

    public int getLives() {
        return lives;
    }

    // Method overridden in Admin class
    public void performSpecialAction() {
        System.out.println("Regular action performed.");
    }
}