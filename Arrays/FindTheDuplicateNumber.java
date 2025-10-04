package Arrays;
/*
 * LeetCode Problem #287: Find the Duplicate Number
 * Link: https://leetcode.com/problems/find-the-duplicate-number/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // Phase 1: Find the intersection point of the two pointers.
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle.
        // Reset one pointer to the start.
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return fast; // or slow, they meet at the duplicate
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber solution = new FindTheDuplicateNumber();
        
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("The duplicate number is: " + solution.findDuplicate(nums1)); // Expected: 2

        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("The duplicate number is: " + solution.findDuplicate(nums2)); // Expected: 3
    }
}
