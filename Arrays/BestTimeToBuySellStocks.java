package Arrays;

/*
 * LeetCode Problem #121: Best Time to Buy and Sell Stock
 * This file includes a main method for easy testing.
 */
public class BestTimeToBuySellStocks { // Make sure this class name matches your file name

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    // This is the main method to test your code
    public static void main(String[] args) {
        // 1. Create an instance of the class
        BestTimeToBuySellStocks solution = new BestTimeToBuySellStocks();
        
        // 2. Create some sample data
        int[] stockPrices = {7, 1, 5, 3, 6, 4};

        // 3. Call the maxProfit method with the sample data
        int profit = solution.maxProfit(stockPrices);

        // 4. Print the result to the console
        System.out.println("The maximum profit is: " + profit); // Should print 5
    }

    // This is the main method to test your code
}
