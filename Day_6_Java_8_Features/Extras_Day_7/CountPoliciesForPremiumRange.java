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

    public double getPremiumAmount() {
        return premiumAmount;
    }
}

public class CountPoliciesForPremiumRange {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("P001", "John Doe", 1500),
            new InsurancePolicy("P002", "Alice Smith", 800),
            new InsurancePolicy("P003", "Bob Brown", 2200),
            new InsurancePolicy("P004", "Charlie Black", 1200)
        );

        Map<String, Long> premiumRangeCount = policies.stream()
            .collect(Collectors.groupingBy(policy -> {
                if (policy.getPremiumAmount() <= 1000) {
                    return "$0-$1,000";
                } else if (policy.getPremiumAmount() <= 2000) {
                    return "$1,001-$2,000";
                } else {
                    return ">$2,000";
                }
            }, Collectors.counting()));

        premiumRangeCount.forEach((range, count) -> {
            System.out.println(range + ": " + count);
        });
    }
}
