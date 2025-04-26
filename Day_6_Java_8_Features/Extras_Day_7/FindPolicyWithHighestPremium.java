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

    @Override
    public String toString() {
        return policyNumber + " | " + holderName + " | " + premiumAmount;
    }
}

public class FindPolicyWithHighestPremium {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("P001", "John Doe", 1500),
            new InsurancePolicy("P002", "Alice Smith", 800),
            new InsurancePolicy("P003", "Bob Brown", 2200),
            new InsurancePolicy("P004", "Charlie Black", 1200)
        );

        InsurancePolicy highestPremiumPolicy = policies.stream()
            .max(Comparator.comparingDouble(InsurancePolicy::getPremiumAmount))
            .orElseThrow(() -> new NoSuchElementException("No policy found"));

        System.out.println("Policy with highest premium: " + highestPremiumPolicy);
    }
}
