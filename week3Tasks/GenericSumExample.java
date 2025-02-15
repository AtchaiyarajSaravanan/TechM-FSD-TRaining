import java.util.List;

public class GenericSumExample {
    public static <T extends Number> void sumEvenOdd(List<T> numbers) {
        int evenSum = 0, oddSum = 0;
        for (T number : numbers) {
            int value = number.intValue();
            if (value % 2 == 0) evenSum += value;
            else oddSum += value;
        }
        System.out.println("Even sum: " + evenSum);
        System.out.println("Odd sum: " + oddSum);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        sumEvenOdd(numbers);
    }
}