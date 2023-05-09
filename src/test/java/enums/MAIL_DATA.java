package enums;

public enum MAIL_DATA {
    V1("omeryttnc@gmail.c", "❗ Invalid e-mail", false),
    V2("omeryttnc@.com", "❗ Invalid e-mail", false),
    V3("@gmail.com", "❗ Invalid e-mail", false),
    V4("omergmail.com", "❗ Invalid e-mail", false),
    ;

    MAIL_DATA(String email, String message, boolean isPass) {
        this.email = email;
        this.message = message;
        this.isPass = isPass;
    }

    private String email, message;
    private boolean isPass;

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsPass() {
        return isPass;
    }
}
