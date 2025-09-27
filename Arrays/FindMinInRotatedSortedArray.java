package Arrays;

/*
 * LeetCode Problem #153: Find Minimum in Rotated Sorted Array
 * Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // The array is not rotated if the first element is smaller than the last.
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the right element, the pivot (minimum) is in the right half.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // If mid element is less than or equal to the right element, the pivot is in the left half (including mid).
            else {
                right = mid;
            }
        }
        
        // The loop terminates when left and right pointers converge on the minimum element.
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinInRotatedSortedArray solution = new FindMinInRotatedSortedArray();
        
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Minimum is: " + solution.findMin(nums1)); // Expected: 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum is: " + solution.findMin(nums2)); // Expected: 0
    }
}