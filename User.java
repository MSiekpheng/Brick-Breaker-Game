public class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public String getUsername() {
        return username;
    }

    public String getUserInfo() {
        return username + ":" + password;
    }
}

class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }
}
