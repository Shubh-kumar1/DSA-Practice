package Arrays;

import java.util.Arrays;

/*
 * LeetCode Problem #189: Rotate Array
 * Link: https://leetcode.com/problems/rotate-array/
 *
 * Time Complexity: O(n) - Each element is reversed twice.
 * Space Complexity: O(1) - The rotation is done in-place.
 */
public class RotateArray {

    // Main method to rotate the array
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        // Handle cases where k is larger than the array length
        k = k % nums.length;

        // Step 1: Reverse the entire array
        reverse(nums, 0, nums.length - 1);
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Step 3: Reverse the remaining n-k elements
        reverse(nums, k, nums.length - 1);
    }

    // Helper method to reverse a portion of an array
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray solution = new RotateArray();
        
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Original array: " + Arrays.toString(numbers));
        solution.rotate(numbers, k);
        System.out.println("Rotated array:  " + Arrays.toString(numbers)); // Expected: [5, 6, 7, 1, 2, 3, 4]
    }
}