import java.util.*;
import java.util.stream.Collectors;

class InsurancePolicy {
    String policyNumber;
    String holderName;
    double premiumAmount;

    public InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String getHolderName() {
        return holderName;
    }

    @Override
    public String toString() {
        return policyNumber + " | " + holderName + " | " + premiumAmount;
    }
}

public class GroupPoliciesByInitial {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("P001", "John Doe", 1500),
            new InsurancePolicy("P002", "Alice Smith", 800),
            new InsurancePolicy("P003", "Bob Brown", 2200),
            new InsurancePolicy("P004", "Charlie Black", 1200)
        );

        Map<Character, List<InsurancePolicy>> groupedByInitial = policies.stream()
            .collect(Collectors.groupingBy(p -> p.getHolderName().charAt(0)));

        groupedByInitial.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
}
