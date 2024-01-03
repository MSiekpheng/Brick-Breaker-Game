import javax.swing.JOptionPane;

// Admin class inherits from User
public class Admin extends User {
    // Constructor
    public Admin(String username, String password) {
        super(username, password);
        lives = 5; // Admin has more lives
    }

    
    public void loseLife() {
        super.loseLife();
    }

    public boolean isAlive() {
        return super.isAlive();
    }

    // Overridden method to reset lives
    @Override
    public int resetLives() {
        return lives = 5; // Reset lives to higher value for admin
    }

    // Overridden method to perform special action
    @Override
    public int getLives() {
        return lives;
    }

    // Overridden method to perform special action for admin
    @Override
    public  void performSpecialAction() {
        JOptionPane.showMessageDialog(null, "Admin have login!! " + getUserInfo(true));
    }
}
