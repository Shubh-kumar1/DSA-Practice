package Arrays; 
/*
 * LeetCode Problem #1: Two Sum (Brute-Force)
 * Link: https://leetcode.com/problems/two-sum/
 *
 * Approach:
 * Use two nested loops to check every possible pair of numbers. The outer loop
 * picks the first number, and the inner loop checks all subsequent numbers
 * to find a match.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // The outer loop iterates from the first element to the second-to-last
        for (int i = 0; i < nums.length - 1; i++) {
            // The inner loop iterates from the element after 'i' to the end
            for (int j = i + 1; j < nums.length; j++) {
                // Check if the pair sums up to the target
                if (nums[i] + nums[j] == target) {
                    // If it does, return their indices
                    return new int[] { i, j };
                }
            }
        }

        // If no solution is found, throw an exception
        throw new IllegalArgumentException("No two sum solution");
    }
}