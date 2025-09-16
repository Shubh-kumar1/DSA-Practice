package Arrays;

import java.util.HashSet;
import java.util.Set;

/*
 * LeetCode Problem #217: Contains Duplicate
 * Link: https://leetcode.com/problems/contains-duplicate/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seenNumbers = new HashSet<>();

        for (int num : nums) {
            // If the number is already in our set, we've found a duplicate.
            if (seenNumbers.contains(num)) {
                return true;
            }
            // Otherwise, add the number to our set of seen numbers.
            seenNumbers.add(num);
        }

        // If we get through the whole loop, no duplicates were found.
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        // Example 1: Contains duplicates
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Does nums1 contain duplicates? " + solution.containsDuplicate(nums1)); // Expected: true

        // Example 2: Does not contain duplicates
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Does nums2 contain duplicates? " + solution.containsDuplicate(nums2)); // Expected: false
    }
}