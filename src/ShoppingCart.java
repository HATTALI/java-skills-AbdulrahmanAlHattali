public class ShoppingCart {
    // Calculate total price with discounts
    public static double calculateTotal(double[] prices, String customerType) {
        double total = 0;
        for (double price : prices) {
            total += price;
        }

        switch (customerType) {
            case "PREMIUM":
                total *= 0.9;  // 10% discount
                break;
            case "VIP":
                total *= 0.8;  // 20% discount
                break;
            case "REGULAR":
                // no discount
                break;
            default:
                System.out.println("Unknown customer type. No discount applied.");
        }

        return total;
    }

    // Find most expensive item
    public static double findMostExpensive(double[] prices) {
        if (prices.length == 0) return 0;

        double max = prices[0];
        for (double price : prices) {
            if (price > max) {
                max = price;
            }
        }
        return max;
    }

    // Count items above a certain price
    public static int countExpensiveItems(double[] prices, double threshold) {
        int count = 0;
        for (double price : prices) {
            if (price > threshold) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        double[] cart = {25.99, 45.50, 12.99, 89.99, 15.75};

        System.out.println("Regular customer total: $" + calculateTotal(cart, "REGULAR"));
        System.out.println("Premium customer total: $" + calculateTotal(cart, "PREMIUM"));
        System.out.println("VIP customer total: $" + calculateTotal(cart, "VIP"));

        System.out.println("Most expensive item: $" + findMostExpensive(cart));
        System.out.println("Items over $30: " + countExpensiveItems(cart, 30));
    }
}
