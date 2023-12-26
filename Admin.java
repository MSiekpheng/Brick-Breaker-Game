class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
        lives = 10;
    }

    @Override
    public void loseLife() {
        super.loseLife();
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }

    @Override
    public void resetLives() {
        lives = 10;
    }

    @Override
    public int getLives() {
        return super.getLives();
    }
}
