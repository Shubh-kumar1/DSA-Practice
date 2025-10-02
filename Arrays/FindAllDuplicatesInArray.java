package Arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode Problem #442: Find All Duplicates in an Array
 * Link: https://leetcode.com/problems/find-all-duplicates-in-an-array/
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (excluding the result list)
 */
public class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            // The number `num` should correspond to index `index`.
            int index = Math.abs(nums[i]) - 1;

            // If the number at this index is already negative, it means we have
            // seen the number `index + 1` before, so it's a duplicate.
            if (nums[index] < 0) {
                duplicates.add(index + 1);
            } else {
                // Otherwise, flip the sign of the number at `index` to mark it as seen.
                nums[index] = -nums[index];
            }
        }
        
        return duplicates;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInArray solution = new FindAllDuplicatesInArray();
        int[] numbers = {4, 3, 2, 7, 8, 2, 3, 1};
        
        List<Integer> result = solution.findDuplicates(numbers);
        System.out.println("Duplicates are: " + result); // Expected: [2, 3]
    }
}