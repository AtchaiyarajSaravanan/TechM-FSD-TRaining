public class DivisionWithoutOperators {
    public static void main(String[] args) {
        int dividend = 20;
        int divisor = 4;
        int quotient = 0;
        int remainder = dividend;

        while (remainder >= divisor) {
            remainder -= divisor;
            quotient++;
        }

        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
    }
}