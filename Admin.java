class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
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
        this.lives = 10; // Calling the resetLives method of the superclass (User)
    }

    @Override
    public int getLives() {
        this.lives = 10;
        return lives;
    }
}
