import java.util.*;

class Employee {
    String name;
    String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupByProperty {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> groupedEmployees = groupByDepartment(employees);
        groupedEmployees.forEach((department, empList) ->
            System.out.println(department + ": " + empList));
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();
        for (Employee employee : employees) {
            grouped.putIfAbsent(employee.getDepartment(), new ArrayList<>());
            grouped.get(employee.getDepartment()).add(employee);
        }
        return grouped;
    }
}
