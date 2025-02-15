public class CopyAlternateElements {
    public static void main(String[] args) {
        int[] originalArray = {10, 20, 30, 40, 50, 60, 70};
        int[] newArray = new int[(originalArray.length + 1) / 2]; // Size for alternate elements

        int index = 0;
        for (int i = 0; i < originalArray.length; i += 2) {
            newArray[index] = originalArray[i];
            index++;
        }

        System.out.println("Original Array: ");
        for (int num : originalArray) {
            System.out.print(num + " ");
        }

        System.out.println("\nNew Array with Alternate Elements: ");
        for (int num : newArray) {
            System.out.print(num + " ");
        }
    }
}