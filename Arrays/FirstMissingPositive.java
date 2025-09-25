package Arrays;
/*
 * LeetCode Problem #41: First Missing Positive
 * Link: https://leetcode.com/problems/first-missing-positive/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Use cyclic sort to place each number in its correct position
        int i = 0;
        while (i < n) {
            int correctIndex = nums[i] - 1;
            // Place nums[i] at its correct index if it's a positive number
            // within the bounds of the array and not already in place.
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIndex]) {
                // Swap
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }

        // Find the first number that is not in its correct place
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // If all numbers from 1 to n are present, the missing one is n + 1
        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive solution = new FirstMissingPositive();
        
        int[] nums1 = {3, 4, -1, 1};
        System.out.println("First missing positive is: " + solution.firstMissingPositive(nums1)); // Expected: 2

        int[] nums2 = {7, 8, 9, 11, 12};
        System.out.println("First missing positive is: " + solution.firstMissingPositive(nums2)); // Expected: 1
    }
}