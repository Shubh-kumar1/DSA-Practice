package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * LeetCode Problem #18: 4Sum
 * Link: https://leetcode.com/problems/4sum/
 *
 * Time Complexity: O(n^3)
 * Space Complexity: O(1) or O(n) (depending on space for the output list)
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        int n = nums.length;

        // First pointer
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Second pointer
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Two-pointer approach for the remaining two numbers
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    // Use long to prevent integer overflow with large numbers
                    long currentSum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (currentSum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Skip duplicates for the third and fourth numbers
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        left++;
                        right--;
                    } else if (currentSum < target) {
                        left++;
                    } else { // currentSum > target
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 1. Create an instance of the class
        FourSum solution = new FourSum();
        
        // 2. Create sample data
        int[] numbers = {1, 0, -1, 0, -2, 2};
        int target = 0;

        // 3. Call the fourSum method
        List<List<Integer>> quadruplets = solution.fourSum(numbers, target);

        // 4. Print the results
        System.out.println("Found quadruplets:");
        for (List<Integer> quad : quadruplets) {
            System.out.println(quad);
        }
    }
}