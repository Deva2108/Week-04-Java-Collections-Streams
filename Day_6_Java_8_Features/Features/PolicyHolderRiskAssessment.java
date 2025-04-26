import java.util.*;
import java.util.stream.Collectors;

class PolicyHolder {
    int holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    public PolicyHolder(int holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }

    public int getAge() {
        return age;
    }

    public String getPolicyType() {
        return policyType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }
}

class RiskAssessment {
    int holderId;
    String name;
    double riskScore;

    public RiskAssessment(int holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }
}

public class PolicyHolderRiskAssessment {
    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
            new PolicyHolder(1, "John", 65, "Life", 5000),
            new PolicyHolder(2, "Alice", 70, "Life", 7000),
            new PolicyHolder(3, "Bob", 40, "Health", 3000)
        );

        List<RiskAssessment> result = holders.stream()
            .filter(p -> p.getPolicyType().equals("Life") && p.getAge() > 60)
            .map(p -> new RiskAssessment(p.holderId, p.name, p.getPremiumAmount() / p.getAge()))
            .sorted((r1, r2) -> Double.compare(r2.riskScore, r1.riskScore))
            .collect(Collectors.toList());

        result.forEach(r -> System.out.println(r.name + ": " + r.riskScore));
    }
}
