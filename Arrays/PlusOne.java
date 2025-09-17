package Arrays;

import java.util.Arrays;

/*
 * LeetCode Problem #66: Plus One
 * Link: https://leetcode.com/problems/plus-one/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) in most cases, O(n) for the edge case (e.g., 999 -> 1000).
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Iterate from the last digit to the first
        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9, just increment and we're done.
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // If the digit is 9, it becomes 0, and we "carry the one" to the next digit.
            digits[i] = 0;
        }

        // If the loop finishes, it means all digits were 9 (e.g., [9, 9, 9]).
        // We need a new, larger array (e.g., for 999 -> 1000).
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1; // The first digit is 1, the rest are 0 by default.
        return newNumber;
    }

    public static void main(String[] args) {
        PlusOne solution = new PlusOne();

        int[] digits1 = {1, 2, 3};
        System.out.println("Result for {1, 2, 3}: " + Arrays.toString(solution.plusOne(digits1))); // Expected: [1, 2, 4]

        int[] digits2 = {9, 9, 9};
        System.out.println("Result for {9, 9, 9}: " + Arrays.toString(solution.plusOne(digits2))); // Expected: [1, 0, 0, 0]
    }
}