import java.util.Arrays;
import java.util.List;

public class AverageUsingStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        double average = numbers.stream()
                .mapToInt(n -> n) // Convert to int
                .average()        // Compute average
                .orElse(0.0);     // Default to 0 if empty

        System.out.println("Average: " + average);
    }
}
