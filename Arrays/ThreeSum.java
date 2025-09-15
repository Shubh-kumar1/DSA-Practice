package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * LeetCode Problem #15: 3Sum
 * Link: https://leetcode.com/problems/3sum/
 *
 * Approach:
 * 1. Sort the input array.
 * 2. Iterate through the array with a primary pointer 'i'.
 * 3. For each 'i', use two additional pointers, 'left' (starts at i+1) and 'right' (starts at the end of the array).
 * 4. Move 'left' and 'right' inwards, calculating the sum and looking for a total of 0.
 * 5. Skip duplicate numbers for all three pointers to ensure the uniqueness of the resulting triplets.
 *
 * Time Complexity: O(n^2) - O(n log n) for sorting + O(n^2) for the nested loops.
 * Space Complexity: O(1) or O(n) - Depending on whether space for the output list is counted.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to enable the two-pointer approach
        Arrays.sort(nums);

        // Iterate with the first pointer, up to the third-to-last element
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (currentSum == 0) {
                    // Found a triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate values for the second element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicate values for the third element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move pointers to find new triplets
                    left++;
                    right--;
                } else if (currentSum < 0) {
                    // Sum is too small, need a larger number
                    left++;
                } else { // currentSum > 0
                    // Sum is too large, need a smaller number
                    right--;
                }
            }
        }
        return result;
    }
}