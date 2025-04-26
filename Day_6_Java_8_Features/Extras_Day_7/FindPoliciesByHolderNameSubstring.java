import java.util.*;

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
}

public class FindPoliciesByHolderNameSubstring {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("P001", "John Doe", 1500),
            new InsurancePolicy("P002", "Alice Smith", 800),
            new InsurancePolicy("P003", "John Brown", 2200),
            new InsurancePolicy("P004", "Charlie Black", 1200)
        );

        String substring = "John";

        policies.stream()
            .filter(policy -> policy.getHolderName().contains(substring))
            .forEach(policy -> System.out.println(policy));
    }
}
