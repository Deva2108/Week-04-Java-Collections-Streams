import java.util.*;

abstract class JobRole {
    String role;
    JobRole(String role) { this.role = role; }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() { super("Software Engineer"); }
}

class DataScientist extends JobRole {
    DataScientist() { super("Data Scientist"); }
}

class ProductManager extends JobRole {
    ProductManager() { super("Product Manager"); }
}

class Resume<T extends JobRole> {
    String name;
    T role;
    Resume(String name, T role) {
        this.name = name;
        this.role = role;
    }
    static void showRoles(List<? extends JobRole> roles) {
        for (JobRole role : roles) System.out.println(role.role);
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(new SoftwareEngineer());
        jobRoles.add(new DataScientist());
        jobRoles.add(new ProductManager());

        Resume.showRoles(jobRoles);
    }
}
