import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        Collections.reverse(colors); // Reverse the list
        System.out.println("Reversed list:");
        for (String color : colors) {
            System.out.println(color);
        }
    }
}