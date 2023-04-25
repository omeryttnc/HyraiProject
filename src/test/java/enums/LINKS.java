package enums;

public enum LINKS {
    BASEURL("https://hyrai.com/")
    ;
    private String getLink;

    LINKS(String getLink) {
        this.getLink = getLink;
    }

    public String getLink() {
        return getLink;
    }
}
