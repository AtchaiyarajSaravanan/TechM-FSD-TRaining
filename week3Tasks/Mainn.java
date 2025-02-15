import java.util.Scanner;

class Employee {
    // Data members
    private int empId;
    private String empName;
    private double sal;
    private int yearsWorked;

    // Method to set employee details
    public void setEmployeeDetails(int empId, String empName, double sal, int yearsWorked) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
        this.yearsWorked = yearsWorked;
    }

    // Method to get employee details
    public void getEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee Salary: " + sal);
        System.out.println("Years Worked: " + yearsWorked);
    }

    // Method to check loan eligibility
    public void getLoanEligibility() {
        if (yearsWorked > 5) {
            double annualSalary = sal * 12; // Calculate annual salary
            System.out.println("Annual Salary: " + annualSalary);

            if (annualSalary >= 1500000) {
                System.out.println("Loan Granted: 7 lakhs");
            } else if (annualSalary >= 1000000) {
                System.out.println("Loan Granted: 5 lakhs");
            } else if (annualSalary >= 600000) {
                System.out.println("Loan Granted: 2 lakhs");
            } else {
                System.out.println("Loan Not Granted: Salary is less than 6 lakhs");
            }
        } else {
            System.out.println("Loan Not Granted: Employee has worked for less than 5 years");
        }
    }
}

public class Mainn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an Employee object
        Employee emp = new Employee();

        // Input employee details
        System.out.print("Enter Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Employee Name: ");
        String empName = scanner.nextLine();
        System.out.print("Enter Monthly Salary: ");
        double sal = scanner.nextDouble();
        System.out.print("Enter Years Worked: ");
        int yearsWorked = scanner.nextInt();

        // Set employee details
        emp.setEmployeeDetails(empId, empName, sal, yearsWorked);

        // Display employee details
        System.out.println("\nEmployee Details:");
        emp.getEmployeeDetails();

        // Check loan eligibility
        System.out.println("\nLoan Eligibility:");
        emp.getLoanEligibility();
    }
}