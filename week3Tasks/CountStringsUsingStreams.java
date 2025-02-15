import java.util.Arrays;
import java.util.List;

public class CountStringsUsingStreams {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry", "avocado");

        char specificLetter = 'a'; // Change this as needed

        long count = words.stream()
                .filter(word -> word.startsWith(String.valueOf(specificLetter)))
                .count();

        System.out.println("Count of words starting with '" + specificLetter + "': " + count);
    }
}
