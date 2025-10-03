package Arrays;
/*
 * LeetCode Problem #169: Majority Element
 * Link: https://leetcode.com/problems/majority-element/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        
        int[] nums1 = {3, 2, 3};
        System.out.println("The majority element is: " + solution.majorityElement(nums1)); // Expected: 3

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("The majority element is: " + solution.majorityElement(nums2)); // Expected: 2
    }
}
