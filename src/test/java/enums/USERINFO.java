package enums;

public enum USERINFO {
    OMER("omer","1234")
    ;
    private String token,addresId,email,password, username,address,productID;

    USERINFO(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public String getToken() {
        // backend den token cagirma
        return token;
    }

    public String getAddresId() {
        return addresId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getProductID() {
        return productID;
    }
}