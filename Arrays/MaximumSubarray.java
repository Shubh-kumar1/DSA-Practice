package Arrays;

/*
 * LeetCode Problem #53: Maximum Subarray
 * Link: https://leetcode.com/problems/maximum-subarray/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int currentMax = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // The maximum sum ending at the current position is either the number itself
            // or the number plus the maximum sum ending at the previous position.
            currentMax = Math.max(nums[i], currentMax + nums[i]);

            // Update the overall maximum sum if the current maximum is greater.
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        int[] numbers = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        int result = solution.maxSubArray(numbers);
        System.out.println("The maximum subarray sum is: " + result); // Expected: 6
    }
}