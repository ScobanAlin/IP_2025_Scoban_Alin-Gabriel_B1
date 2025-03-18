public abstract class User {                           /// /MADE BY HUMAN
    private String name;
    private String username;
    private String password;

    public User(String name, String username) {
        this.name = name;
        this.username = username;
        this.password = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
