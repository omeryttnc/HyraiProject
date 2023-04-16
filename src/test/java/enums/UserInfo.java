package enums;

public enum UserInfo {
    COMPANY("demo_corp@hyrai.com", "123123"),
    CUSTOMER("demokesif1@gmail.com", "123132");
    private String email, password;

    UserInfo(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
