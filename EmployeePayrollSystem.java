import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    private List<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of Employees: ");
        int n = sc.nextInt();
        sc.nextLine();  // Consume the leftover newline character

        int EmpID = 101;

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter the details of the Employee no  : "+i);
            System.out.print("Name: ");
            String Ename = sc.nextLine();
            // System.out.print("ID: ");
            // int id = sc.nextInt();
            // sc.nextLine();  // Consume the leftover newline character
            System.out.print("Type (Full time/Part time): ");
            String type = sc.nextLine();

            if (type.equalsIgnoreCase("Full time")) {
                System.out.print("Salary: ");
                double sal = sc.nextDouble();
                sc.nextLine();
                FullTimeEmployee emp = new FullTimeEmployee(Ename, EmpID, sal);
                payrollSystem.addEmployee(emp);
                EmpID++;
            } else {
                System.out.print("Enter hours worked: ");
                int Hours = sc.nextInt();
                System.out.print("Enter hourly rate: ");
                float Rate = sc.nextFloat();
                sc.nextLine();  // Consume the leftover newline character
                PartTimeEmployee emp = new PartTimeEmployee(Ename, EmpID, Hours, Rate);
                payrollSystem.addEmployee(emp);
                EmpID++;
            }
        }

        System.out.println("\nInitial Employee Details:");
        payrollSystem.displayEmployees();

        // System.out.println("\nRemoving Employee...");
        // // payrollSystem.removeEmployee(101);  // Try removing a valid ID here


        for(int i=1;i<=2; i++){
            System.out.println();
            System.out.println("\n MENU");
            System.out.println();
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee \n");
            int Operation = sc.nextInt();

            if(Operation == 2 ) {
                System.out.println("Enter the ID of employee which to be Deleted... ");
                int DeletingEmployee = sc.nextInt();
                payrollSystem.removeEmployee(DeletingEmployee);  // Try removing a valid ID here
            }
            else if (Operation == 1) {
                System.out.print("Enter the number of Employees: ");
                int addingEmp = sc.nextInt();
                sc.nextLine();  // Consume the leftover newline character

                for (int j = 1; j <= addingEmp; j++) {
                    System.out.println("Enter the details of the Employee no  : "+j);
                    System.out.print("Name: ");
                    String Ename = sc.nextLine();
                    // System.out.print("ID: ");
                    // int id = sc.nextInt();
                    // sc.nextLine();  // Consume the leftover newline character
                    System.out.print("Type (Full time/Part time): ");
                    String type = sc.nextLine();

                    if (type.equalsIgnoreCase("Full time")) {
                        System.out.print("Salary: ");
                        double sal = sc.nextDouble();
                        sc.nextLine();
                        FullTimeEmployee emp = new FullTimeEmployee(Ename, EmpID, sal);
                        payrollSystem.addEmployee(emp);
                        EmpID++;
                    } else {
                        System.out.print("Enter hours worked: ");
                        int Hours = sc.nextInt();
                        System.out.print("Enter hourly rate: ");
                        float Rate = sc.nextFloat();
                        sc.nextLine();  // Consume the leftover newline character
                        PartTimeEmployee emp = new PartTimeEmployee(Ename, EmpID, Hours, Rate);
                        payrollSystem.addEmployee(emp);
                        EmpID++;
                    }
                }
            }
            else{
                System.out.println("Enter A valid Operation ID ");
            }
        }

        
        System.out.println("\nRemaining Employee Details:");
        payrollSystem.displayEmployees();

        sc.close();
    }
}
