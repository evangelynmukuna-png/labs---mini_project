package ex3;

class Employee {

    private final String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() { return name; }

    public double calculatePay() {
        return baseSalary;
    }
}

class Manager extends Employee {

    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculatePay() {
        return super.calculatePay() + bonus;
    }
}

class Developer extends Employee {

    private int overtimeHours;
    private static final double OVERTIME_RATE = 25.0;

    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculatePay() {
        return baseSalary + overtimeHours * OVERTIME_RATE;
    }
}

// NEW class added in this exercise. Nothing else in the file had to change.
class Intern extends Employee {

    private double transportAllowance;

    public Intern(String name, double stipend, double transportAllowance) {
        super(name, stipend);
        this.transportAllowance = transportAllowance;
    }

    @Override
    public double calculatePay() {
        return baseSalary + transportAllowance;
    }
}

public class PayrollDemo {

    // This loop knows only about Employee. It is NEVER edited when new types are added.
    static double totalPayroll(Employee[] staff) {
        double total = 0;
        for (Employee e : staff) {
            System.out.printf("%-8s %-10s %8.2f%n", e.getName(), e.getClass().getSimpleName(), e.calculatePay());
            total += e.calculatePay();
        }
        return total;
    }

    public static void main(String[] args) {
        Employee[] staff = {
                new Employee("Evangelyn", 2000),
                new Manager("Tariro", 3500, 800),
                new Developer("Faith", 3000, 10),
                new Intern("Merit", 600, 50)                  // the new type, mixed in freely
        };

        double total = totalPayroll(staff);
        System.out.println("---------------------------------");
        System.out.printf("Total payroll: %.2f%n", total);
    }
}
