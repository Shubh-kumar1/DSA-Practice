package Arrays;

import java.util.Arrays;

/*
 * LeetCode Problem #88: Merge Sorted Array
 * Link: https://leetcode.com/problems/merge-sorted-array/
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointer for the last element of nums1
        int p1 = m - 1;
        // Pointer for the last element of nums2
        int p2 = n - 1;
        // Pointer for the last position in the merged array (end of nums1)
        int i = m + n - 1;

        // Iterate backwards from the end of both arrays
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                // If element in nums1 is larger, place it at the end of the merged array
                nums1[i] = nums1[p1];
                p1--;
            } else {
                // If element in nums2 is larger or nums1 is exhausted, place it
                nums1[i] = nums2[p2];
                p2--;
            }
            i--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        System.out.println("Original nums1: " + Arrays.toString(nums1));
        solution.merge(nums1, m, nums2, n);
        System.out.println("Merged array: " + Arrays.toString(nums1)); // Expected: [1, 2, 2, 3, 5, 6]
    }
}