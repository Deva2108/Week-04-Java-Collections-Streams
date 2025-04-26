import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeDataProcessing {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "John", "Engineering", 95000),
            new Employee(2, "Alice", "HR", 70000),
            new Employee(3, "Bob", "Engineering", 120000),
            new Employee(4, "Charlie", "Engineering", 85000)
        );

        Map<String, Double> result = employees.stream()
            .filter(e -> e.getDepartment().equals("Engineering") && e.getSalary() > 80000)
            .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(result);
    }
}
