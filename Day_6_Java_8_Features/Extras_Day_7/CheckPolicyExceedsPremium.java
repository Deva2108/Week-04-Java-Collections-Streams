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

    public double getPremiumAmount() {
        return premiumAmount;
    }
}

public class CheckPolicyExceedsPremium {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("P001", "John Doe", 1500),
            new InsurancePolicy("P002", "Alice Smith", 800),
            new InsurancePolicy("P003", "Bob Brown", 2200),
            new InsurancePolicy("P004", "Charlie Black", 1200)
        );

        boolean anyPolicyExceeds = policies.stream()
            .anyMatch(p -> p.getPremiumAmount() > 2000);

        System.out.println("Any policy exceeds $2000: " + anyPolicyExceeds);
    }
}
