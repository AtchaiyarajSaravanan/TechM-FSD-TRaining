public class StringProcessor {
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static int countOccurrences(String text, String sub) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }

    public static String splitAndCapitalize(String str) {
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0)))
                  .append(word.substring(1)).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String text = "hello world";
        System.out.println("Reversed: " + reverseString(text));
        System.out.println("Occurrences of 'l': " + countOccurrences(text, "l"));
        System.out.println("Capitalized: " + splitAndCapitalize(text));
    }
}