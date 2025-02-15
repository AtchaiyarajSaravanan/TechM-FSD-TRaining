public class PrimeSumThreadExample {
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int limit = 20;
        int[] sum = {0};

        Thread thread = new Thread(() -> {
            for (int i = 2; i <= limit; i++) {
                if (isPrime(i)) {
                    sum[0] += i;
                }
            }
            System.out.println("Sum of prime numbers up to " + limit + ": " + sum[0]);
        });

        thread.start();
    }
}