import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    int transactionId;
    String policyNumber;
    double amount;
    boolean isFraudulent;

    public Transaction(int transactionId, String policyNumber, double amount, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.isFraudulent = isFraudulent;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }
}

public class FraudDetection {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction(1, "P001", 12000, true),
            new Transaction(2, "P002", 3000, false),
            new Transaction(3, "P001", 15000, true),
            new Transaction(4, "P003", 25000, true)
        );

        Map<String, Double> result = transactions.stream()
            .filter(t -> t.isFraudulent() && t.getAmount() > 10000)
            .collect(Collectors.groupingBy(Transaction::getPolicyNumber, Collectors.summingDouble(Transaction::getAmount)));

        result.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
