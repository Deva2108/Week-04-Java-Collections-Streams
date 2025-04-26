import java.util.*;
import java.util.stream.Collectors;

class Claim {
    int claimId;
    String policyNumber;
    double claimAmount;
    String status;

    public Claim(int claimId, String policyNumber, double claimAmount, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.status = status;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getStatus() {
        return status;
    }
}

public class ClaimsAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim(1, "P001", 6000, "Approved"),
            new Claim(2, "P002", 3000, "Denied"),
            new Claim(3, "P001", 7000, "Approved"),
            new Claim(4, "P003", 10000, "Approved")
        );

        Map<String, Double> result = claims.stream()
            .filter(c -> c.getStatus().equals("Approved") && c.getClaimAmount() > 5000)
            .collect(Collectors.groupingBy(Claim::getPolicyNumber, Collectors.summingDouble(Claim::getClaimAmount)));

        result.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
