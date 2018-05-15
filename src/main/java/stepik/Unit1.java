package stepik;

public class Unit1 {
    public static void main(String[] args) {

     String string = "Madam, I'm Adam!";

    }
    public  boolean isPalindrome(String text) {
        StringBuilder sb = new StringBuilder(text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase());
    return sb.toString().equals(sb.reverse().toString());
    }
}
