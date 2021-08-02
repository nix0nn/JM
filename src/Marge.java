public class Marge {
    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder text2 = new StringBuilder(text);
        text2 = text2.reverse();
        return text.equalsIgnoreCase(text2.toString());
    }
}
