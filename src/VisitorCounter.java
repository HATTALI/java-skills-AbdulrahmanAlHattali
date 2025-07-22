public class VisitorCounter {
    // Static variable to count total visitors
    private static int totalVisitors = 0;

    // Non-static variables
    private int sessionVisits;
    private String visitorName;

    // Constructor
    public VisitorCounter(String name) {
        this.visitorName = name;
        this.sessionVisits = 0;
        totalVisitors++;
    }

    // Non-static method to record a visit
    public void recordVisit() {
        sessionVisits++;
        System.out.println(visitorName + " visited. Session visits: " + sessionVisits);
    }

    // Static method to display total
    public static void displayTotalVisitors() {
        System.out.println("Total visitors today: " + totalVisitors);
    }

    // Static method to get total
    public static int getTotalVisitors() {
        return totalVisitors;
    }

    // Main method to test
    public static void main(String[] args) {
        VisitorCounter v1 = new VisitorCounter("Alice");
        VisitorCounter v2 = new VisitorCounter("Bob");
        VisitorCounter v3 = new VisitorCounter("Charlie");

        // Record visits
        v1.recordVisit();
        v1.recordVisit();
        v2.recordVisit();
        v3.recordVisit();
        v3.recordVisit();
        v3.recordVisit();

        displayTotalVisitors();
    }
}
