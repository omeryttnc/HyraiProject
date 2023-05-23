package pojos;

public class PLogin {
    private String email;
    private String password;
    private String state;

    public PLogin() {
    }

    public PLogin(String email, String password, String state) {
        this.email = email;
        this.password = password;
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "PLogin{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setState(String state) {
        this.state = state;
    }
}
