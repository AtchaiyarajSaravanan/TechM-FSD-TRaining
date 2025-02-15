import java.util.Scanner;
import java.util.Arrays;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        String[] names = new String[n];
        int[] totals = new int[n];
        double[] averages = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student " + (i + 1) + " name: ");
            names[i] = scanner.next();
            System.out.print("Enter marks for 3 subjects: ");
            int marks1 = scanner.nextInt();
            int marks2 = scanner.nextInt();
            int marks3 = scanner.nextInt();
            totals[i] = marks1 + marks2 + marks3;
            averages[i] = totals[i] / 3.0;
        }

        // Sort students based on totals
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (totals[i] < totals[j]) {
                    // Swap totals
                    int tempTotal = totals[i];
                    totals[i] = totals[j];
                    totals[j] = tempTotal;

                    // Swap names
                    String tempName = names[i];
                    names[i] = names[j];
                    names[j] = tempName;

                    // Swap averages
                    double tempAvg = averages[i];
                    averages[i] = averages[j];
                    averages[j] = tempAvg;
                }
            }
        }

        System.out.println("\nStudent Details (Sorted by Total Marks):");
        for (int i = 0; i < n; i++) {
            System.out.println("Name: " + names[i] + ", Total: " + totals[i] + ", Average: " + averages[i]);
        }
    }
}