<<<<<<< HEAD
public class User {
=======
// Base class for User
class User {
>>>>>>> adfad5090453b8a3917c349514bb8f3690ffb568
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
<<<<<<< HEAD
    }

    public String getUsername() {
        return username;
=======
>>>>>>> adfad5090453b8a3917c349514bb8f3690ffb568
    }

    public String getUserInfo() {
        return username + ":" + password;
    }
<<<<<<< HEAD
}

class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }
}
=======
}
>>>>>>> adfad5090453b8a3917c349514bb8f3690ffb568
