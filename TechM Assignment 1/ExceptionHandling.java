import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        processInput();
    }

    public static void processInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");

        try {
            double number = Double.parseDouble(scanner.nextLine());
            if (number == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            double reciprocal = 1 / number;
            System.out.println("Reciprocal: " + reciprocal);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}