public class PrimitiveReferenceDemo {
    public static void main(String[] args) {
        int number = 10;
        int[] array = {1, 2, 3};

        modifyValues(number, array);

        System.out.println("Primitive Value: " + number); // Passed by value
        System.out.print("Array Values: ");
        for (int value : array) {
            System.out.print(value + " "); // Passed by reference
        }
    }

    public static void modifyValues(int num, int[] arr) {
        num = 20;
        arr[0] = 100;
    }
}