public class GenericArrayCheckExample {
    public static <T> boolean areArraysEqual(T[] array1, T[] array2) {
        if (array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {1, 2, 3};
        System.out.println("Arrays are equal: " + areArraysEqual(array1, array2));
    }
}