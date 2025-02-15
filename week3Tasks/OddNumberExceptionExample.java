public class OddNumberExceptionExample {
    public static void checkEvenNumber(int number) throws Exception {
        if (number % 2 != 0) {
            throw new Exception("Number is odd!");
        }
        System.out.println("Number is even.");
    }

    public static void main(String[] args) {
        try {
            checkEvenNumber(7); // This will throw an exception
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}