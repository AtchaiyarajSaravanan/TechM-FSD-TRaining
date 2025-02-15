import java.util.LinkedList;

public class AppendLinkedList {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");

        colors.addLast("Blue"); // Append to the end
        System.out.println("Updated list: " + colors);
    }
}