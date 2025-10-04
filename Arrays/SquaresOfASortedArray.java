package Arrays;

import java.util.Arrays;

/*
 * LeetCode Problem #977: Squares of a Sorted Array
 * Link: https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) for the result array.
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int left = 0;
        int right = n - 1;
        
        // Fill the result array from the end to the beginning
        for (int i = n - 1; i >= 0; i--) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            
            // Place the larger of the two squares at the end of the result array
            if (leftSquare > rightSquare) {
                result[i] = leftSquare;
                left++;
            } else {
                result[i] = rightSquare;
                right--;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        SquaresOfASortedArray solution = new SquaresOfASortedArray();
        int[] numbers = {-4, -1, 0, 3, 10};
        
        int[] result = solution.sortedSquares(numbers);
        System.out.println("The sorted squares are: " + Arrays.toString(result)); 
        // Expected: [0, 1, 9, 16, 100]
    }
}