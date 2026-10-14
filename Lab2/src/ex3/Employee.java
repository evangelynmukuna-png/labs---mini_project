package ex3;

public class Employee {

    private static int nextId = 1000;

    private final int employeeId;
    private String name;
    private String department;
    private double salary;

    // Constructor 1: full initialisation
    public Employee(String name, String department, double salary) {
        this.employeeId = nextId++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Constructor 2: salary defaults to 0.0
    public Employee(String name, String department) {
        this(name, department, 0.0);
    }

    // Constructor 3: no argument
    public Employee() {
        this("Unknown", "Unassigned");
    }

    // Copy Constructor: same details, NEW employeeId
    public Employee(Employee other) {
        this(other.name, other.department, other.salary);
    }

    public void display() {
        System.out.printf("ID %d | %-10s | %-10s | $%.2f%n", employeeId, name, department, salary);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Tariro", "IT", 1500);
        Employee e2 = new Employee("Kyla", "Finance");
        Employee e3 = new Employee();
        Employee e4 = new Employee(e1);

        e1.display();
        e2.display();
        e3.display();
        e4.display();
    }
}
