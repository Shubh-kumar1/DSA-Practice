package Arrays;

/*
 * LeetCode Problem #198: House Robber
 * Link: https://leetcode.com/problems/house-robber/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int robCurrent = 0;    // Represents max money if we rob the current house
        int skipCurrent = 0;   // Represents max money if we skip the current house

        for (int money : nums) {
            // Store the previous value of robCurrent before we update it
            int temp = robCurrent;
            
            // If we rob the current house, we must have skipped the previous one.
            robCurrent = skipCurrent + money;
            
            // If we skip the current house, we can take the max of either robbing
            // or skipping the previous one.
            skipCurrent = Math.max(temp, skipCurrent);
        }

        // The final answer is the max of robbing or skipping the last house.
        return Math.max(robCurrent, skipCurrent);
    }

    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();
        
        int[] houses1 = {1, 2, 3, 1};
        System.out.println("Max money to rob: " + solution.rob(houses1)); // Expected: 4
        
        int[] houses2 = {2, 7, 9, 3, 1};
        System.out.println("Max money to rob: " + solution.rob(houses2)); // Expected: 12
    }
}