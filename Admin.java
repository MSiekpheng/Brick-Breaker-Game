public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
        lives = 5;
    }

    @Override
    public void loseLife() {
        super.loseLife();
    }

    public boolean isAlive() {
        return super.isAlive();
    }

    public int resetLives() {
        return lives = 5;
    }

    @Override
    public int getLives() {
        return lives;
    }

    // Overriding method from User class
    @Override
    public void performSpecialAction() {
        System.out.println("Special admin action performed.");
    }
}
