package Arrays;

import java.util.Arrays;

/*
 * LeetCode Problem #26: Remove Duplicates from Sorted Array
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // 'insertIndex' is the position where the next unique element should be placed.
        int insertIndex = 1;

        // Iterate through the array starting from the second element.
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous one, it's unique.
            if (nums[i] != nums[i - 1]) {
                // Place the unique element at the insertIndex position.
                nums[insertIndex] = nums[i];
                // Move the insertIndex forward.
                insertIndex++;
            }
        }
        
        // 'insertIndex' now represents the number of unique elements.
        return insertIndex;
    }

    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();
        int[] numbers = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println("Original array: " + Arrays.toString(numbers));
        int k = solution.removeDuplicates(numbers);
        System.out.println("New length: " + k); // Expected: 5
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < k; i++) {
            System.out.print(numbers[i] + " "); // Expected: 0 1 2 3 4
        }
        System.out.println();
    }
}