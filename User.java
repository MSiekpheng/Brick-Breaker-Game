// Base class for User
class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public String getUserInfo() {
        return username + ":" + password;
    }

    public void actionPerform(){
        System.out.println("Hello");
    }
}