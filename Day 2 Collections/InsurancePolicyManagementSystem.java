import java.util.*;
import java.util.stream.Collectors;

public class InsurancePolicyManagementSystem {

    static class Policy {
        private String policyNumber;
        private String policyholderName;
        private Date expiryDate;
        private String coverageType;
        private double premiumAmount;

        public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        public String getPolicyNumber() {
            return policyNumber;
        }

        public String getPolicyholderName() {
            return policyholderName;
        }

        public Date getExpiryDate() {
            return expiryDate;
        }

        public String getCoverageType() {
            return coverageType;
        }

        public double getPremiumAmount() {
            return premiumAmount;
        }

        @Override
        public String toString() {
            return "PolicyNumber: " + policyNumber + ", Holder: " + policyholderName + ", Expiry Date: " + expiryDate + ", Coverage: " + coverageType + ", Premium: " + premiumAmount;
        }
    }

    private Map<String, Policy> policyMap;
    private Map<String, Policy> orderedPolicyMap;
    private Map<String, Policy> sortedPolicyMap;

    public InsurancePolicyManagementSystem() {
        this.policyMap = new HashMap<>();
        this.orderedPolicyMap = new LinkedHashMap<>();
        this.sortedPolicyMap = new TreeMap<>(Comparator.comparing(policyNumber -> getPolicyByNumber(policyNumber).getExpiryDate()));
    }

    // Add policy to all maps
    public void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedPolicyMap.put(policy.getPolicyNumber(), policy);
    }

    // Retrieve policy by its number
    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List policies expiring within the next 30 days
    public List<Policy> listPoliciesExpiringSoon() {
        Date currentDate = new Date();
        long thirtyDaysFromNow = currentDate.getTime() + (30L * 24 * 60 * 60 * 1000);  // 30 days in milliseconds
        Date thresholdDate = new Date(thirtyDaysFromNow);

        return policyMap.values().stream()
                .filter(policy -> policy.getExpiryDate().before(thresholdDate))
                .collect(Collectors.toList());
    }

    // List policies for a specific policyholder
    public List<Policy> listPoliciesByPolicyholder(String policyholderName) {
        return policyMap.values().stream()
                .filter(policy -> policy.getPolicyholderName().equalsIgnoreCase(policyholderName))
                .collect(Collectors.toList());
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        Date currentDate = new Date();
        policyMap.entrySet().removeIf(entry -> entry.getValue().getExpiryDate().before(currentDate));
    }

    public void displayPolicies(Map<String, Policy> map) {
        for (Policy policy : map.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        // Sample data
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        Date expiryDate1 = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 20);
        Date expiryDate2 = calendar.getTime();

        Policy policy1 = new Policy("P123", "John Doe", expiryDate1, "Health", 500.0);
        Policy policy2 = new Policy("P124", "Jane Doe", expiryDate2, "Auto", 300.0);
        Policy policy3 = new Policy("P125", "John Doe", expiryDate1, "Home", 700.0);

        system.addPolicy(policy1);
        system.addPolicy(policy2);
        system.addPolicy(policy3);

        // Test methods
        System.out.println("All Policies:");
        system.displayPolicies(system.policyMap);

        System.out.println("\nPolicies Expiring Soon:");
        system.listPoliciesExpiringSoon().forEach(System.out::println);

        System.out.println("\nPolicies of John Doe:");
        system.listPoliciesByPolicyholder("John Doe").forEach(System.out::println);

        system.removeExpiredPolicies();
        System.out.println("\nPolicies after removing expired ones:");
        system.displayPolicies(system.policyMap);
    }
}
