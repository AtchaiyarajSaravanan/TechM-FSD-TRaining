import java.util.List;

public class GenericFindIndexExample {
    public static <T> int findIndex(List<T> list, T target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "cherry");
        System.out.println("Index of 'banana': " + findIndex(list, "banana"));
    }
}