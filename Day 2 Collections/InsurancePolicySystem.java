import java.time.LocalDate;
import java.util.*;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InsurancePolicy)) return false;
        InsurancePolicy that = (InsurancePolicy) o;
        return policyNumber.equals(that.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(InsurancePolicy o) {
        return this.expiryDate.compareTo(o.expiryDate);
    }

    @Override
    public String toString() {
        return policyNumber + " | " + policyholderName + " | " + expiryDate + " | " + coverageType + " | " + premiumAmount;
    }
}

public class InsurancePolicySystem {
    public static void main(String[] args) {
        HashSet<InsurancePolicy> hashSet = new HashSet<>();
        LinkedHashSet<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
        TreeSet<InsurancePolicy> treeSet = new TreeSet<>();

        InsurancePolicy p1 = new InsurancePolicy("P001", "Alice", LocalDate.now().plusDays(15), "Health", 2500);
        InsurancePolicy p2 = new InsurancePolicy("P002", "Bob", LocalDate.now().plusDays(5), "Auto", 1800);
        InsurancePolicy p3 = new InsurancePolicy("P003", "Charlie", LocalDate.now().plusDays(35), "Home", 2200);
        InsurancePolicy p4 = new InsurancePolicy("P001", "Alice", LocalDate.now().plusDays(15), "Health", 2500); // duplicate

        List<InsurancePolicy> policyList = Arrays.asList(p1, p2, p3, p4);

        for (InsurancePolicy p : policyList) {
            hashSet.add(p);
            linkedHashSet.add(p);
            treeSet.add(p);
        }

        System.out.println("== Unique Policies (HashSet) ==");
        for (InsurancePolicy p : hashSet) {
            System.out.println(p);
        }

        System.out.println("\n== Policies in Insertion Order (LinkedHashSet) ==");
        for (InsurancePolicy p : linkedHashSet) {
            System.out.println(p);
        }

        System.out.println("\n== Policies Sorted by Expiry Date (TreeSet) ==");
        for (InsurancePolicy p : treeSet) {
            System.out.println(p);
        }

        System.out.println("\n== Policies Expiring Soon (within 30 days) ==");
        LocalDate today = LocalDate.now();
        for (InsurancePolicy p : treeSet) {
            if (!p.getExpiryDate().isAfter(today.plusDays(30))) {
                System.out.println(p);
            }
        }

        System.out.println("\n== Policies by Coverage Type: 'Health' ==");
        for (InsurancePolicy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase("Health")) {
                System.out.println(p);
            }
        }

        System.out.println("\n== Duplicate Policies (by Policy Number) ==");
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (InsurancePolicy p : policyList) {
            if (!seen.add(p.getPolicyNumber())) {
                duplicates.add(p.getPolicyNumber());
            }
        }
        for (InsurancePolicy p : policyList) {
            if (duplicates.contains(p.getPolicyNumber())) {
                System.out.println(p);
            }
        }

        System.out.println("\n== Performance Comparison ==");
        comparePerformance("HashSet", new HashSet<>());
        comparePerformance("LinkedHashSet", new LinkedHashSet<>());
        comparePerformance("TreeSet", new TreeSet<>());
    }

    private static void comparePerformance(String name, Set<InsurancePolicy> set) {
        int N = 100000;
        List<InsurancePolicy> sample = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            sample.add(new InsurancePolicy("P" + i, "Holder" + i, LocalDate.now().plusDays(i % 365), "Auto", 1000 + i));
        }

        long start = System.currentTimeMillis();
        for (InsurancePolicy p : sample) set.add(p);
        long addTime = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (InsurancePolicy p : sample) set.contains(p);
        long searchTime = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (InsurancePolicy p : sample) set.remove(p);
        long removeTime = System.currentTimeMillis() - start;

        System.out.println(name + " -> Add: " + addTime + "ms, Search: " + searchTime + "ms, Remove: " + removeTime + "ms");
    }
}
