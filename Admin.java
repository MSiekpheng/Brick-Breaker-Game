class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    // Method overriding: Overriding the getUserInfo() method in the User class
    @Override
    public String getUserInfo() {
        return "Admin: " + super.getUserInfo();
    }

    // Method overloading: Overloading the authenticate() method
    public boolean authenticate() {
        // Custom authentication logic for Admin
        return true; // Example: Admin always authenticates successfully
    }
}