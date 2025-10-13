package Arrays;

import java.util.Arrays;

/*
 * LeetCode Problem #31: Next Permutation
 * Link: https://leetcode.com/problems/next-permutation/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // Step 1: Find the first decreasing element from the right (the pivot).
        int k = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }

        // If no such element exists, the array is in descending order. Reverse it.
        if (k == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // Step 2: Find the smallest element to the right of k that's > nums[k].
        int l = -1;
        for (int i = nums.length - 1; i > k; i--) {
            if (nums[i] > nums[k]) {
                l = i;
                break;
            }
        }

        // Step 3: Swap the elements at k and l.
        swap(nums, k, l);

        // Step 4: Reverse the subarray to the right of k.
        reverse(nums, k + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        int[] nums = {1, 2, 3};
        
        System.out.println("Original: " + Arrays.toString(nums));
        solution.nextPermutation(nums);
        System.out.println("Next Permutation: " + Arrays.toString(nums)); // Expected: [1, 3, 2]
    }
}