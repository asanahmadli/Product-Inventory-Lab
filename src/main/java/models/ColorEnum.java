package models;

public enum ColorEnum {
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    BLUE("\u001B[34m"),
    YELLOW("\u001B[33m"),
    CYAN("\u001B[36m"),
    MAGENTA("\u001B[35m"),
    WHITE("\u001B[37m"),
    BLACK("\u001B[30m");

    private final String code;

    ColorEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public   String formatString(String text) {
        return code + text + "\u001B[0m"; // Reset color to default after the text
    }


}
