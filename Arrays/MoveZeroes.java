package Arrays;

import java.util.Arrays;

/*
 * LeetCode Problem #283: Move Zeroes
 * Link: https://leetcode.com/problems/move-zeroes/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // 'insertPos' tracks the position where the next non-zero element should be placed.
        int insertPos = 0;

        // First pass: move all non-zero elements to the front.
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos] = num;
                insertPos++;
            }
        }

        // Second pass: fill the remaining spots with zeroes.
        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();
        int[] numbers = {0, 1, 0, 3, 12};
        
        System.out.println("Original array: " + Arrays.toString(numbers));
        solution.moveZeroes(numbers);
        System.out.println("Array after moving zeroes: " + Arrays.toString(numbers)); // Expected: [1, 3, 12, 0, 0]
    }
}
