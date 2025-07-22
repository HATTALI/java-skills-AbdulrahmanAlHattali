public class PayrollCalculator {

    /**
     * Calculate weekly pay for different employee types:
     * FULL_TIME, PART_TIME, CONTRACTOR, INTERN
     */
    public static double calculateWeeklyPay(
            String employeeType,
            double hoursWorked,
            double hourlyRate) {

        if (hoursWorked < 0 || hourlyRate < 0) {
            throw new IllegalArgumentException("Hours and rate must be ≥ 0");
        }

        switch (employeeType) {
            case "FULL_TIME":
                double base = Math.min(40, hoursWorked) * hourlyRate;
                double ot   = Math.max(0, hoursWorked - 40) * hourlyRate * 1.5;
                return base + ot;

            case "PART_TIME":
                return Math.min(25, hoursWorked) * hourlyRate;

            case "CONTRACTOR":
                return hoursWorked * hourlyRate;

            case "INTERN":
                return Math.min(20, hoursWorked) * (hourlyRate * 0.8);

            default:
                throw new IllegalArgumentException("Unknown type: " + employeeType);
        }
    }

    /**
     * Calculate tax deduction based on brackets and optional health insurance discount.
     */
    public static double calculateTaxDeduction(
            double grossPay,
            boolean hasHealthInsurance) {

        double rate;
        if      (grossPay <= 500)   rate = 0.10;
        else if (grossPay <= 1000)  rate = 0.15;
        else if (grossPay <= 2000)  rate = 0.20;
        else                         rate = 0.25;

        double tax = grossPay * rate;
        if (hasHealthInsurance) {
            tax = Math.max(0, tax - 50);
        }
        return tax;
    }

    /**
     * Process payroll for arrays of employees, printing per‐employee and summary stats.
     */
    public static void processPayroll(
            String[] employeeTypes,
            double[] hours,
            double[] rates,
            String[] names) {

        int n = Math.min(Math.min(employeeTypes.length, hours.length),
                Math.min(rates.length, names.length));

        double totalPay = 0;
        double maxPay   = Double.MIN_VALUE, minPay = Double.MAX_VALUE;
        String maxName = "", minName = "";
        int overtimeCount = 0;

        System.out.printf("%-8s %10s %10s%n", "Name", "Pay", "Tax");
        for (int i = 0; i < n; i++) {
            double pay = calculateWeeklyPay(employeeTypes[i], hours[i], rates[i]);
            double tax = calculateTaxDeduction(pay, true);

            totalPay += pay;
            if (pay > maxPay) { maxPay = pay; maxName = names[i]; }
            if (pay < minPay) { minPay = pay; minName = names[i]; }
            if (hours[i] > 40) overtimeCount++;

            System.out.printf("%-8s %10.2f %10.2f%n", names[i], pay, tax);
        }

        double averagePay = totalPay / n;
        System.out.println();
        System.out.printf("Highest paid : %s ($%.2f)%n", maxName, maxPay);
        System.out.printf("Lowest paid  : %s ($%.2f)%n", minName, minPay);
        System.out.printf("Average pay  : $%.2f%n", averagePay);
        System.out.println("Overtime    : " + overtimeCount + " employees");
    }

    public static void main(String[] args) {
        String[] types = {"FULL_TIME", "PART_TIME", "CONTRACTOR", "INTERN", "FULL_TIME"};
        double[] hours  = {45, 20, 35, 15, 50};
        double[] rates  = {25.0, 18.0, 40.0, 12.0, 30.0};
        String[] names  = {"Alice", "Bob", "Charlie", "Diana", "Eve"};

        // Test individual case
        System.out.println("Alice FT pay: $" +
                calculateWeeklyPay("FULL_TIME", 45, 25.0));

        System.out.println("\n--- Full Payroll Report ---");
        processPayroll(types, hours, rates, names);
    }
}
