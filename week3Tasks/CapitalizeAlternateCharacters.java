public class CapitalizeAlternateCharacters {
    public static void main(String[] args) {
        String input = "anurag";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(ch)); // Capitalize alternate characters
            } else {
                result.append(ch);
            }
        }

        System.out.println("Original String: " + input);
        System.out.println("Modified String: " + result.toString());
    }
}