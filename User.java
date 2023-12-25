// Base class for User
class User {
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
    public void resetLives() {
        lives = 3;  // Reset lives to default. Adjust as needed.
    }

    public int getLives() {
        return lives;
    }
}