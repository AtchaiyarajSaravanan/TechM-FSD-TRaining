import java.util.Arrays;
import java.util.List;

public class MinMaxUsingStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 6, 3);

        int max = numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("List is empty"));

        int min = numbers.stream()
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("List is empty"));

        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }
}
