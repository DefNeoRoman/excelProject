package stepik;

public class Unit1 {
    private String name;
    public static void main(String[] args) {
    // различия между Immutable изменяемыми и неизменяемыми
     final String string = "Madam, I'm Adam!";

    }
    public  boolean isPalindrome(String text) {
        StringBuilder sb = new StringBuilder(text.replaceAll("[^a-zA-Z0-9]", ""));

    return sb.toString().equalsIgnoreCase(sb.reverse().toString());
    }

}
