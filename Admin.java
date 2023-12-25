class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
        lives = 10;
    }

    @Override
    public void loseLife() {
        // You can add any special behavior specific to Admin if needed
        super.loseLife(); // Calling the loseLife method of the superclass (User)
    }

    @Override
    public boolean isAlive() {
        // You can add any special behavior specific to Admin if needed
        return super.isAlive(); // Calling the isAlive method of the superclass (User)
    }

    @Override
    public void resetLives() {
        // You can add any special behavior specific to Admin if needed
        lives = 10; // Calling the resetLives method of the superclass (User)
    }

    @Override
    public int getLives() {
        return super.getLives();
    }
}
