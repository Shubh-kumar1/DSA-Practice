package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * LeetCode Problem #15: 3Sum
 * This file includes a main method for easy testing.
 */
public class ThreeSum {

    /**
     * Finds all unique triplets in the array which give the sum of zero.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) or O(n) (depending on space for the output list)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to enable the two-pointer approach
        Arrays.sort(nums);

        // Iterate with the first pointer, up to the third-to-last element
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first element to ensure unique triplets
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

                    // Skip duplicate values for the second and third elements
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // Move pointers to find new unique triplets
                    left++;
                    right--;
                } else if (currentSum < 0) {
                    // Sum is too small, need a larger number, so move the left pointer
                    left++;
                } else { // currentSum > 0
                    // Sum is too large, need a smaller number, so move the right pointer
                    right--;
                }
            }
        }
        return result;
    }

    /**
     * The main method acts as the entry point to run and test the code.
     */
    public static void main(String[] args) {
        // 1. Create an instance of the class
        ThreeSum solution = new ThreeSum();

        // 2. Create some sample data to test with
        int[] numbers = {-1, 0, 1, 2, -1, -4};

        // 3. Call the threeSum method with the sample data
        List<List<Integer>> triplets = solution.threeSum(numbers);

        // 4. Print the results to the console
        System.out.println("Found triplets:");
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }
}