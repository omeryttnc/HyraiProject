package enums;


import org.junit.Assert;

import static stepDefinitions.Hooks.commonPage;

public enum TOAST_MESSAGE {
    EMAIL_1("Email or password is not valid!"),
    EMAIL_2("Wrong Credentials!");
    private String toast;

    TOAST_MESSAGE(String toast) {
        this.toast = toast;
    }


    public static void assertToast(TOAST_MESSAGE toastMessage) {
        Assert.assertTrue(commonPage.getLoginPage().toastMessages
                .stream()
                .anyMatch(t -> t.getText().equals(toastMessage.getToast()))

        );
    }


    public String getToast() {
        return toast;
    }
}
