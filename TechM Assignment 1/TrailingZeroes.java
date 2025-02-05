public class TrailingZeroes {
    public static void main(String[] args) {
        int number = 25;
        int count = 0;

        while (number > 0) {
            number /= 5;
            count += number;
        }

        System.out.println("Number of trailing zeroes: " + count);
    }
}